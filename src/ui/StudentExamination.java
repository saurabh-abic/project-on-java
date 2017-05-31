package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JTextField;
import javax.swing.JButton;

public class StudentExamination extends JInternalFrame {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentExamination frame = new StudentExamination();
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
	public StudentExamination() {
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
	    bi.setNorthPane(null);
		setBounds(0,0,StudentMainPage.WIDTH,StudentMainPage.HEIGHT);
		getContentPane().setLayout(null);
		
		JLabel lblExaminationDetails = new JLabel("Examination Details");
		lblExaminationDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblExaminationDetails.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblExaminationDetails.setBounds(214, 11, 175, 21);
		getContentPane().add(lblExaminationDetails);
		
		JLabel l1 = new JLabel("");
		l1.setBounds(50, 75, 46, 14);
		getContentPane().add(l1);
		
		JLabel l2 = new JLabel("");
		l2.setBounds(50, 128, 46, 14);
		getContentPane().add(l2);
		
		JLabel l3 = new JLabel("");
		l3.setBounds(50, 167, 46, 14);
		getContentPane().add(l3);
		
		JLabel l4 = new JLabel("");
		l4.setBounds(65, 213, 46, 14);
		getContentPane().add(l4);
		
		t1 = new JTextField();
		t1.setBounds(413, 75, 86, 20);
		getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(413, 123, 86, 20);
		getContentPane().add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(413, 167, 86, 20);
		getContentPane().add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(413, 213, 86, 20);
		getContentPane().add(t4);
		t4.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(237, 387, 89, 23);
		getContentPane().add(btnBack);
		
		JLabel l5 = new JLabel("");
		l5.setBounds(50, 273, 46, 14);
		getContentPane().add(l5);
		
		JLabel l6 = new JLabel("");
		l6.setBounds(50, 324, 46, 14);
		getContentPane().add(l6);
		
		t5 = new JTextField();
		t5.setBounds(413, 270, 86, 20);
		getContentPane().add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(413, 321, 86, 20);
		getContentPane().add(t6);
		t6.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(178, 43, 194, 14);
		getContentPane().add(lblNewLabel);

	}
}
