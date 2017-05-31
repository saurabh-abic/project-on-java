package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import dao.StudentDao;
import dto.StudentDto;
import dto.StudentMarkDto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentExam extends JInternalFrame {
	static StudentDto sdt;
	int x=92;
	int y=115;
	int count=0;
	StudentMarkDto mt;
	//String[] sub=new String[10];
	//String[] mark=new String[7];
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentExam frame = new StudentExam(sdt);
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
	
	public StudentExam(StudentDto sdt) {
		  String roll=sdt.getRoll();
          mt=StudentDao.studentMarks(roll); 
		   String[]  mark=mt.getMark();
		   String[] sub=mt.getSub();
         
		   count=mt.getSet();
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
	    bi.setNorthPane(null);
		
		JLabel lblYourMarks = new JLabel("Your Marks");
		lblYourMarks.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYourMarks.setForeground(Color.BLACK);
		lblYourMarks.setBounds(253, 23, 86, 23);
		getContentPane().add(lblYourMarks);
		
			 for(int i=0;i<count;i++)
			 {
				 System.out.println(mark[i]);
				 System.out.println(sub[i]);
			 }
			
		JLabel[] label=new JLabel[count]; 
		JTextField[] field=new JTextField[count];
		for(int i=1;i<count;i++)
		{
			label[i] = new JLabel();
			
		    label[i].setBounds(127, x, 145, 14);
		    label[i].setForeground(Color.BLACK);
			getContentPane().add(label[i]);
			label[i].setText(sub[i]);
		    
		    // y=y+20;
	       field[i]=new JTextField();
	       field[i].setEditable(false);
		   field[i].setBounds(336, x, 86, 20);
		   getContentPane().add(field[i]);
		   field[i].setColumns(10);
		   field[i].setText(mark[i]);
		   x=x+45;
		}
	
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			
			}
		});
		btnBack.setBounds(251, 406, 76, 23);
		getContentPane().add(btnBack);
		setBounds(0,0,StudentMainPage.WIDTH,StudentMainPage.HEIGHT);
            
	}
}
