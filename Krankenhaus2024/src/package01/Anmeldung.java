package package01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;




public class Anmeldung {
    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;


    public Anmeldung() {
    	
    	initialize();
    	System.out.println("Test");
    	     
    }

    
    /**
     * @wbp.parser.entryPoint
     */
    private void initialize() {
//        frame = new JFrame();
//        frame.setBounds(100, 100, 450, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().setLayout(null);
//      
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
   	
    	
		
  
    	
        textField = new JTextField();
        textField.setBounds(149, 143, 142, 23);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("Anmelden");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accType = textField_1.getText();
                String pin = textField.getText();
                validateUser(accType, pin);
            }
        });
        btnNewButton.setBounds(159, 183, 121, 37);
        frame.getContentPane().add(btnNewButton);
        
        textField_1 = new JTextField();
        textField_1.setBounds(149, 79, 142, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Kennwort");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(179, 110, 89, 22);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Admin Name:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(161, 54, 119, 14);
        frame.getContentPane().add(lblNewLabel_1);
        
        JButton button_back = new JButton("Zurück");
        button_back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		new Interface();
        		frame.setVisible(false);
 
        	}
        });
        button_back.setBounds(123, 252, 121, 30);
        frame.getContentPane().add(button_back);
    }

    private void validateUser(String accType, String pin) {
        try (Connection conn = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM PermissionClass WHERE acctype = ? AND pin = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, accType);
            stmt.setString(2, pin);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(frame, "Login successful!");
                // Here you can create the appropriate acctyp object based on the accType
                // and open the corresponding window or perform further actions
                
                frame.setVisible(false);
        		new Settings();
                
                                
                
                
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid account type or PIN");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage());
        }
    }
}