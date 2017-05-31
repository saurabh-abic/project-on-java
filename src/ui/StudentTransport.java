package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import dao.StudentDao;
import dto.StudentDto;
import dto.StudentTransportDto;

public class StudentTransport extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public StudentTransport(StudentDto st) {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(0,0,StudentMainPage.WIDTH,StudentMainPage.HEIGHT);
		getContentPane().setLayout(null);
		
		BasicInternalFrameUI fi=(BasicInternalFrameUI)this.getUI();
        fi.setNorthPane(null);
        
		JLabel lblTranportDetails = new JLabel("Transport Details");
		lblTranportDetails.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTranportDetails.setBackground(Color.DARK_GRAY);
		lblTranportDetails.setForeground(Color.BLACK);
		lblTranportDetails.setBounds(242, 22, 126, 14);
		getContentPane().add(lblTranportDetails);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setForeground(Color.BLACK);
		lblName.setBounds(120, 75, 70, 14);
		getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(333, 72, 132, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setForeground(Color.BLACK);
		lblBranch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBranch.setBounds(120, 120, 70, 14);
		getContentPane().add(lblBranch);
		
		JLabel lblPickup = new JLabel(" pickup");
		lblPickup.setForeground(Color.BLACK);
		lblPickup.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPickup.setBounds(120, 219, 70, 14);
		getContentPane().add(lblPickup);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(333, 117, 132, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(333, 167, 132, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Roll no-");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(120, 170, 60, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(333, 216, 132, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField.setText(st.getName());
		textField_1.setText(st.getDept());
		textField_2.setText(st.getRoll());
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pickup=textField_3.getText();
				String name=textField.getText();
				String roll=textField_2.getText();
				//String branch=textField_1.getText();
				if(pickup.equals(null)&&name.equals(null)&&roll.equals(null))
				{
					JOptionPane.showMessageDialog(null, "enter pickup field");
				}
				else
				{
				StudentTransportDto stt=new StudentTransportDto();
				stt.setName(textField.getText());
				stt.setBranch(textField_1.getText());
				stt.setRoll(textField_2.getText());
				stt.setPickup(pickup);
			int i=new StudentDao().studentTransport(stt);
					if(i==0){
						JOptionPane.showMessageDialog(null, "data not uplaoded");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "data sends to admin");
						stt.setName("");
						stt.setBranch("");
						stt.setRoll(""); 
						stt.setPickup("");
					}
				}
			}
		});

		
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnSubmit.setBounds(151, 305, 89, 23);
		getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnBack.setBounds(361, 305, 89, 23);
		getContentPane().add(btnBack);
		
		JLabel lblYourRequestWill = new JLabel("Your request will process within 2 days for  further details contact to admin in admin block");
		lblYourRequestWill.setForeground(Color.BLACK);
		lblYourRequestWill.setBounds(10, 367, 469, 51);
		getContentPane().add(lblYourRequestWill);
		
		JLabel lblSubmitTheFees = new JLabel("Submit the fees for transport services in account office");
		lblSubmitTheFees.setForeground(Color.BLACK);
		lblSubmitTheFees.setBounds(10, 429, 408, 14);
		getContentPane().add(lblSubmitTheFees);
         
        
        
}	
}

	
