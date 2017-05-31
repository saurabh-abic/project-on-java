package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import dao.FacultyDao;
import dto.AttendenceDto;
import dto.FacultyDto;
import dto.updateAttendenceDto;

public class FacultyAttendence1 extends JInternalFrame {

	FacultyDao fa;
	String roll[];
	int x=20;
	int totallectue;
	AttendenceDto at;
	FacultyDto ft;
	updateAttendenceDto up;
	public static int update;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyAttendence1 frame = new FacultyAttendence1(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FacultyAttendence1(FacultyDto ft) {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(0,0,FacultyMainPage.WIDTH,FacultyMainPage.HEIGHT);
		getContentPane().setLayout(null);
		
		JLabel lblAttendence = new JLabel("Attendence");
		lblAttendence.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAttendence.setForeground(Color.BLACK);
		lblAttendence.setBounds(183, 11, 116, 21);
		getContentPane().add(lblAttendence);
	
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
	    bi.setNorthPane(null);
	    fa=new FacultyDao();
		at=fa.attendence();
		int count=at.getCount();
		int a=0;
		roll=at.getRoll();
		
		System.out.println(count);
		
		  JRadioButton[] jb=new JRadioButton[10];
	        
	        for(int i=0;i<count;i++)
	        {
	        jb[i]=new JRadioButton(roll[i]);
	        jb[i].setBounds(50,x,100,50);
	        jb[i].setBackground(Color.DARK_GRAY);
	        jb[i].setForeground(Color.BLACK);
	       
	         getContentPane().add(jb[i]);
	         jb[i].setVisible(true);
	       // scrollPane.setViewportView(jb[i]);
	        x=x+50;
	        }
	    	
			JButton btnSubmit = new JButton("Submit");
			btnSubmit.addActionListener(new ActionListener() {
				
				
				
				String[] present=new String[20];
				String[] absent=new String[20];
				int count2=0;
				int count3=0;
				public void actionPerformed(ActionEvent arg0) {
				   update++;
					for(int i=0;i<count;i++)
				{
					if(jb[i].isSelected())
					{
						
					present[count3]=jb[i].getText();
					count3++;
					
					System.out.println("present:"+present[i] );
					}
					else
						{
						absent[count2]=jb[i].getText();
						
						System.out.println("absent:"+absent[count2]);
						count2++;
						}
					}
					
				up=new updateAttendenceDto();
				up.setPresentcount(count3);
				up.setAbsentcount(count2);
				up.setPresent(present);
				up.setAbsent(absent);
				
				String sub=ft.getSub().replace(" ","_");
				count3=0;
				
			    up.setSub(sub);
				
			int flag=fa.updateAttendence(up);
			if(flag==1)
			{
				JOptionPane.showMessageDialog(null, "Attendence Successfully uploaded");
			}
			else  JOptionPane.showMessageDialog(null, "due to some problem Attendence could not be uploaded");
				
				}
			});
			btnSubmit.setBounds(357, 46, 89, 23);
			getContentPane().add(btnSubmit);
			
			JScrollBar scrollBar = new JScrollBar();
			scrollBar.setBounds(461, 0, 23, 470);
			getContentPane().add(scrollBar);
			
			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					update=0;
				dispose();
				
				}
			});
			btnBack.setBounds(357, 102, 89, 23);
			getContentPane().add(btnBack);
	}
}
