package package01;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.classfile.components.ClassPrinter.LeafNode;
import java.lang.classfile.components.ClassPrinter.Node;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Interface {

    JFrame frame;
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
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0, 0, screen.width, screen.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
        
        
        JButton button_start_search = new JButton("Suche Starten");
        button_start_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Action for search button
            }
        });
        button_start_search.setBounds(472, 281, 121, 33);
        frame.getContentPane().add(button_start_search);

        image_hospital_plan = new JLabel("hospital_plan");
        image_hospital_plan.setIcon(new ImageIcon(Interface.class.getResource(image_path)));
        image_hospital_plan.setBounds(621, 256, 657, 464);
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
        btnKonfiguration.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnKonfiguration.setVerticalAlignment(SwingConstants.BOTTOM);
        btnKonfiguration.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		frame.setVisible(false);
        		//new Settings();
        		new Anmeldung();
        	}
        });
        btnKonfiguration.setBounds(472, 390, 121, 33);
        frame.getContentPane().add(btnKonfiguration);
        
        JButton button_start_search_1 = new JButton("Hilfe");
        button_start_search_1.setBounds(1288, 281, 121, 33);
        frame.getContentPane().add(button_start_search_1);
    

    
    }
}


