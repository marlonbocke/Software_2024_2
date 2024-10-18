package package01;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Interface {

    JFrame frame;
    private JTextField textField_currentroom;
    private JTextField textfield_destination_room;
    private String image_path = "/package01/hospital_plan.png";
    private JLabel image_hospital_plan;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interface window = new Interface();
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
    public Interface() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 851, 553);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton button_start_search = new JButton("Suche Starten");
        button_start_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Action for search button
            }
        });
        button_start_search.setBounds(433, 11, 121, 21);
        frame.getContentPane().add(button_start_search);

        image_hospital_plan = new JLabel("hospital_plan");
        image_hospital_plan.setIcon(new ImageIcon(Interface.class.getResource(image_path)));
        image_hospital_plan.setBounds(150, 42, 657, 464);
        frame.getContentPane().add(image_hospital_plan);

        int x = image_hospital_plan.getBounds().x;
        int y = image_hospital_plan.getBounds().y;
        int width = image_hospital_plan.getWidth();
        int height = image_hospital_plan.getHeight();

        System.out.println("X-Koordinate: " + x);
        System.out.println("Y-Koordinate: " + y);
        System.out.println("Breite: " + width);
        System.out.println("Höhe: " + height);

        image_hospital_plan.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                System.out.println("Maus bewegt: X = " + mouseX + ", Y = " + mouseY);
            }
        });

        JButton button_reset = new JButton("Zurücksetzen");
        button_reset.setBounds(20, 293, 121, 40);
        frame.getContentPane().add(button_reset);

        JButton button_menu = new JButton("Zum Hauptmenü");
        button_menu.setBounds(20, 373, 121, 45);
        frame.getContentPane().add(button_menu);

        textField_currentroom = new JTextField();
        textField_currentroom.setBounds(20, 125, 109, 20);
        frame.getContentPane().add(textField_currentroom);
        textField_currentroom.setColumns(10);

        JLabel current_room = new JLabel("Aktueller Raum");
        current_room.setBounds(39, 93, 82, 21);
        frame.getContentPane().add(current_room);

        JLabel destination_room = new JLabel("Ziel Raum");
        destination_room.setBounds(39, 189, 67, 21);
        frame.getContentPane().add(destination_room);

        textfield_destination_room = new JTextField();
        textfield_destination_room.setColumns(10);
        textfield_destination_room.setBounds(20, 221, 109, 20);
        frame.getContentPane().add(textfield_destination_room);
    }

    public void calulate() {

    	int[][] coordinates_range = new int[65][2];

        coordinates_range[0][0] = 0; 
        coordinates_range[0][1] = 0; 
        coordinates_range[1][0] = 0; 
        coordinates_range[1][1] = 276; 

        
        
        coordinates_range[2][0] = 0; 
        coordinates_range[2][1] = 276; 
        coordinates_range[3][0] = 188; 
        coordinates_range[3][1] = 276; 


        
        coordinates_range[4][0] = 188; 
        coordinates_range[4][1] = 276; 
        coordinates_range[5][0] = 188; 
        coordinates_range[5][1] = 458; 

        
        coordinates_range[6][0] = 188; //X
        coordinates_range[6][1] = 458; //Y 
        coordinates_range[7][0] = 497; 
        coordinates_range[7][1] = 458; 

        
        coordinates_range[8][0] = 497; 
        coordinates_range[8][1] = 458; 
        coordinates_range[9][0] = 497; 
        coordinates_range[9][1] = 276; 
	
        
        coordinates_range[10][0] = 497; 
       	coordinates_range[10][1] = 276; 
       	coordinates_range[11][0] = 641; 
       	coordinates_range[11][1] = 276;
       	
       	
       	coordinates_range[12][0] = 641; 
       	coordinates_range[12][1] = 276;
       	coordinates_range[13][0] = 641; 
       	coordinates_range[13][1] = 0;
       	
       	coordinates_range[14][0] = 641; 
       	coordinates_range[15][1] = 0;
       	coordinates_range[16][0] = 379; 
       	coordinates_range[16][1] = 0;
       	
       	coordinates_range[16][0] = 379; 
       	coordinates_range[16][1] = 0;
       	coordinates_range[17][0] = 163; 
       	coordinates_range[17][1] = 379;
	
    
       	coordinates_range[16][0] = 379; 
       	coordinates_range[16][1] = 0;
       	coordinates_range[17][0] = 379; 
       	coordinates_range[17][1] = 163;
	
       	
    	coordinates_range[18][0] = 379; 
       	coordinates_range[18][1] = 163;
       	coordinates_range[19][0] = 269; 
       	coordinates_range[19][1] = 163;
       	
       	
    	coordinates_range[20][0] = 269; 
       	coordinates_range[20][1] = 163;
       	coordinates_range[21][0] = 269; 
       	coordinates_range[21][1] = 0;
       	
       	
       	coordinates_range[22][0] = 269; 
       	coordinates_range[22][1] = 0;
       	coordinates_range[23][0] = 0; 
       	coordinates_range[23][1] = 0;
       	
       	//------------------------------------------------------------^^ define out_walls
       	
       	
    	coordinates_range[24][0] = 10; 
       	coordinates_range[24][1] = 0;
       	coordinates_range[25][0] = 10; 
       	coordinates_range[25][1] = 297;
       	
       	
     	coordinates_range[26][0] = 64; 
       	coordinates_range[26][1] = 61;
       	coordinates_range[27][0] = 64; 
       	coordinates_range[27][1] = 264;
       	
       	
       	coordinates_range[28][0] = 80; 
       	coordinates_range[28][1] = 61;
       	coordinates_range[29][0] = 80; 
       	coordinates_range[29][1] = 222;
       	
        
       	coordinates_range[30][0] = 80; 
       	coordinates_range[30][1] = 61;
       	coordinates_range[31][0] = 80; 
       	coordinates_range[31][1] = 222;
       
       	
    	coordinates_range[32][0] = 80; 
       	coordinates_range[32][1] = 61;
       	coordinates_range[33][0] = 199; 
       	coordinates_range[33][1] = 61;
       
        
     	coordinates_range[34][0] = 196; 
       	coordinates_range[34][1] = 61;
       	coordinates_range[35][0] = 196; 
       	coordinates_range[35][1] = 222;
       
       	
       	coordinates_range[36][0] = 214; 
       	coordinates_range[36][1] = 222;
       	coordinates_range[37][0] = 214; 
       	coordinates_range[37][1] = 222;
       
        
    	coordinates_range[38][0] = 65; 
       	coordinates_range[38][1] = 238;
       	coordinates_range[39][0] = 584; 
       	coordinates_range[39][1] = 238;
       
       	
       	coordinates_range[40][0] = 65; 
       	coordinates_range[40][1] = 218;
       	coordinates_range[41][0] = 584; 
       	coordinates_range[41][1] = 218;
        
        
       	coordinates_range[42][0] = 246; 
       	coordinates_range[42][1] = 238;
       	coordinates_range[43][0] = 246; 
       	coordinates_range[43][1] = 293;
        
       	
       	coordinates_range[44][0] = 269; 
       	coordinates_range[44][1] = 238;
       	coordinates_range[45][0] = 269; 
       	coordinates_range[45][1] = 293;
        
       	
       	coordinates_range[46][0] = 190; 
       	coordinates_range[46][1] = 409;
       	coordinates_range[47][0] = 493; 
       	coordinates_range[47][1] = 409 ;
        
       	
       	coordinates_range[48][0] = 190; 
       	coordinates_range[48][1] = 391;
       	coordinates_range[49][0] = 190; 
       	coordinates_range[49][1] = 391;
        
       	
     	coordinates_range[50][0] = 429; 
       	coordinates_range[50][1] = 238;
       	coordinates_range[51][0] = 429; 
       	coordinates_range[51][1] = 408;
       	
       	
       	coordinates_range[52][0] = 443; 
       	coordinates_range[52][1] = 238;
       	coordinates_range[53][0] = 443; 
       	coordinates_range[53][1] = 408;
       	
       	
       	coordinates_range[54][0] = 434; 
       	coordinates_range[54][1] = 216;
       	coordinates_range[55][0] = 434; 
       	coordinates_range[55][1] = 41;
       	
       	
       	coordinates_range[56][0] = 450; 
       	coordinates_range[56][1] = 216;
       	coordinates_range[57][0] = 450; 
       	coordinates_range[57][1] = 41;
       	
       	
       	coordinates_range[58][0] = 377; 
       	coordinates_range[58][1] = 58;
       	coordinates_range[59][0] = 640; 
       	coordinates_range[59][1] = 58;
       	
       	
       	coordinates_range[60][0] = 377; 
       	coordinates_range[60][1] = 41;
       	coordinates_range[61][0] = 640; 
       	coordinates_range[61][1] = 41;
       	
       	
       	coordinates_range[62][0] = 562; 
       	coordinates_range[62][1] = 59;
       	coordinates_range[63][0] = 562;
       	coordinates_range[63][1] = 221;
       	
       	
       	coordinates_range[64][0] = 585; 
       	coordinates_range[64][1] = 59;
       	coordinates_range[65][0] = 585; 
       	coordinates_range[65][1] = 221;
       	
       	
       	//----------------------------------^^define corridors
       	

//        for (int i = 0; i < coordinates.length; i++) {
//            System.out.println("Koordinate " + (i + 1) + ": (x = " + coordinates[i][0] + ", y = " + coordinates[i][1] + ")");
//        }
    }
}
