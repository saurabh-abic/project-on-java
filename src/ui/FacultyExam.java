package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import dao.FacultyDao;
import dto.FacultyDto;
import dto.MarkDto;

public class FacultyExam extends JInternalFrame {
	private JTextField jt1;
	private JTextField jt2;
	private JTextField jt3; 
	static FacultyDto ft;
	MarkDto mt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyExam frame = new FacultyExam(ft);
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
	public FacultyExam(FacultyDto ft) {
		getContentPane().setBackground(Color.DARK_GRAY);
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
	    bi.setNorthPane(null);
		setBounds(0,0,FacultyMainPage.WIDTH,FacultyMainPage.HEIGHT);
		getContentPane().setLayout(null);
		
		JLabel lblUpdateExamMarks = new JLabel("Update Exam Marks");
		lblUpdateExamMarks.setForeground(Color.BLACK);
		lblUpdateExamMarks.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblUpdateExamMarks.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateExamMarks.setBounds(166, 11, 158, 32);
		getContentPane().add(lblUpdateExamMarks);
		
		JLabel l1 = new JLabel("Enter Roll no.");
		l1.setFont(new Font("Tahoma", Font.BOLD, 11));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setForeground(Color.BLACK);
		l1.setBounds(75, 82, 91, 14);
		getContentPane().add(l1);
		
		jt1 = new JTextField();
		jt1.setBounds(314, 79, 122, 20);
		getContentPane().add(jt1);
		jt1.setColumns(10);
		
		JLabel l2 = new JLabel("Subject");
		l2.setFont(new Font("Tahoma", Font.BOLD, 11));
		l2.setForeground(Color.BLACK);
		l2.setBounds(83, 124, 66, 20);
		getContentPane().add(l2);
		
		jt2 = new JTextField();
		jt2.setEditable(false);
		jt2.setBounds(314, 124, 122, 20);
		getContentPane().add(jt2);
		jt2.setColumns(10);
		
		JLabel l3 = new JLabel("Marks");
		l3.setFont(new Font("Tahoma", Font.BOLD, 11));
		l3.setForeground(Color.BLACK);
		l3.setBounds(83, 174, 46, 14);
		getContentPane().add(l3);
		
		jt3 = new JTextField();
		jt3.setBounds(314, 171, 122, 20);
		getContentPane().add(jt3);
		jt3.setColumns(10);
		
		
		System.out.println(ft.getSub());
		String sub1=ft.getSub();
	    String sub=sub1.replaceAll(" ","");
		jt2.setText(sub);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			String roll=jt1.getText();
		   int mark=Integer.valueOf(jt3.getText());		
			mt=new MarkDto();
			mt.setRoll(roll);
		    mt.setSub(sub);
		    mt.setMark(mark);	
		int i=   new FacultyDao().marks(mt);
		if(i==1)	JOptionPane.showMessageDialog(null,"uploaded sucessfully");
		else  JOptionPane.showMessageDialog(null,"not uploaded sucessfully");
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBounds(128, 235, 89, 23);
		getContentPane().add(btnUpdate);
		
		JLabel lbloutOf = new JLabel("(out of 100)");
		lbloutOf.setForeground(Color.BLACK);
		lbloutOf.setBounds(128, 174, 89, 14);
		getContentPane().add(lbloutOf);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setForeground(Color.BLACK);
		btnBack.setBounds(287, 235, 75, 23);
		getContentPane().add(btnBack);

	}

	
}
