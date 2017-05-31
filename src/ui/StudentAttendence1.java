package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import dao.StudentDao;
import dto.StudentAttendenceDto;
import dto.StudentDto;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentAttendence1 extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	//private JTable(Object[][] rows, Object[] columns);
	
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAttendence1 frame = new StudentAttendence1(null);
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
	public StudentAttendence1(StudentDto sdt) {
		getContentPane().setBackground(Color.WHITE);
		setBounds(0,0,StudentMainPage.WIDTH,StudentMainPage.HEIGHT);
		getContentPane().setLayout(null);
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
	    bi.setNorthPane(null);
	//    JScrollPane js=new JScrollPane();
	  //  getContentPane().add(js);
		StudentAttendenceDto sa=new StudentDao().studentAttendence(sdt.getRoll());
		
		String data[][]={{"Data Mining",String.valueOf(sa.getDm()),String.valueOf(sa.getTdm())},
				{"Compiler Design",String.valueOf(sa.getCd()),String.valueOf(sa.getTcd())},
		{"Software Engineering",String.valueOf(sa.getSe()),String.valueOf(sa.getTse())},
		{"Computer Network",String.valueOf(sa.getCn()),String.valueOf(sa.getTcn())},
		{"Industrial management",String.valueOf(sa.getIm()),String.valueOf(sa.getTim())},
		{"Parallel Algo",String.valueOf(sa.getPa()),String.valueOf(sa.getTpa())}};
		
		String coloum[]={"subject","Present","total lecture"};
		JTable table = new JTable(data,coloum);
		table.getColumnModel().getColumn(0).setPreferredWidth(124);
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(277, 354, 89, 23);
		getContentPane().add(btnBack);
		
		JLabel lblTotalLecture_1 = new JLabel("Total Lecture");
		lblTotalLecture_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalLecture_1.setBounds(49, 261, 86, 14);
		getContentPane().add(lblTotalLecture_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 258, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(206, 203, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(String.valueOf(sa.getCd()+sa.getCn()+sa.getDm()+sa.getIm()+sa.getPa()+sa.getSe()));
		textField_1.setText(String.valueOf(sa.getTcd()+sa.getTcn()+sa.getTdm()+sa.getIm()+sa.getTpa()+sa.getTse()));
		
		
		JLabel lblTotalPresent = new JLabel("Total Present");
		lblTotalPresent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalPresent.setForeground(Color.BLACK);
		lblTotalPresent.setBounds(49, 206, 108, 14);
		getContentPane().add(lblTotalPresent);
		table.setBounds(10, 67, 574, 403);
		getContentPane().add(table);
		
	//	js.add(table);
		//js.setViewportView(table);
		table.setFillsViewportHeight(true); 
		JLabel lblYourAttendence = new JLabel("Your Attendence");
		lblYourAttendence.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYourAttendence.setForeground(Color.BLACK);
		lblYourAttendence.setBounds(235, 11, 146, 14);
		getContentPane().add(lblYourAttendence);
		
		JLabel lblLectureAttend = new JLabel("Lecture Attend");
		lblLectureAttend.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLectureAttend.setBounds(222, 42, 98, 14);
		getContentPane().add(lblLectureAttend);
		
		JLabel lblTotalLecture = new JLabel("Total Lecture");
		lblTotalLecture.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalLecture.setBounds(434, 42, 98, 14);
		getContentPane().add(lblTotalLecture);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSubject.setBounds(27, 42, 46, 14);
		getContentPane().add(lblSubject);

	}
}
