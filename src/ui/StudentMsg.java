package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import dao.StudentDao;
import dto.StudentDto;
import dto.StudentMsgDto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentMsg extends JInternalFrame {

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMsg frame = new StudentMsg(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentMsg(StudentDto sdt) {
		setBounds(0,0,StudentMainPage.WIDTH,StudentMainPage.HEIGHT);
		getContentPane().setLayout(null);
		BasicInternalFrameUI fi=(BasicInternalFrameUI)this.getUI();
        fi.setNorthPane(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(155, 70, 295, 98);
		getContentPane().add(scrollPane);
		

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(155, 225, 295, 110);
		getContentPane().add(scrollPane_1);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setForeground(Color.BLACK);
		lblMessage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMessage.setBounds(267, 22, 90, 18);
		getContentPane().add(lblMessage);
		
		JLabel lblMessageForAll = new JLabel("Message for all");
		lblMessageForAll.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMessageForAll.setBounds(23, 70, 122, 27);
		getContentPane().add(lblMessageForAll);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(155, 72, 295, 96);
		scrollPane.add(textArea);
		scrollPane.setViewportView(textArea);
		
		JLabel lblMessageForYou = new JLabel("Message for you");
		lblMessageForYou.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMessageForYou.setBounds(10, 237, 122, 27);
		getContentPane().add(lblMessageForYou);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(155, 226, 295, 110);
		scrollPane_1.add(textArea_1);
		scrollPane_1.setViewportView(textArea_1);
		
		StudentDao sa=new StudentDao();
		StudentMsgDto smt=sa.studentMsg(sdt.getRoll());
		textArea.setText(smt.getAmsg());
		textArea.setText(smt.getAmsg()+" \n "+smt.getAAmsg());
		textArea_1.setText(smt.getMsg());
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(325, 387, 89, 23);
		getContentPane().add(btnBack);

	}

}
