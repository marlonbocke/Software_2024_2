package package01;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javax.lang.model.element.Name;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

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
       
    	if (java.awt.GraphicsEnvironment.isHeadless()) {
    	    System.err.println("Die Umgebung ist headless. GUI-Funktionen sind nicht verfügbar.");
    	    // Alternativ: Programm ohne GUI starten
    	} else {
    	    // GUI-Komponenten initialisieren
    	    initialize();
    	}

    	
    	
        
    }

 
   
    private <BufferedImage> void initialize() {
    	frame = new JFrame();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		//frame.setBounds(0, 0, screen.width, screen.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setUndecorated(false);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
        
		DrawingPanel drawingPanel = new DrawingPanel();
        drawingPanel.setBounds(621, 256, 657, 464); // Gleiche Bounds wie das Bild
        frame.getContentPane().add(drawingPanel);
        

        image_hospital_plan = new JLabel("hospital_plan");
        image_hospital_plan.setBounds(621, 256, 657, 464);
        image_hospital_plan.setIcon(new ImageIcon(Interface.class.getResource(image_path)));
        frame.getContentPane().add(image_hospital_plan);
          
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
        btnKonfiguration.setBounds(472, 390, 121, 33);
        btnKonfiguration.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnKonfiguration.setVerticalAlignment(SwingConstants.BOTTOM);
        btnKonfiguration.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		frame.setVisible(false);
        		//new Settings();
        		new Anmeldung();
        	}
        });
        frame.getContentPane().add(btnKonfiguration);
        
        JButton button_start_search_1 = new JButton("Hilfe");
        button_start_search_1.setBounds(1288, 281, 121, 33);
        frame.getContentPane().add(button_start_search_1);
    

        
        JButton button_start_search = new JButton("Suche Starten");
        button_start_search.setBounds(472, 263, 121, 33);
        button_start_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Action for search button
            		System.out.println("search button is working");
            		
            	//drawingPanel.setLineCoordinates(50, 50, 600, 400);
            	
            		
            		 int[] start = {20, 20};  
                   int[] goal = {64, 220};   
                              		
            		Node node = new Node();
            		Node.start(start, goal);
            		                   		
            		
            	
            }
        });
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(button_start_search);

        
       
    }

}




class DrawingPanel extends JPanel {

    private int[][] positionsArray;
    private boolean drawLine = false;
    public DrawingPanel() {
        setOpaque(false);
    }

    public void setPositionsArray(int[][] positionsArray) {
        this.positionsArray = positionsArray;
        drawLine = true;
        repaint(); // Call repaint only once after setting data
    }

    @Override
    protected void paintComponent(Graphics g) {
    	System.out.println("paint1");
        super.paintComponent(g);
        if (drawLine) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(2));

            // Loop to draw lines between consecutive points
            System.out.println("paint2");
            
            for (int i = 0; i < positionsArray.length; i++) {
                int x = positionsArray[i][0];
                int y = positionsArray[i][1];
                int x2 = positionsArray[i + 1][0];
                int y2 = positionsArray[i + 1][1];
                g2d.drawLine(x, y, x2, y2);
            }
        }
    }
}
//
//
//

   //some problems with the "drawline" function. paintComponent method dont't work. I will fix that tomorrow after the job interview.  
    

    

