package package01;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Interface {

    JFrame frame;
    private JLabel image_hospital_plan;
    private String image_path = "/package01/hospital_plan.png";

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

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        
        image_hospital_plan = new JLabel(new ImageIcon(Interface.class.getResource(image_path)));
        image_hospital_plan.setHorizontalAlignment(SwingConstants.CENTER);

        
        DrawingPanel drawingPanel = new DrawingPanel();
        drawingPanel.setOpaque(false); 

        
        frame.getContentPane().setLayout(null);
        
        image_hospital_plan.setBounds(0, 0, 800, 600);
        frame.getContentPane().add(image_hospital_plan);

        
        drawingPanel.setBounds(0, 0, 800, 600);
        frame.getContentPane().add(drawingPanel);

        
        
        
        int x = image_hospital_plan.getBounds().x;
        int y = image_hospital_plan.getBounds().y;
        int width = image_hospital_plan.getWidth();
        int height = image_hospital_plan.getHeight();

        System.out.println("X-Koordinate: " + x);
        System.out.println("Y-Koordinate: " + y);
        System.out.println("Breite: " + width);
        System.out.println("Höhe: " + height);

        image_hospital_plan.addMouseListener(new MouseAdapter() {
        	//image_hospital_plan.addMouseMotionListener(new MouseMotionAdapter() {	
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                System.out.println("Maus bewegt: X = " + mouseX + ", Y = " + mouseY);
                
                ArrayList<int[]> coordinates = new ArrayList<>();
                coordinates.add(new int[]{mouseX, mouseY});
            }
        });
        
        
        
        
        
        JButton btnKonfiguration = new JButton("Konfiguration");
        btnKonfiguration.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Anmeldung();
        		frame.setVisible(false);
        	}
        });
        btnKonfiguration.setBounds(157, 611, 150, 40);
        frame.getContentPane().add(btnKonfiguration);

        JButton button_start_search = new JButton("Suche Starten");
        button_start_search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	      
            	int[] start = {20, 20};  
    	 		int[] goal = {64, 220};   
                 		
    	 		Node node = new Node();
    	 		Node.start(start, goal);

            
        		
        	}
        });
        button_start_search.setBounds(357, 611, 150, 40);
        frame.getContentPane().add(button_start_search);
        
  
         

        JButton button_help = new JButton("Hilfe");
        button_help.setBounds(614, 611, 150, 40);
        frame.getContentPane().add(button_help);

        frame.setSize(820, 700);
        frame.setVisible(true);

        
        int[][] testPositions = {{50, 50}, {200, 200}, {300, 300}, {350, 350}};
        drawingPanel.setPositionsArray(testPositions);
    }

}



