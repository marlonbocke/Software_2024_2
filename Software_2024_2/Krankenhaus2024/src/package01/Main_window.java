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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;

public class Main_window {

    JFrame frame;
    private JTextField textField_currentroom;
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
        frame.setBounds(100, 100, 1048, 707);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        drawingPanel = new DrawingPanel();
        drawingPanel.setPositionsArray(positionsArray);
        drawingPanel.setOpaque(false);
        drawingPanel.setBounds(342, 93, 657, 464); 
        frame.getContentPane().add(drawingPanel);

        
       

      
        
        
        JButton button_start_search = new JButton("Suche Starten");
        button_start_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("button is working");
                
                int[] start = {get_sX, get_sY};
                
                int[] goal = {get_gX, get_gY};
              //  int[] goal = {korrdinate_X, korrdinate_Y};
                
                int[][] positionsArray = Node.start(start, goal);
                
//                for(int i=0; i < positionsArray.length; i++)
//    		        {
//    		        	
//    		        	for(int j=0; j < positionsArray[i].length; j++)
//    		            {
//    		            	
//    		        		System.out.println("Main_window:"+positionsArray[i][j]);
//    		                        	      	
//    		            }	

    	        	
//    		        }              
                
                drawingPanel.setPositionsArray(positionsArray);
            }
        });
        button_start_search.setBounds(198, 410, 121, 40);
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
        image_hospital_plan.setBounds(342, 93, 657, 464);
        frame.getContentPane().add(image_hospital_plan);

//        int x = image_hospital_plan.getBounds().x;
//        int y = image_hospital_plan.getBounds().y;
//        int width = image_hospital_plan.getWidth();
//        int height = image_hospital_plan.getHeight();
//        System.out.println("X-Koordinate: " + x);
//        System.out.println("Y-Koordinate: " + y);
//        System.out.println("Breite: " + width);
//        System.out.println("Höhe: " + height);

        
        
        textField_currentroom = new JTextField();
        textField_currentroom.setBounds(174, 168, 109, 20);
        frame.getContentPane().add(textField_currentroom);
        textField_currentroom.setColumns(10);

        JLabel current_room = new JLabel("Aktuelle Position"+get_sX);
        current_room.setBounds(89, 132, 131, 21);
        frame.getContentPane().add(current_room);

        JLabel destination_room = new JLabel("Ziel Raum");
        destination_room.setBounds(89, 155, 67, 21);
        frame.getContentPane().add(destination_room);

        textfield_destination_room = new JTextField();
        textfield_destination_room.setColumns(10);
        textfield_destination_room.setBounds(174, 256, 109, 20);
        frame.getContentPane().add(textfield_destination_room);
        
        JLabel lblNewLabel = new JLabel("HospitalMaps");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblNewLabel.setBounds(590, 24, 187, 56);
        frame.getContentPane().add(lblNewLabel);

        
        
        textField_currentroom.setVisible(false);
        
        
        
               
        image_hospital_plan.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	
            	if(isSetstart)
            	{
            		// System.out.println("isSetstart true");
            		  get_sX = e.getX();
                      get_sY = e.getY();
                 	System.out.println("Maus bewegt: X = " + get_sX + ", Y = " + get_sY);
                 	textField_currentroom.setVisible(true);
            		 isSetstart = false;
                   	            			
            	} else {
            		            		
            	get_gX = e.getX();
            	get_gY = e.getY();
            	System.out.println("Maus bewegt: X = " + get_gX + ", Y = " + get_gY); 
            	button_start_search.setVisible(true); 
            }    
            	
            	
            }
        });

        JButton button_reset = new JButton("Zurücksetzen");
        button_reset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		isSetstart=true;
        		int[][] positionsArray=null;
                button_start_search.setVisible(false);

        	
        		drawingPanel.setPositionsArray(positionsArray);
        	}
        });
        button_reset.setBounds(198, 461, 121, 40);
        frame.getContentPane().add(button_reset);

        JButton btnConfig = new JButton("Config");
        btnConfig.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Anmeldung();
        		
        	}
        });
        btnConfig.setBounds(198, 512, 121, 45);
        frame.getContentPane().add(btnConfig);

                
        
   
       
    }

    
    
}
    
    
    



