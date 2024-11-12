package package01;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



		//class Settings,definition
public class Settings {
	private String image_path = "/package01/hintergrund_Bild.png/";
    private JLabel hintergrund_Bild;
    private JFrame frame;
    	//Launch the application
    	//open the screen "Settings" of the pc/touchscreen

		//Create the application
		//initialization 
	public Settings() {
		initialize();
		System.out.println("Setting Class in active");
		
	}
		//Initialize the contents of the frame
		//open the screen "Settings" of the pc / touchscreen
	private void initialize() {
		// Create the main frame
//		frame = new JFrame();
//		frame.setBounds(100, 100, 1676, 1111);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    frame.getContentPane().setLayout(null);

		frame = new JFrame();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0, 0, screen.width, screen.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);		
		
		
	    //Label for the title
	    JLabel lblNewLabel = new JLabel("Einstellung");
	    lblNewLabel.setFont(new Font("Adobe Fan Heiti Std B", Font.PLAIN, 14));
	    lblNewLabel.setBackground(Color.WHITE);
	    lblNewLabel.setForeground(Color.WHITE);// Set text color to white for visibility
	    lblNewLabel.setBounds(20, 11, 141, 129);// Set position and size of the label
	    frame.getContentPane().add(lblNewLabel); // Add the label to the frame
	    
	    // the main menu button(Hauptmenue)
	    JButton btnNewButton = new JButton("Zum Hauptmenue");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	new Interface();
	    		
	    		
	    	}
	    });
	    btnNewButton.setBackground(Color.PINK);
	    btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
	    btnNewButton.setBounds(30, 305, 167, 41);
	    frame.getContentPane().add(btnNewButton);
	    
		//background picture(flowers)
	    JLabel image_hintergrund_Bild = new JLabel("hintergrund_Bild");
			image_hintergrund_Bild.setIcon(new ImageIcon(Interface.class.getResource(image_path))); // Load the image icon
	        image_hintergrund_Bild.setBounds(0, 0, 2082, 1061);// Set position and size for the background
	        frame.getContentPane().add(image_hintergrund_Bild);// Add the background image to the frame
	        
	     
	}
}


