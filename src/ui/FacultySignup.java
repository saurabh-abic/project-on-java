package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.FacultyDao;
import dto.FacultyDto;

public class FacultySignup extends JFrame {

	FacultyDto ft;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public String State[]={"AndhraPradesh","Bihar","UttarPradesh","DElhi","Maharastra","Jharkhand","Tamilnadu","Keral"};
	public  String Dept[]={"CSE","ME","CIVIL","EN","EC","IT"};
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultySignup frame = new FacultySignup();
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
	public FacultySignup() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 567);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		contentPane.add(scrollPane);
		setLocationRelativeTo(null);
		
		
		
		JLabel lblName = new JLabel("Faculty Name");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(308, 46, 95, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Faculty ID");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(308, 80, 86, 14);
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
		lblCity.setBounds(308, 263, 46, 14);
		contentPane.add(lblCity);
		
		JLabel lblNewLabel_2 = new JLabel("State");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(311, 353, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblContactNo = new JLabel("Contact no.");
		lblContactNo.setForeground(Color.BLACK);
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContactNo.setBounds(311, 306, 69, 14);
		contentPane.add(lblContactNo);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(Color.BLACK);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDepartment.setBounds(308, 399, 86, 14);
		contentPane.add(lblDepartment);
		
		textField = new JTextField();
		textField.setBounds(509, 44, 166, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(509, 77, 166, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(509, 112, 166, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnMale = new JRadioButton("MALE");
		rdbtnMale.setForeground(Color.BLACK);
		rdbtnMale.setBackground(Color.GRAY);
		rdbtnMale.setBounds(499, 149, 62, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.setBackground(Color.GRAY);
		rdbtnFemale.setForeground(Color.BLACK);
		rdbtnFemale.setBounds(603, 149, 72, 23);
		contentPane.add(rdbtnFemale);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale); 
		
		textField_3 = new JTextField();
		textField_3.setBounds(509, 183, 166, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(509, 221, 166, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(509, 260, 166, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox = new JComboBox(State);
		comboBox.setBounds(509, 344, 153, 17);
		contentPane.add(comboBox);
		
		
		
		textField_6 = new JTextField();
		textField_6.setBounds(509, 303, 166, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox(Dept);
		comboBox_1.setBounds(510, 396, 66, 20);
		contentPane.add(comboBox_1);
		Image image1=new ImageIcon(IntroScreen.class.getResource("rsz_signup1.png")).getImage();
		Icon icon =new ImageIcon(image1);
		JLabel l1 = new JLabel(icon);
		l1.setBounds(10, 37, 231, 461);
		contentPane.add(l1);
		
		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				String name=textField.getText();
			//	int Roll=Integer.valueOf(textField_1.getText());
				String id=textField_1.getText();
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
			   String mob1=textField_6.getText();
		     	if(mob1.equals(""))
		     	{mob1="0";}
		     		  long mob=0;
		    	 mob=Long.valueOf(mob1).longValue();
			 	String State=comboBox.getSelectedItem().toString(); 
				String dept=comboBox_1.getSelectedItem().toString();
				String sub=textField_7.getText();
			 
			   
			if(name.equals("")||Add.equals("")||city.equals("")||Password.equals("")||fname.equals("")||Gender.equals("")||id.equals("")||mob1.equals("0")||sub.equals(""))
			{
				JOptionPane.showMessageDialog(null,"enter all the fields");
			}
			else
			{
				 FacultyDto ft=new FacultyDto();
				   System.out.println("here");
				 	ft.setAdd(Add);
					ft.setCity(city);
					ft.setPassword(Password);
					ft.setDept(dept);
					ft.setFname(fname);
					ft.setGender(Gender);
					ft.setMob(mob);
					ft.setName(name);
					ft.setId(id);
					ft.setState(State);
					ft.setSub(sub);
					FacultyDao u=FacultyDao.getFacultyDao();
					//FacultyDao fa=new FacultyDao();
			u.insert(ft);
			dispose();
			new FacultyLogin().setVisible(true);
			
			}	
			}
			
		
				
			
		});
		btnSignup.setBounds(332, 503, 95, 24);
		contentPane.add(btnSignup);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBounds(524, 504, 89, 23);
		contentPane.add(btnReset);
		
	
		   
		   getContentPane().add(l1);
		
		JLabel lblFacultySignup = new JLabel("Faculty Signup");
		lblFacultySignup.setForeground(Color.BLACK);
		lblFacultySignup.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFacultySignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacultySignup.setBounds(264, 17, 116, 18);
		contentPane.add(lblFacultySignup);
		
		JLabel lblBranch = new JLabel("Subject");
		lblBranch.setForeground(Color.BLACK);
		lblBranch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBranch.setBounds(308, 447, 72, 14);
		contentPane.add(lblBranch);
		
		textField_7 = new JTextField();
		textField_7.setBounds(509, 441, 153, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
	}
}
