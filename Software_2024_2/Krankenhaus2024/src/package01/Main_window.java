package package01;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main_window {

    JFrame frame;
    private JTextField textfield_destination_room;
    private String image_path = "/package01/hospital_plan.png";
    private JLabel image_hospital_plan;
    private DrawingPanel drawingPanel;
    private int[][] positionsArray;
    
    private int get_sX;
    private int get_sY;
    
    private int get_gX;
    private int get_gY;
    
    
    private  boolean  isSetstart = true;
   
    private  boolean  setkoordinates = false;
    
    
    private JLabel current_room;   
    private JLabel destination_room;
    
    JButton button_commit;
    
     private JLabel label_4;
     private JLabel label_5;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main_window window = new Main_window();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main_window() {
        initialize(null);
    }

    public void initialize(int[][] positionsArray) {
        frame = new JFrame();
        frame.setBounds(100, 100, 1191, 707);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        drawingPanel = new DrawingPanel();
        drawingPanel.setPositionsArray(positionsArray);
        drawingPanel.setOpaque(false);
        drawingPanel.setBounds(494, 93, 657, 464); 
        frame.getContentPane().add(drawingPanel);

        
    	current_room = new JLabel("Startpunkt");
        current_room.setBounds(283, 237, 182, 21);
        frame.getContentPane().add(current_room);

        
        destination_room = new JLabel("Zielpunkt------------------");
        destination_room.setBounds(283, 268, 171, 21);
        frame.getContentPane().add(destination_room);


        current_room.setVisible(false);
        destination_room.setVisible(false);
        
        
        JButton button_start_search = new JButton("Suche Starten");
        button_start_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("button is working");
                
                int[] start = {get_sX, get_sY};
                
                int[] goal = {get_gX, get_gY};
              //  int[] goal = {korrdinate_X, korrdinate_Y};
                
                int[][] positionsArray = Node.start(start, goal);
                
                if (positionsArray == null) {
                    JOptionPane.showMessageDialog(frame, "Kein Pfad gefunden");
                } else {
                    // Erfolgreiches Ergebnis verarbeiten
                    drawingPanel.setPositionsArray(positionsArray);
                } 
               // drawingPanel.setPositionsArray(positionsArray);
            }
        });
        button_start_search.setBounds(333, 412, 121, 40);
        frame.getContentPane().add(button_start_search);
        button_start_search.setVisible(false);
      
//        while(setkoordinates==false)
//        {
//        	 	
//            button_start_search.setVisible(false);
//             
//
//        }
//        button_start_search.setVisible(true);
               
        
        image_hospital_plan = new JLabel("hospital_plan");
        image_hospital_plan.setIcon(new ImageIcon(Main_window.class.getResource("/package01/hospital_plan.png")));
        image_hospital_plan.setBounds(494, 93, 657, 464);
        frame.getContentPane().add(image_hospital_plan);

       
