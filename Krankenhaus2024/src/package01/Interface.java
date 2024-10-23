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

    	
   int[] startNode = {100, 200};  // coordinates of the start node
   int[] goalNode = {500, 400};   // coordinates of the destination node
	
  // double distance = manhattanDistance(startNode, goalNode);
    	
 }
    private static double manhattanDistance(int[] startNode, int[] goalNode) {
    	
    	
    	int x12 = startNode[0];
        int y12 = startNode[1];
        int x13 = goalNode[0];
        int y13 = goalNode[1];

        
        int result=(int) Math.sqrt(Math.pow(x13 - x12, 2) + Math.pow(y13 - y12, 2));
        	
        	
        
        return result;
       
    	
			}

    
    
    public static void distance(String[] arg) {
        // Array of node coordinates
        int[][] nodes = {

            {64, 47}, {64, 226}, {204, 47}, {204, 226}, {252, 226},
            {252, 395}, {436, 395}, {436, 226}, {573, 226}, {573, 52}, {441, 52}
        };

        double totalDistance = 0.0;

        // Calculate the total distance for the path
        for (int i = 0; i < nodes.length - 1; i++) {
            totalDistance +=manhattanDistance(nodes[i], nodes[i + 1]);
        }

        System.out.println("Total distance for the path: " + totalDistance);
    }
    
    
    
    
    
    
    //https://www.geeksforgeeks.org/a-search-algorithm/
    
    
    
    
	    }
    