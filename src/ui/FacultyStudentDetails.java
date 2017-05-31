package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;


import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import dao.FacultyDao;
import dao.StudentDao;
import dto.FacultyDto;
import dto.StudentDto;

public class FacultyStudentDetails extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static FacultyDto ft;
	static FacultyDao fa;
	static StudentDto st;
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
	private JTextField jt9;
	static FacultyStudentDetails frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new FacultyStudentDetails();
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
	public FacultyStudentDetails() {
		getContentPane().setBackground(Color.DARK_GRAY);
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
	    bi.setNorthPane(null);
		setBounds(0,0,FacultyMainPage.WIDTH,FacultyMainPage.HEIGHT);
		getContentPane().setLayout(null);
		
	
        
        JButton btnBack = new JButton("BACK");
        btnBack.setForeground(Color.BLACK);
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	
        	dispose();}
        });
        btnBack.setBounds(229, 424, 89, 23);
        getContentPane().add(btnBack);
        
        JLabel lblEnterRollNo = new JLabel("Enter Roll no.");
        lblEnterRollNo.setForeground(Color.BLACK);
        lblEnterRollNo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        lblEnterRollNo.setBounds(81, 29, 107, 20);
        getContentPane().add(lblEnterRollNo);
        
        JLabel lblStudentDetails = new JLabel("Student Details");
        lblStudentDetails.setForeground(Color.BLACK);
 		lblStudentDetails.setFont(new Font("Times New Roman", Font.BOLD, 15));
 		lblStudentDetails.setBounds(198, 80, 107, 26);
 		getContentPane().add(lblStudentDetails);
 		
 		JLabel lblName = new JLabel("NAME -");
 		lblName.setForeground(Color.BLACK);
 		lblName.setFont(new Font("Times New Roman", Font.BOLD, 13));
 		lblName.setBounds(59, 120, 96, 14);
 		getContentPane().add(lblName);
 		
 		JLabel lblFathersName = new JLabel("Father's Name");
 		lblFathersName.setForeground(Color.BLACK);
 		lblFathersName.setFont(new Font("Times New Roman", Font.BOLD, 13));
 		lblFathersName.setBounds(59, 151, 96, 14);
 		getContentPane().add(lblFathersName);
 		
 		JLabel lblRollNo = new JLabel("Roll no-");
 		lblRollNo.setForeground(Color.BLACK);
 		lblRollNo.setFont(new Font("Times New Roman", Font.BOLD, 13));
 		lblRollNo.setBounds(59, 181, 82, 20);
 		getContentPane().add(lblRollNo);
 		
 		JLabel lblGender = new JLabel("Gender");
 		lblGender.setForeground(Color.BLACK);
 		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 13));
 		lblGender.setBounds(59, 215, 82, 14);
 		getContentPane().add(lblGender);
 		
 		JLabel lblState = new JLabel("State");
 		lblState.setForeground(Color.BLACK);
 		lblState.setFont(new Font("Times New Roman", Font.BOLD, 13));
 		lblState.setBounds(59, 250, 46, 14);
 		getContentPane().add(lblState);
 		
 		JLabel lblAddress = new JLabel("Address");
 		lblAddress.setForeground(Color.BLACK);
 		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 13));
 		lblAddress.setBounds(59, 317, 46, 14);
 		getContentPane().add(lblAddress);
 		
 		JLabel lblCity = new JLabel("City");
 		lblCity.setForeground(Color.BLACK);
 		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 13));
 		lblCity.setBounds(59, 286, 46, 14);
 		getContentPane().add(lblCity);
 		
 		JLabel lblContactNo = new JLabel("Contact no-");
 		lblContactNo.setForeground(Color.BLACK);
 		lblContactNo.setFont(new Font("Times New Roman", Font.BOLD, 13));
 		lblContactNo.setBounds(59, 348, 82, 14);
 		getContentPane().add(lblContactNo);
 		
 		JLabel lblNewLabel = new JLabel("Dept");
 		lblNewLabel.setForeground(Color.BLACK);
 		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
 		lblNewLabel.setBounds(59, 379, 46, 14);
 		getContentPane().add(lblNewLabel);
 		
 		textField = new JTextField();
 		textField.setEditable(false);
 		textField.setText("0");
 		textField.setBounds(293, 117, 160, 20);
 		getContentPane().add(textField);
 		textField.setColumns(10);
 		
 		textField_1 = new JTextField();
 		textField_1.setText("0");
 		textField_1.setEditable(false);
 		textField_1.setBounds(293, 148, 160, 20);
 		getContentPane().add(textField_1);
 		textField_1.setColumns(10);
 		
 		textField_2 = new JTextField();
 		textField_2.setText("0");
 		textField_2.setEditable(false);
 		textField_2.setBounds(293, 181, 161, 20);
 		getContentPane().add(textField_2);
 		textField_2.setColumns(10);
 		
 		textField_3 = new JTextField();
 		textField_3.setText("0");
 		textField_3.setEditable(false);
 		textField_3.setBounds(293, 212, 160, 20);
 		getContentPane().add(textField_3);
 		textField_3.setColumns(10);
 		
 		textField_4 = new JTextField();
 		textField_4.setText("0");
 		textField_4.setEditable(false);
 		textField_4.setBounds(291, 247, 162, 20);
 		getContentPane().add(textField_4);
 		textField_4.setColumns(10);
 		
 		textField_5 = new JTextField();
 		textField_5.setText("0");
 		textField_5.setEditable(false);
 		textField_5.setBounds(293, 283, 160, 20);
 		getContentPane().add(textField_5);
 		textField_5.setColumns(10);
 		
 		textField_6 = new JTextField();
 		textField_6.setText("0");
 		textField_6.setEditable(false);
 		textField_6.setBounds(293, 314, 160, 20);
 		getContentPane().add(textField_6);
 		textField_6.setColumns(10);
 		
 		textField_7 = new JTextField();
 		textField_7.setText("0");
 		textField_7.setEditable(false);
 		textField_7.setBounds(293, 345, 159, 20);
 		getContentPane().add(textField_7);
 		textField_7.setColumns(10);
 		
 		textField_8 = new JTextField();
 		textField_8.setText("0");
 		textField_8.setEditable(false);
 		textField_8.setBounds(293, 376, 159, 20);
 		getContentPane().add(textField_8);
 		textField_8.setColumns(10);
 	
        
        jt9 = new JTextField();
        jt9.setBounds(198, 30, 107, 20);
        getContentPane().add(jt9);
        jt9.setColumns(10);
        
        JButton btnSearch = new JButton(" Search");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	   //  fa=new FacultyDao(); 
        	   //  st= new FacultyDao().studentSearch(roll);
        	   // fa=FacultyDao.getFacultyDao();
        	     
        	     String roll=jt9.getText();
             st=FacultyDao.studentSearch(roll);
              
          
            textField.setText(st.getName());
            textField_1.setText(st.getFname());
       		textField_2.setText(st.getRoll());
       		textField_3.setText(st.getGender());
       		textField_4.setText(st.getState());
       		textField_5.setText(st.getCity());
       		textField_6.setText(st.getAdd());
       		textField_7.setText(st.getMob());
       		textField_8.setText(st.getDept());
                 
        	}
        });
       
    	
    	
        btnSearch.setForeground(Color.BLACK);
        btnSearch.setBounds(315, 29, 89, 23);
        getContentPane().add(btnSearch);
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		    textField.setText("");
                    textField_1.setText("");
            		textField_2.setText("");
            		textField_3.setText("");
            		textField_4.setText("");
            		textField_5.setText("");
            		textField_6.setText("");
            		textField_7.setText("");
            		textField_8.setText("");
        	        jt9.setText("");
        	}
        });
        btnClear.setForeground(Color.BLACK);
        btnClear.setBounds(408, 29, 76, 23);
        getContentPane().add(btnClear);
        
        
       
            }
	}



