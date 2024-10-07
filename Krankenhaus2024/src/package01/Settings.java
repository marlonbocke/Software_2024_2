package package01;

import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Settings {
	private String image_path = "/package01/hintergrund_Bild.png/";
    private JLabel hintergrund_Bild;
    private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings window = new Settings();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Settings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    JLabel image_hintergrund_Bild = new JLabel("hintergrund_Bild");
			image_hintergrund_Bild.setIcon(new ImageIcon(Interface.class.getResource(image_path)));
	        image_hintergrund_Bild.setBounds(20, 11, 367, 239);
	        frame.getContentPane().add(image_hintergrund_Bild, BorderLayout.WEST);
	}


}


