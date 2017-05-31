package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class StudentAttendence extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAttendence frame = new StudentAttendence();
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
	public StudentAttendence() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(0,0,StudentMainPage.WIDTH,StudentMainPage.HEIGHT);
		getContentPane().setLayout(null);
		
		JLabel lblYourAttendence = new JLabel("Your Attendence");
		lblYourAttendence.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYourAttendence.setBounds(213, 11, 130, 24);
		getContentPane().add(lblYourAttendence);
		
		JLabel lblRollNo = new JLabel("Roll no-");
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRollNo.setBounds(118, 45, 74, 20);
		getContentPane().add(lblRollNo);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(305, 46, 149, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 105, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(414, 105, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(118, 148, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(414, 148, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(118, 194, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(414, 194, 86, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(118, 244, 86, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(414, 244, 86, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(118, 289, 86, 20);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(414, 289, 86, 20);
		getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(118, 341, 86, 20);
		getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(414, 341, 86, 20);
		getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblDataMinig = new JLabel("Data Minig");
		lblDataMinig.setBounds(10, 108, 46, 14);
		getContentPane().add(lblDataMinig);
		
		JLabel lblCompilerDesign = new JLabel("Compiler Design");
		lblCompilerDesign.setBounds(10, 151, 46, 14);
		getContentPane().add(lblCompilerDesign);
		
		JLabel lblComputerNetwork = new JLabel("Computer Network");
		lblComputerNetwork.setBounds(10, 197, 46, 14);
		getContentPane().add(lblComputerNetwork);
         JRadioButton[] jb=new JRadioButton[10];
         
             	
	}
}
