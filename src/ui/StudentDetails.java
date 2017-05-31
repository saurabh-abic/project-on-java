package ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import dao.StudentDao;
import dto.StudentDto;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentDetails extends JInternalFrame {
	static StudentDto sd;
	static StudentDao sa;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails frame = new StudentDetails(sd);
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
  public StudentDetails(StudentDto sd) 
  {
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
	    bi.setNorthPane(null);
		setBounds(0,0,StudentMainPage.WIDTH,StudentMainPage.HEIGHT);
		getContentPane().setLayout(null);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblStudentDetails.setBounds(258, 11, 107, 26);
		getContentPane().add(lblStudentDetails);
		
		JLabel lblName = new JLabel("NAME -");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblName.setBounds(59, 58, 96, 14);
		getContentPane().add(lblName);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblFathersName.setBounds(59, 88, 96, 14);
		getContentPane().add(lblFathersName);
		
		JLabel lblRollNo = new JLabel("Roll no-");
		lblRollNo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblRollNo.setBounds(59, 113, 82, 20);
		getContentPane().add(lblRollNo);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblGender.setBounds(59, 151, 82, 14);
		getContentPane().add(lblGender);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblState.setBounds(59, 176, 46, 14);
		getContentPane().add(lblState);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAddress.setBounds(59, 250, 46, 14);
		getContentPane().add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCity.setBounds(59, 215, 46, 14);
		getContentPane().add(lblCity);
		
		JLabel lblContactNo = new JLabel("Contact no-");
		lblContactNo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblContactNo.setBounds(59, 275, 82, 14);
		getContentPane().add(lblContactNo);
		
		JLabel lblNewLabel = new JLabel("Dept");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(59, 305, 46, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
	   textField.setEditable(false);
		textField.setBounds(293, 55, 160, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(293, 85, 160, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(293, 116, 161, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(293, 145, 160, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(293, 173, 162, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(293, 212, 160, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(293, 244, 160, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(294, 272, 159, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(293, 302, 159, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
   
        textField.setText(sd.getName());
        textField_1.setText(sd.getFname());
         textField_2.setText(sd.getRoll());
        textField_3.setText(sd.getGender());
        textField_4.setText(sd.getState());
        textField_5.setText(sd.getCity());
        textField_6.setText(sd.getAdd());
        textField_7.setText(sd.getMob());
        textField_8.setText(sd.getDept());
        
        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	sd.setFname(textField_1.getText());
        	sd.setState(textField_4.getText());
        	sd.setCity(textField_5.getText());
        	sd.setAdd(textField_6.getText());
        	//StudentDao u=new StudentDao(); it also
        	StudentDao u=StudentDao.getStudentDao();
        	
			int i=u.updateStudent(sd);
			if(i==1) JOptionPane.showMessageDialog(null, "your data has been updated successfully");
			else JOptionPane.showMessageDialog(null, "your data has not been updated successfully");
        	}
        });
        btnUpdate.setBounds(154, 382, 89, 23);
        getContentPane().add(btnUpdate);
        
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	
        	dispose();}
        });
        btnBack.setBounds(301, 382, 89, 23);
        getContentPane().add(btnBack);
       // textField_9.setText(t);
            }
}