//        JLabel current_room=current_room = new JLabel("-");
//     current_room.setBounds(89, 132, 131, 21);
//     frame.getContentPane().add(current_room);

        
        
        
       
        textfield_destination_room = new JTextField();
        textfield_destination_room.setColumns(10);
        textfield_destination_room.setBounds(345, 322, 109, 29);
        frame.getContentPane().add(textfield_destination_room);
        
        JLabel lblNewLabel = new JLabel("HospitalMaps");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblNewLabel.setBounds(728, 27, 187, 56);
        frame.getContentPane().add(lblNewLabel);

        
        JLabel pointLabel = new JLabel();
        pointLabel.setOpaque(true);
        pointLabel.setBackground(Color.BLUE); // Punktfarbe
        pointLabel.setSize(10, 10); // Punktgröße
        pointLabel.setVisible(false);
        image_hospital_plan.add(pointLabel);
        
        
        
        
        JLabel pointLabel2 = new JLabel();
        pointLabel2.setOpaque(true);
        pointLabel2.setBackground(Color.RED); // Punktfarbe
        pointLabel2.setSize(10, 10); // Punktgröße
        pointLabel2.setVisible(false);
        image_hospital_plan.add(pointLabel2);
        
        label_4 = new JLabel("Bitte geben sie den Ziel Raum ein");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_4.setBounds(100, 314, 235, 40);
        frame.getContentPane().add(label_4);
        
        
        label_5 = new JLabel("Bitte markieren die eine Startposition ");
        label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_5.setBounds(213, 167, 252, 51);
        frame.getContentPane().add(label_5);
       
        
        
        button_commit = new JButton("Bestätigen");
        button_commit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String room_id= textfield_destination_room.getText();
            	try (Connection conn = DatabaseManager.getConnection()) {
                    String query = "SELECT x_coordinate, y_coordinate FROM room_coordinates WHERE room_id = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                   
					stmt.setString(1, room_id);
                    
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                    	get_gX = (int) rs.getDouble("x_coordinate");
                    	get_gY = (int) rs.getDouble("y_coordinate");
                    	
                    	System.out.println("X-Koordinate: " + get_gX);
                        System.out.println("Y-Koordinate: " + get_gY);
                    	
                        button_start_search.setVisible(true);
                  	  destination_room.setVisible(true);
                  	  destination_room.setText("Zielpunkt gesetzt: "+get_gX+""+get_gY);           	
                  	  pointLabel2.setLocation(get_gX - pointLabel2.getWidth() / 2, get_gY - pointLabel2.getHeight() / 2);
                        pointLabel2.setVisible(true);
                   	
                    }
                    	else {
                    		textfield_destination_room.setText("");
                    		JOptionPane.showMessageDialog(frame, "Bitte eine gültige Raumnummer von 1-144 eingeben!");
                    		get_gX=0;
                    		get_gY=0;
                    		
                    	}
            	
                    } catch (SQLException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        				System.out.println("Something went wrong"+e1);
        				JOptionPane.showMessageDialog(frame, "Database error: " + e1.getMessage());
        				JOptionPane.showMessageDialog(frame, "Please activate  your wifi connection!!");
        			}
  	
            	}
                    
                                       
                    
        });
        button_commit.setBounds(333, 361, 121, 40);
        frame.getContentPane().add(button_commit);

        

        

        textfield_destination_room.setVisible(false);
        label_4.setVisible(false);
        button_commit.setVisible(false); 
       
               
        image_hospital_plan.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	
            	if(isSetstart)
            	{   
            		get_sX = e.getX();
                    get_sY = e.getY();
                                                			  
                  
                     System.out.println("Maus bewegt: X = " + get_sX + ", Y = " + get_sY);
                      	 current_room.setVisible(true);
                      	current_room.setText("Akuelle Postion: "+get_sX+""+get_sY);
                      	
                       
                    
            		
            		// System.out.println("isSetstart true");
            		  
                 	// current_room = new JLabel("Aktuelle Position:"+ get_sX +""+get_sY);            	
                 	//current_room .setVisible(true);
                 	
                 	  pointLabel.setLocation(get_sX - pointLabel.getWidth() / 2, get_sY - pointLabel.getHeight() / 2);
                      pointLabel.setVisible(true);
                      textfield_destination_room.setVisible(true);
                      label_4.setVisible(true);
                      label_5.setVisible(false);
                      button_commit.setVisible(true); 
                      
            		 isSetstart = false;
            		 
            	} else {
            		            		
            	get_gX = e.getX();
            	get_gY = e.getY();
            	
            	
            	            	           	
            	
            	System.out.println("Maus bewegt: X = " + get_gX + ", Y = " + get_gY);
            	button_start_search.setVisible(true);
            	  destination_room.setVisible(true);
            	  destination_room.setText("Zielpunkt gesetzt: "+get_gX+""+get_gY);           	
            	  pointLabel2.setLocation(get_gX - pointLabel2.getWidth() / 2, get_gY - pointLabel2.getHeight() / 2);
                  pointLabel2.setVisible(true);
             	
            	  
                 	  
            }    
            	
                        	
            }
        });
    	
     	//current_room.setText(get_sX+""+get_sY);
        
        
        destination_room.setText(get_gX+""+get_gY);

        
        JButton button_reset = new JButton("Zurücksetzen");
        button_reset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		isSetstart=true;
        		int[][] positionsArray=null;
                button_start_search.setVisible(false);
                pointLabel2.setVisible(false);
                pointLabel.setVisible(false);
                textfield_destination_room.setVisible(false);
                label_4.setVisible(false);
                destination_room.setVisible(false);
                current_room.setVisible(false);
                label_5.setVisible(true);
                button_commit.setVisible(false);
        		drawingPanel.setPositionsArray(positionsArray);
        	}
        });
        button_reset.setBounds(333, 462, 121, 40);
        frame.getContentPane().add(button_reset);

        JButton btnConfig = new JButton("Config");
        btnConfig.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Anmeldung();
        		
        	}
        });
        btnConfig.setBounds(333, 512, 121, 45);
        frame.getContentPane().add(btnConfig);
        
                     
    }
}
    
    
    



