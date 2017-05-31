package ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;

import dto.FacultyDto;

public class AdminChoice extends JWindow {

	private JPanel contentPane;

	FacultyDto ft;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminChoice frame = new AdminChoice();
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
	public AdminChoice() {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		Image icon1=new ImageIcon(IntroScreen.class.getResource("erp.png")).getImage();
		ImageIcon icon=new ImageIcon(icon1);
		
		JButton btnAsAdministartor = new JButton("As Administartor");
		btnAsAdministartor.setForeground(Color.WHITE);
		btnAsAdministartor.setBackground(Color.DARK_GRAY);
		btnAsAdministartor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new admin().setVisible(true);
			}
		});
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			
				try {
					new Choice().setVisible(true);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnBack.setBounds(177, 198, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnAsFaculty = new JButton("As Faculty");
		btnAsFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new FacultyLogin().setVisible(true);
			}
		});
		btnAsFaculty.setForeground(Color.WHITE);
		btnAsFaculty.setBackground(Color.DARK_GRAY);
		btnAsFaculty.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnAsFaculty.setBounds(122, 117, 202, 39);
		contentPane.add(btnAsFaculty);
		btnAsAdministartor.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnAsAdministartor.setBounds(122, 45, 202, 39);
		contentPane.add(btnAsAdministartor);
		JLabel label = new JLabel(icon);
		label.setBounds(0, 0, 450, 300);
		contentPane.add(label);
	}

}
