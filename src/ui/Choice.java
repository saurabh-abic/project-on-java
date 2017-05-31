package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Choice extends JFrame {
	static String className;

	private JPanel contentPane;

	
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {JFrame.setDefaultLookAndFeelDecorated(true);
					Choice frame = new Choice();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
/**	public   void  select(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		Class.forName(name).newInstance();
	}**/

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Choice() throws InstantiationException, IllegalAccessException, ClassNotFoundException   {
 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 382);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblLoginAs = new JLabel("Login  As");
		lblLoginAs.setForeground(Color.BLACK);
		lblLoginAs.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginAs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblLoginAs.setBounds(209, 26, 129, 32);
		contentPane.add(lblLoginAs);
		Image icon1=new ImageIcon(IntroScreen.class.getResource("rsz_student.png")).getImage();
		Icon icon =new ImageIcon(icon1);
		
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			dispose();	
			 //className="studentlogin";
			new StudentLogin().setVisible(true);
			
			}
		});
		lblNewLabel.setBounds(10, 53, 238, 227);
		contentPane.add(lblNewLabel);
		Image image=new ImageIcon(IntroScreen.class.getResource("admin.png")).getImage();
		Icon icon2=new ImageIcon(image);
		
		JLabel label = new JLabel(icon2);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				
				dispose();
				
				// className="admin";
				new AdminChoice().setVisible(true);
			
			}
		});
		//select(className);
		
		label.setBounds(290, 47, 247, 243);
		contentPane.add(label);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setForeground(Color.BLACK);
		lblStudent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblStudent.setBounds(87, 291, 68, 14);
		contentPane.add(lblStudent);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setForeground(Color.BLACK);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblAdmin.setBounds(392, 291, 55, 14);
		contentPane.add(lblAdmin);
	}
}
