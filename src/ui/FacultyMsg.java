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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import dao.FacultyDao;
import dto.FacultyDto;

public class FacultyMsg extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyMsg frame = new FacultyMsg(null);
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
	public FacultyMsg(FacultyDto ft) {
		setBounds(0,0,FacultyMainPage.WIDTH,FacultyMainPage.HEIGHT);
		getContentPane().setLayout(null);
		
		JLabel lblMesseege = new JLabel("Messeege");
		lblMesseege.setBounds(197, 11, 108, 35);
		lblMesseege.setForeground(Color.BLACK);
		lblMesseege.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesseege.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(lblMesseege);
		
		JLabel lblEnterMsg = new JLabel("Enter msg");
		lblEnterMsg.setBounds(45, 68, 69, 27);
		getContentPane().add(lblEnterMsg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(156, 68, 299, 127);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(156, 69, 299, 126);
		scrollPane.add(textArea);
		scrollPane.setViewportView(textArea);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String msg=textArea.getText()+" - "+ft.getName();
				String roll=textField.getText();
				if(msg.equals(null)&&roll.equals(null))
				{
					JOptionPane.showMessageDialog(null, "Enter all the fileds");
				}
				FacultyDao fa=new FacultyDao();
				int i=fa.facultyMsg(msg,roll);
				if(i==1)
				{
					JOptionPane.showMessageDialog(null, "msg send");
					textField.setText("");
					textArea.setText("");
				}
				else  JOptionPane.showMessageDialog(null, "msg could not be send");
			}
		});
		btnSend.setBounds(181, 261, 69, 23);
		getContentPane().add(btnSend);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnBack.setBounds(336, 261, 69, 23);
		getContentPane().add(btnBack);
		
		JLabel lblEnterRoll = new JLabel("Enter roll");
		lblEnterRoll.setBounds(40, 227, 79, 14);
		getContentPane().add(lblEnterRoll);
		
		textField = new JTextField();
		textField.setBounds(164, 217, 116, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
             BasicInternalFrameUI fi=(BasicInternalFrameUI)this.getUI();
             fi.setNorthPane(null);
             
	}
}
