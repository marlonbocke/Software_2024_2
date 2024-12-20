package package01.controller;

import javax.swing.*;

import package01.view.DatabaseManager;
import package01.view.Main_window;
import package01.view.Settings;

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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;




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
      
      
    	frame = new JFrame();
		//Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(100, 100, 1191, 707);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(Frame.NORMAL);
		frame.setUndecorated(false);
		frame.setAlwaysOnTop(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
   	
    
        textField = new JTextField();
        textField.setBounds(489, 189, 144, 48);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("Anmelden");
        btnNewButton.setBounds(489, 248, 144, 48);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accType = textField_1.getText();
                String pin = textField.getText();
                validateUser(accType, pin);
            }
        });
        
        JLabel label = new JLabel("");
        label.setBounds(449, 16, 0, 0);
        frame.getContentPane().add(label);
        
        JLabel label_1 = new JLabel("");
        label_1.setBounds(454, 16, 0, 0);
        frame.getContentPane().add(label_1);
        
        JLabel label_2 = new JLabel("");
        label_2.setBounds(459, 16, 0, 0);
        frame.getContentPane().add(label_2);
        
        JLabel label_3 = new JLabel("");
        label_3.setBounds(464, 16, 0, 0);
        frame.getContentPane().add(label_3);
        
        JLabel label_4 = new JLabel("");
        label_4.setBounds(469, 16, 0, 0);
        frame.getContentPane().add(label_4);
        frame.getContentPane().add(btnNewButton);
        
        textField_1 = new JTextField();
        textField_1.setBounds(489, 130, 144, 48);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Kennwort");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(345, 193, 145, 40);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Admin Name:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(335, 138, 144, 40);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lblNewLabel_1);
        
        JButton button_back = new JButton("Zurück");
        button_back.setBounds(489, 304, 144, 48);
        button_back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 frame.setVisible(false);
        		new Main_window();
 
        	}
        });
        frame.getContentPane().add(button_back);
        
        JLabel lblNewLabel_1_1 = new JLabel("Verifizierung für die Konfiguration");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setBounds(373, 38, 358, 40);
        frame.getContentPane().add(lblNewLabel_1_1);
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
                
                frame.setVisible(false);
                Settings roadManager = new Settings();
                roadManager.setVisible(true);
                
                
                
                
                
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid account type or PIN");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage());
        }
    }
}
