package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import dao.StudentDao;
import dto.StudentDto;

public class StudentLogin extends JFrame {

	private JPanel contentPane;
	private JTextField jt1;
	private JPasswordField jp1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					StudentLogin frame = new StudentLogin();
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
	public StudentLogin() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 309);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentLogin = new JLabel("STUDENT LOGIN");
		lblStudentLogin.setForeground(Color.BLACK);
		lblStudentLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentLogin.setBounds(262, 22, 135, 14);
		contentPane.add(lblStudentLogin);
		
		JLabel lblUserId = new JLabel("Roll no.");
		lblUserId.setForeground(new Color(0, 0, 0));
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserId.setBounds(242, 67, 79, 14);
		contentPane.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(242, 112, 110, 14);
		contentPane.add(lblPassword);
		
		jt1 = new JTextField();
		jt1.setBounds(366, 65, 135, 20);
		contentPane.add(jt1);
		jt1.setColumns(10);
		
		jp1 = new JPasswordField();
		jp1.setBounds(366, 110, 135, 20);
		contentPane.add(jp1);
		this.setLocationRelativeTo(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 0));
		
		StudentDao sd= StudentDao.getStudentDao();
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Roll=jt1.getText();
				String Pass=jp1.getText();
				
				if(jt1.getText().equals(""))
				{
					jt1.requestFocus();
					JOptionPane.showMessageDialog(null, " enter roll");
					
				}
				
				else if(jp1.getText().equals(""))
				{
					jp1.requestFocus();
					JOptionPane.showMessageDialog(null, "enter password");
				}	
				
				else
				{
					int i=sd.loginStudent(Roll,Pass);
				if(i==0)
				{
					JOptionPane.showMessageDialog(null, "enter correct id and password ");
				}
				else{
					dispose();
				}
				
				}
					
			
			
			}
		});
		btnLogin.setBounds(242, 165, 79, 23);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			jt1.setText("");
			jp1.setText("");
			
			}
		});
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setBounds(447, 160, 89, 23);
		contentPane.add(btnReset);
		
		JLabel jl4 = new JLabel("New User Click here");
		jl4.setForeground(Color.BLACK);
		jl4.setFont(new Font("Tahoma", Font.BOLD, 13));
		jl4.setBounds(252, 215, 145, 14);
		contentPane.add(jl4);
		
		Image image1=new ImageIcon(IntroScreen.class.getResource("rsz_login.png")).getImage();
		Icon icon=new ImageIcon(image1);
		JLabel l1 = new JLabel(icon);
		l1.setBounds(10, 11, 222, 237);
		contentPane.add(l1);
		
		
		jl4.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				
			}
		});
		jl4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			dispose();
		  Signup s=new Signup();
		  
	s.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			
				jl4.setCursor(new Cursor(Cursor.HAND_CURSOR));}
		});
		
	}
	


}
