package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.StudentDao;
import dto.StudentDto;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JComboBox comboBox;
	public String State[]={"AndhraPradesh","Bihar","UttarPradesh","DElhi","Maharastra","Jharkhand","Tamilnadu","Keral"};
	public  String Dept[]={"CSE","ME","CIVIL","EN","EC","IT"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					Signup frame = new Signup();
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
	public Signup() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 466);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		contentPane.add(scrollPane);
		
		JLabel lblSignup = new JLabel("SignUp");
		lblSignup.setForeground(new Color(0, 0, 0));
		lblSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignup.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSignup.setBounds(298, 0, 125, 35);
		contentPane.add(lblSignup);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(308, 46, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Roll no.");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(308, 80, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setForeground(Color.BLACK);
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFathersName.setBounds(308, 115, 86, 14);
		contentPane.add(lblFathersName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setBounds(308, 153, 72, 14);
		contentPane.add(lblGender);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(308, 186, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(308, 224, 72, 14);
		contentPane.add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.BLACK);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCity.setBounds(249, 263, 46, 14);
		contentPane.add(lblCity);
		
		JLabel lblNewLabel_2 = new JLabel("State");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(487, 263, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblContactNo = new JLabel("Contact no.");
		lblContactNo.setForeground(Color.BLACK);
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContactNo.setBounds(249, 306, 69, 14);
		contentPane.add(lblContactNo);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(Color.BLACK);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDepartment.setBounds(447, 306, 86, 14);
		contentPane.add(lblDepartment);
		
		textField = new JTextField();
		textField.setBounds(447, 45, 166, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(447, 77, 166, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(447, 112, 166, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnMale = new JRadioButton("MALE");
		rdbtnMale.setForeground(Color.BLACK);
		rdbtnMale.setBackground(Color.GRAY);
		rdbtnMale.setBounds(430, 149, 62, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.setBackground(Color.GRAY);
		rdbtnFemale.setForeground(Color.BLACK);
		rdbtnFemale.setBounds(494, 149, 72, 23);
		contentPane.add(rdbtnFemale);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale); 
		
		textField_3 = new JTextField();
		textField_3.setBounds(447, 183, 166, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(447, 221, 166, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(328, 260, 95, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		 comboBox = new JComboBox(State);
		comboBox.setBounds(539, 262, 153, 17);
		contentPane.add(comboBox);
		
		
		
		textField_6 = new JTextField();
		textField_6.setBounds(328, 303, 95, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox(Dept);
		comboBox_1.setBounds(539, 303, 66, 20);
		contentPane.add(comboBox_1);
		
		Image image1=new ImageIcon(IntroScreen.class.getResource("rsz_signup1.png")).getImage();
		Icon icon =new ImageIcon(image1);
		JLabel l1 = new JLabel(icon);
		l1.setBounds(10, 27, 231, 389);
		contentPane.add(l1);
		
		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				String name=textField.getText();
			//	int Roll=Integer.valueOf(textField_1.getText());
				String Roll=textField_1.getText();
				String fname=textField_2.getText();
				String Password=textField_3.getText();
				String Gender="";
				if(rdbtnMale.isSelected())
				{
					Gender="Male";
				}
				else if(rdbtnFemale.isSelected())
				{
					Gender="Female";
				}
				String Add=textField_4.getText();
		     	 String city=textField_5.getText();
			   // int mob=Integer.valueOf(textField_6.getText());
				String mob=textField_6.getText();
		     	 String State=comboBox.getSelectedItem().toString(); 
				String dept=comboBox_1.getSelectedItem().toString();
			 
			    StudentDto sd=new StudentDto();
			   
		 	sd.setAdd(Add);
			sd.setCity(city);
			sd.setPassword(Password);
			sd.setDept(dept);
			sd.setFname(fname);
			sd.setGender(Gender);
			sd.setMob(mob);
			sd.setName(name);
			sd.setRoll(Roll);
			sd.setState(State);
			StudentDao u=StudentDao.getStudentDao();
			u.insert(sd);
			dispose();
			new StudentLogin().setVisible(true);
			
				
			}
			
		
				
			
		});
		btnSignup.setBounds(386, 349, 95, 24);
		contentPane.add(btnSignup);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBounds(539, 350, 89, 23);
		contentPane.add(btnReset);
		
	
		   
		   getContentPane().add(l1);
	}
}
