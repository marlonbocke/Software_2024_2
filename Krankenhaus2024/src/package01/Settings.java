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
		// Create the main frame
		frame = new JFrame();
		frame.setBounds(100, 100, 1676, 1111);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
	    
	    //Label for the title
	    JLabel lblNewLabel = new JLabel("Einstellung");
	    lblNewLabel.setFont(new Font("Adobe Fan Heiti Std B", Font.PLAIN, 14));
	    lblNewLabel.setBackground(Color.BLACK);
	    lblNewLabel.setForeground(Color.BLACK);// Set text color to white for visibility
	    lblNewLabel.setBounds(20, 11, 141, 129);// Set position and size of the label
	    frame.getContentPane().add(lblNewLabel); // Add the label to the frame
	    
		//background picture(flowers)
	    JLabel image_hintergrund_Bild = new JLabel("hintergrund_Bild");
	    image_hintergrund_Bild.setIcon(new ImageIcon(Interface.class.getResource(image_path))); // Load the image icon
	    image_hintergrund_Bild.setBounds(0, 0, 2082, 1061);// Set position and size for the background
	    frame.getContentPane().add(image_hintergrund_Bild);
	    
	    JButton btnNewButton_1 = new JButton("New button");
	    btnNewButton_1.setBounds(51, 222, 85, 21);
	    frame.getContentPane().add(btnNewButton_1);
	    
	    // the main menu button(Hauptmenue)
	    JButton btnNewButton = new JButton("Zum Hauptmenue");
	    btnNewButton.setBackground(Color.PINK);
	    btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
	    btnNewButton.setBounds(10, 370, 167, 41);
	    frame.getContentPane().add(btnNewButton);
	        
	     
	}
}


