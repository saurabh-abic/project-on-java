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
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import dao.FacultyDao;

public class AdminMsg extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMsg frame = new AdminMsg();
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
	public AdminMsg() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(0, 0, AdminMainPage.WIDTH, AdminMainPage.HEIGHT);
		getContentPane().setLayout(null);
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
	    bi.setNorthPane(null);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setForeground(Color.BLACK);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMessage.setBounds(180, 30, 109, 27);
		getContentPane().add(lblMessage);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(98, 92, 349, 202);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(159, 332, 130, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSendTo = new JLabel("Send to");
		lblSendTo.setForeground(Color.BLACK);
		lblSendTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSendTo.setBounds(39, 335, 79, 14);
		getContentPane().add(lblSendTo);
		
		JLabel lblWriteLabelInto = new JLabel("Write everyone into textfield for sending the msg to all students");
		lblWriteLabelInto.setForeground(Color.BLACK);
		lblWriteLabelInto.setBounds(39, 384, 356, 14);
		getContentPane().add(lblWriteLabelInto);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String msg=textArea.getText()+"-admin";
			String send=textField.getText();
			System.out.println(msg);
			int i=	new FacultyDao().facultyMsg(msg,send);
			if(i==1)
			{
				JOptionPane.showMessageDialog(null, "msg send successfully to all");
			   textArea.setText("");
			   textField.setText("");
			}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(124, 418, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(302, 418, 89, 23);
		getContentPane().add(btnNewButton_1);
		

	}
}
