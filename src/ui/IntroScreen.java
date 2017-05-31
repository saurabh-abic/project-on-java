package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class IntroScreen extends JWindow {
	JProgressBar progressBar = new JProgressBar();
	Timer timer ;
	private final int DELAY = 100;
	private boolean isVisible = false;
	private int counter = 1;
	Image icon1;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public void action()
	{
		
		ActionListener ac=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		progressBar.setValue(counter);
		
		if(counter>=100)
		{
			timer.stop();
			IntroScreen.this.setVisible(false);
		  try {
			new Choice().setVisible(true);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		}
		counter++;
			}
		};
timer =new javax.swing.Timer(DELAY,ac);
timer.start();
	
	}
	
	
	public static void main(String[] args) {
		IntroScreen frame = new IntroScreen();
		frame.setVisible(true);
		frame.action();
	}

	/**
	 * Create the frame.
	 */
	public IntroScreen() {
		
		setBounds(100, 100, 715, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
	
		icon1=new ImageIcon(IntroScreen.class.getResource("erp2.jpg")).getImage();
		Icon icon=new ImageIcon(icon1);
	    JLabel label = new JLabel(icon);
		label.setBounds(0, 0, 715, 214);
		contentPane.add(label);
		
	
		progressBar.setStringPainted(true);
		progressBar.setBounds(0, 211, 715, 14);
		contentPane.add(progressBar);
		
      }
}
