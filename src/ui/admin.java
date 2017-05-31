package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class admin extends JFrame {

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
					admin frame = new admin();
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
	public admin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 328);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(296, 14, 119, 29);
		contentPane.add(lblNewLabel);
		
		JLabel jl1 = new JLabel("User id");
		jl1.setForeground(new Color(0, 0, 0));
		jl1.setFont(new Font("Tahoma", Font.BOLD, 12));
		jl1.setBounds(295, 71, 61, 18);
		contentPane.add(jl1);
		
		JLabel jl2 = new JLabel("Password");
		jl2.setForeground(new Color(0, 0, 0));
		jl2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jl2.setBounds(295, 121, 61, 16);
		contentPane.add(jl2);
		
		jt1 = new JTextField();
		jt1.setBounds(442, 69, 167, 20);
		contentPane.add(jt1);
		jt1.setColumns(10);
		
		jp1 = new JPasswordField();
		jp1.setBounds(442, 121, 165, 20);
		contentPane.add(jp1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(jt1.getText().equals("admin")&&jp1.getText().equals("admin"))
				{
					dispose();
					new AdminMainPage().setVisible(true);
				}
				
				
				
				if(jt1.getText().equals(""))
				{
					jt1.requestFocus();
					
				}
				
				if(jp1.getText().equals(""))
				{
					
					jp1.requestFocus();
					
					
					
				
				}}
		});
		btnLogin.setBounds(363, 182, 68, 23);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			jt1.setText("");
			jp1.setText("");
			}
		});
		btnReset.setBounds(473, 182, 68, 23);
		contentPane.add(btnReset);
		Image icon1=new ImageIcon(IntroScreen.class.getResource("admin.png")).getImage();
		Icon icon=new ImageIcon(icon1);
		JLabel label = new JLabel(icon);
		label.setBounds(10, 14, 275, 263);
		contentPane.add(label);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			try {
				new Choice().setVisible(true);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				
				e1.printStackTrace();
			}
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setBounds(567, 182, 68, 23);
		contentPane.add(btnBack);
	}
}
