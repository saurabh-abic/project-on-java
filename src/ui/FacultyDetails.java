package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import dao.FacultyDao;
import dto.FacultyDto;
import java.awt.Color;

public class FacultyDetails extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static FacultyDto ft;;
	static FacultyDao fa;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyDetails frame = new FacultyDetails(ft);
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
	public FacultyDetails(FacultyDto ft) {
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
	    bi.setNorthPane(null);
		setBounds(0,0,FacultyMainPage.WIDTH,FacultyMainPage.HEIGHT);
		getContentPane().setLayout(null);
		
		JLabel lblStudentDetails = new JLabel("Faculty Details");
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
		
		JLabel lblRollNo = new JLabel("Faculty Id");
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
		
		 JLabel lblPassword = new JLabel("Password");
	        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
	        lblPassword.setBounds(59, 341, 82, 14);
	        getContentPane().add(lblPassword);
	        
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
		
		 
        textField_9 = new JTextField();
        textField_9.setBounds(293, 338, 160, 20);
        getContentPane().add(textField_9);
        textField_9.setColumns(10);
        
        textField_10 = new JTextField();
        textField_10.setEditable(false);
        textField_10.setBounds(296, 382, 150, 20);
        getContentPane().add(textField_10);
        textField_10.setColumns(10);
   
		
        textField.setText(ft.getName());
        textField_1.setText(ft.getFname());
        textField_2.setText(ft.getId());
        textField_3.setText(ft.getGender());
        textField_4.setText(ft.getState());
        textField_5.setText(ft.getCity());
        textField_6.setText(ft.getAdd());
        textField_7.setText(String.valueOf(ft.getMob()));
        textField_8.setText(ft.getDept());
        textField_9.setText(ft.getPassword());
        textField_10.setText(ft.getSub());
       
        
        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	ft.setFname(textField_1.getText());
        	ft.setState(textField_4.getText());
        	ft.setCity(textField_5.getText());
        	ft.setAdd(textField_6.getText());
        	ft.setPassword(textField_9.getText());
        	
        	FacultyDao u=new FacultyDao(); //it also
        //	FacultyDao u=FacultyDao.getFacultyDao();
           int i= u.updateFaculty(ft);
           if(i==1){
        	   JOptionPane.showMessageDialog(null, "your Data has been updated");
           }
           else     JOptionPane.showMessageDialog(null, "your Data has not been updated");
        	}
        }); 
        btnUpdate.setBounds(122, 418, 89, 23);
        getContentPane().add(btnUpdate);
        
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	
        	dispose();
        	}
        });
        btnBack.setBounds(293, 418, 89, 23);
        getContentPane().add(btnBack);
        
        JLabel lblSubject = new JLabel("Subject");
        lblSubject.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblSubject.setForeground(Color.BLACK);
        lblSubject.setBounds(59, 385, 46, 14);
        getContentPane().add(lblSubject);
        
      
        
       
       
       // textField_9.setText(t);
            }
}
