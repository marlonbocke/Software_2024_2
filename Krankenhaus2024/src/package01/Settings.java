package package01;

import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
		//class Settings,definition
public class Settings {
	private String image_path = "/package01/hintergrund_Bild.png/";
    private JLabel hintergrund_Bild;
    private JFrame frame;
    	//Launch the application
    	//open the screen "Settings" of the pc/touchscreen
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

		//Create the application
		//initialization 
	public Settings() {
		initialize();
	}
		//Initialize the contents of the frame
		//open the screen "Settings" of the pc / touchscreen
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1676, 1111);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
	    
	    //White Label for the background picture
	    JLabel lblNewLabel = new JLabel("Einstellung");
	    lblNewLabel.setFont(new Font("Adobe Fan Heiti Std B", Font.PLAIN, 14));
	    lblNewLabel.setBackground(Color.WHITE);
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setBounds(20, 11, 141, 129);
	    frame.getContentPane().add(lblNewLabel);
	    
	    //To the main menu button(Hauptmenue)
	    JButton btnNewButton = new JButton("Zum Hauptmenue");
	    btnNewButton.setBackground(Color.PINK);
	    btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
	    btnNewButton.setBounds(30, 305, 167, 41);
	    frame.getContentPane().add(btnNewButton);
	    
		//background picture(flowers)
	    JLabel image_hintergrund_Bild = new JLabel("hintergrund_Bild");
			image_hintergrund_Bild.setIcon(new ImageIcon(Interface.class.getResource(image_path)));
	        image_hintergrund_Bild.setBounds(0, 0, 2082, 1061);
	        frame.getContentPane().add(image_hintergrund_Bild);
	        
	     
	}
}


