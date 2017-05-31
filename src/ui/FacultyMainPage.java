package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.FacultyDao;
import dto.FacultyDto;
import dto.StudentDto;

public class FacultyMainPage extends JFrame {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

final static int WIDTH=500; 
 
 final static int HEIGHT=500;
  static FacultyDto ft;
  static StudentDto st;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyMainPage frame = new FacultyMainPage(ft);
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
	public FacultyMainPage(FacultyDto ft) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,486,500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0,0,597,461);
		contentPane.add(desktopPane);
		//Image image1=new ImageIcon(IntroScreen.class.getResource("2.png")).getImage();
		Image image2=new ImageIcon(IntroScreen.class.getResource("1.jpg")).getImage();
		Image image3=new ImageIcon(IntroScreen.class.getResource("3.jpg")).getImage();
		Image image4=new ImageIcon(IntroScreen.class.getResource("5.jpg")).getImage();
		Image image5=new ImageIcon(IntroScreen.class.getResource("4.jpg")).getImage();
		//Image image6=new ImageIcon(IntroScreen.class.getResource("10.jpg")).getImage();
		Image image7=new ImageIcon(IntroScreen.class.getResource("13.jpg")).getImage();
		Image image8=new ImageIcon(IntroScreen.class.getResource("log.png")).getImage();
		ImageIcon icon2=new ImageIcon(image2);
		ImageIcon icon3=new ImageIcon(image3);
		ImageIcon icon4=new ImageIcon(image4);
		ImageIcon icon5=new ImageIcon(image5);
		//ImageIcon icon6=new ImageIcon("10.jpg");
		ImageIcon icon7=new ImageIcon(image7);
		ImageIcon icon8=new ImageIcon(image8);
		
		JLabel lblFaculty = new JLabel("FACULTY");
		lblFaculty.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaculty.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblFaculty.setBounds(164, 11, 167, 42);
		desktopPane.add(lblFaculty);
		
		JLabel l1 = new JLabel(icon2);
		l1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			desktopPane.add(new FacultyStudentDetails()).setVisible(true);
			}
		});
		l1.setBounds(22, 51, 105, 100);
		desktopPane.add(l1);
		
		JLabel l2 = new JLabel(icon3);
		l2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			     
				desktopPane.add(new FacultyExam(ft)).setVisible(true);
			}
		});
		l2.setBounds(192, 51, 97, 100);
		desktopPane.add(l2);
		
		JLabel label = new JLabel(icon4);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
			desktopPane.add(new FacultyAttendence1(ft)).setVisible(true);
			}
		});
		label.setBounds(351, 51, 97, 100);
		desktopPane.add(label);
		
		JLabel lblNewLabel = new JLabel(icon5);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			try {
				new FacultyDao().uploadImage("timetable");
				JOptionPane.showMessageDialog(null,"uploaded Successfully");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			}
		});
		lblNewLabel.setBounds(22, 200, 106, 100);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(icon7);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		        desktopPane.add(new FacultyMsg(ft)).setVisible(true);;
			}
		});
		lblNewLabel_1.setBounds(192, 200, 97, 100);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(icon8);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			dispose();
			try {
				new Choice().setVisible(true);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				
				e1.printStackTrace();
			};
			}
		});
		lblNewLabel_2.setBounds(352, 208, 73, 49);
		desktopPane.add(lblNewLabel_2);
		
		JLabel lblClickHereFor = new JLabel("Click here for know your information");
		lblClickHereFor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FacultyDetails fd=new FacultyDetails(ft);
				desktopPane.add(fd).setVisible(true);
		    }
		});
		lblClickHereFor.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblClickHereFor.setBounds(34, 404, 255, 25);
		desktopPane.add(lblClickHereFor);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setBounds(362, 268, 63, 14);
		desktopPane.add(lblLogout);
		
		
		
	}
}
