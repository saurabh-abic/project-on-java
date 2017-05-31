package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import dao.StudentDao;
import dto.StudentDto;

public class StudentMainPage extends JFrame {
	static StudentDto sdt;
	public static final int WIDTH=600;
    public static final int HEIGHT=500;
    int counter=1;
	int DELAY=1;
Timer timer;
	private static final LayoutManager Image = null;
	private JPanel contentPane;
    Image icon;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					  JFrame.setDefaultLookAndFeelDecorated(true);
					StudentMainPage frame = new StudentMainPage(sdt);
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
	public StudentMainPage(StudentDto sdt) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 this.setBounds(0,0,WIDTH,HEIGHT);
		//Image icon=new ImageIcon("allmodules.jpg").getImage();
		//Image icon=new ImageIcon(getClass().getClassLoader().getResource("allmodules.jpg")).getImage();
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		Image image1=new ImageIcon(IntroScreen.class.getResource("1.jpg")).getImage();
		Image image2=new ImageIcon(IntroScreen.class.getResource("3.jpg")).getImage();
		Image image3=new ImageIcon(IntroScreen.class.getResource("4.jpg")).getImage();
		Image image4=new ImageIcon(IntroScreen.class.getResource("5.jpg")).getImage();
		Image image5=new ImageIcon(IntroScreen.class.getResource("6.jpg")).getImage();
		Image image6=new ImageIcon(IntroScreen.class.getResource("7.jpg")).getImage();
		Image image7=new ImageIcon(IntroScreen.class.getResource("8.jpg")).getImage();
		Image image8=new ImageIcon(IntroScreen.class.getResource("9.jpg")).getImage();
		Image image9=new ImageIcon(IntroScreen.class.getResource("10.jpg")).getImage();
	    Image image10=new ImageIcon(IntroScreen.class.getResource("log.png")).getImage();
		
		ImageIcon icon1=new ImageIcon(image1);
		ImageIcon icon2=new ImageIcon(image2);
		ImageIcon icon3=new ImageIcon(image3);
		ImageIcon icon4=new ImageIcon(image4);
		ImageIcon icon5=new ImageIcon(image5);
		ImageIcon icon6=new ImageIcon(image6);
		ImageIcon icon7=new ImageIcon(image7);
		ImageIcon icon8=new ImageIcon(image8);
		ImageIcon icon9=new ImageIcon(image9);
		ImageIcon icon10=new ImageIcon(image10);
	//	ImageIcon icon11=new ImageIcon("12.jpg");
	//	ImageIcon icon12=new ImageIcon("13.jpg");
	
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(-16, -28,StudentMainPage.WIDTH,StudentMainPage.HEIGHT);
     	//setContentPane(desktopPane);
	    contentPane.add(desktopPane);
		
			
		JLabel l1 = new JLabel(icon1);
		l1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StudentDetails sd=new StudentDetails(sdt);
				desktopPane.add(sd).setVisible(true);
			
			
			}
		});
		l1.setBounds(23, 72, 114, 100);
		desktopPane.add(l1);
		JLabel l2 = new JLabel(icon2);
		l2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			desktopPane.add(new StudentExam(sdt)).setVisible(true);
			}
		});
		l2.setBounds(251, 72, 107, 100);
		desktopPane.add(l2);
		
		JLabel l3 = new JLabel(icon3);
		l3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
					int select=JOptionPane.showConfirmDialog(null,"Start Download","Confirm",JOptionPane.YES_NO_OPTION);
					 if( select== JOptionPane.YES_OPTION)
					 {
					try {	
						new StudentDao().downloadImage("timetable");
						JOptionPane.showMessageDialog(null,"downloaded");
				} catch (IOException e) {
					e.printStackTrace();
				}
					 }
					 else{ }
						 
					
            
			}
		});
		l3.setBounds(463, 72, 107, 100);
		desktopPane.add(l3);
		
		JLabel l4 = new JLabel(icon4);
		l4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				desktopPane.add(new StudentAttendence1(sdt)).setVisible(true);;
			}
		});
		l4.setBounds(251, 195, 107, 100);
		desktopPane.add(l4);
		
		JLabel l5 = new JLabel(icon5);
		l5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				desktopPane.add(new StudentHostel(sdt)).setVisible(true);
			}
		});
		//l5.addMouseListener((e)->desktopPane.add(new StudentHostel()).setVisible(true));
		l5.setBounds(23, 183, 114, 114);
		desktopPane.add(l5);
		
		JLabel l7 = new JLabel(icon7);
		//l7.addMouseListener((e)->desktopPane.add(new StudentTransport(sdt)).setVisible(true));
			l7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				desktopPane.add(new StudentTransport(sdt)).setVisible(true);
			}
		});
		l7.setBounds(463, 195, 107, 114);
		desktopPane.add(l7);
		
		JLabel l8 = new JLabel(icon8);
		l8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				desktopPane.add(new StudentMsg(sdt)).setVisible(true);
			}
		});
		l8.setBounds(23, 342, 107, 100);
		desktopPane.add(l8);
		
		JLabel l10 = new JLabel(icon10);
		l10.addMouseListener(new MouseAdapter() {
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
		l10.setBounds(463, 369, 107, 87);
		desktopPane.add(l10);
		
		/* JLabel l11 = new JLabel(icon11);
		l11.setBounds(301, 323, 114, 114);
		desktopPane.add(l11);
		
		JLabel l12 = new JLabel(icon12);
		l12.setBounds(456, 323, 118, 114);
		desktopPane.add(l12);*/
	
       /*this.getContentPane().setLayout(null);
		StudentModule sm=new StudentModule(icon);
		sm.setBounds(0, 0, 584, 596);
	    this.getContentPane().add(sm); */
	}     
}
