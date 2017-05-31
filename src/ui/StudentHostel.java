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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import dao.StudentDao;
import dto.StudentDto;

public class StudentHostel extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHostel frame = new StudentHostel(null);
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
	public StudentHostel(StudentDto sdt) {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(0,0,StudentMainPage.WIDTH,StudentMainPage.HEIGHT);
		getContentPane().setLayout(null);
		BasicInternalFrameUI fi=(BasicInternalFrameUI)this.getUI();
        fi.setNorthPane(null);
		
		JLabel lblHostelComplaintBox = new JLabel("Hostel Complaint Portal");
		lblHostelComplaintBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHostelComplaintBox.setForeground(Color.BLACK);
		lblHostelComplaintBox.setBounds(225, 26, 162, 27);
		getContentPane().add(lblHostelComplaintBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(158, 64, 395, 197);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(161, 299, 119, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblComplaint = new JLabel("Complaint");
		lblComplaint.setForeground(Color.BLACK);
		lblComplaint.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComplaint.setBounds(25, 74, 72, 27);
		getContentPane().add(lblComplaint);
		
		JLabel lblRollNo = new JLabel("Roll No.");
		lblRollNo.setForeground(Color.BLACK);
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRollNo.setBounds(25, 301, 72, 14);
		getContentPane().add(lblRollNo);
		
		textField.setText(sdt.getRoll());
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String msg=textArea.getText();
			String roll=textField.getText();
			if(msg.equals(null)&&roll.equals(null))
			{
				JOptionPane.showMessageDialog(null, "enter all the fields");
				
			}
			else
			{
				int i=new StudentDao().studentHostel(roll,msg);
			    if(i==1){ JOptionPane.showMessageDialog(null, "successfully send");
				textArea.setText("");
				}
			    
			    }
			
			}
		});
	
		btnSubmit.setBounds(158, 344, 89, 23);
		getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.BLACK);
		btnBack.addActionListener((e)->dispose());
		btnBack.setBounds(371, 344, 89, 23);
		getContentPane().add(btnBack);
		
		JLabel lblYourRequestWill = new JLabel("Your request will process within 2 days for  further details contact to chief wardon");
		lblYourRequestWill.setForeground(Color.BLACK);
		lblYourRequestWill.setBounds(25, 378, 469, 37);
		getContentPane().add(lblYourRequestWill);

	}
}
