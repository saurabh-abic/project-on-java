package ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.FacultyDao;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;

public class AdminMainPage extends JFrame {
	static final int WIDTH=500;
    static final int HEIGHT=500;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 JFrame.setDefaultLookAndFeelDecorated(true);
					AdminMainPage frame = new AdminMainPage();
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
	public AdminMainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,WIDTH,HEIGHT);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0,0,484,461);
		contentPane.add(desktopPane);
		Image image1=new ImageIcon(IntroScreen.class.getResource("2.png")).getImage();
		Image image2=new ImageIcon(IntroScreen.class.getResource("1.jpg")).getImage();
		Image image3=new ImageIcon(IntroScreen.class.getResource("3.jpg")).getImage();
		Image image4=new ImageIcon(IntroScreen.class.getResource("5.jpg")).getImage();
		Image image5=new ImageIcon(IntroScreen.class.getResource("4.jpg")).getImage();
		Image image6=new ImageIcon(IntroScreen.class.getResource("10.jpg")).getImage();
		Image image7=new ImageIcon(IntroScreen.class.getResource("13.jpg")).getImage();
		Image image8=new ImageIcon(IntroScreen.class.getResource("12.jpg")).getImage();
		ImageIcon icon1=new ImageIcon(image1);
		ImageIcon icon2=new ImageIcon(image2);
		ImageIcon icon3=new ImageIcon(image3);
		ImageIcon icon4=new ImageIcon(image4);
		ImageIcon icon5=new ImageIcon(image5);
		ImageIcon icon6=new ImageIcon(image6);
		ImageIcon icon7=new ImageIcon(image7);
		ImageIcon icon8=new ImageIcon(image8);
		
		JLabel l2 = new JLabel(icon2);
		l2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				desktopPane.add(new AdminStudentDetails()).setVisible(true);;
			}
		});
		l2.setBounds(33, 179, 97, 100);
		desktopPane.add(l2);
		
		JLabel lblNewLabel_1 = new JLabel(icon5);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					new FacultyDao().uploadImage("timetable");
					JOptionPane.showMessageDialog(null,"uploaded Successfully");
				} catch (FileNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		lblNewLabel_1.setBounds(360, 179, 97, 100);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel(icon7);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				desktopPane.add(new AdminMsg()).setVisible(true);
			}
		});
		lblNewLabel_3.setBounds(203, 179, 105, 100);
		desktopPane.add(lblNewLabel_3);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			dispose();
			try {
				new Choice().setVisible(true);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
			}
		});
		lblLogout.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblLogout.setForeground(Color.BLACK);
		lblLogout.setBounds(181, 380, 162, 25);
		desktopPane.add(lblLogout);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin.setBounds(181, 32, 153, 30);
		desktopPane.add(lblAdmin);
		 
		
	}
}
