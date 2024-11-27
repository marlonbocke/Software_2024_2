package package01;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
//import java.lang.classfile.components.ClassPrinter.LeafNode;
//import java.lang.classfile.components.ClassPrinter.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import com.mysql.cj.jdbc.Driver;
import javax.lang.model.element.Name;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;

public class Settings {

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
     * @wbp.parser.entryPoint
     */
    public Settings() {
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

        image_hospital_plan.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                System.out.println("Maus bewegt: X = " + mouseX + ", Y = " + mouseY);
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
        btnKonfiguration.setBounds(896, 222, 109, 23);
        frame.getContentPane().add(btnKonfiguration);
        
        JButton btnChangeroom = new JButton("Raum ändern");
        btnChangeroom.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnChangeroom.setBounds(1061, 750, 109, 23);
        frame.getContentPane().add(btnChangeroom);
        
        JButton btnBlockroad = new JButton("Weg sperren");
        btnBlockroad.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnBlockroad.setBounds(621, 750, 105, 23);
        frame.getContentPane().add(btnBlockroad);
                      JCheckBox chckAdmin = new JCheckBox("Administrator");
                      chckAdmin.setBounds(908, 720, 97, 23);
                      frame.getContentPane().add(chckAdmin);
        
    
        JButton btnUnblockroad = new JButton("Weg offen");
        btnUnblockroad.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        	
        	
        });
        btnUnblockroad.setBounds(736, 750, 97, 23);
        frame.getContentPane().add(btnUnblockroad);
        
        JButton btnReplaceroom = new JButton("Raum_ersetzen");
        btnReplaceroom.setBounds(1180, 750, 109, 23);
        frame.getContentPane().add(btnReplaceroom);
        
        JButton btnCloseroom = new JButton("Raum_schließen");
        btnCloseroom.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCloseroom.setBounds(942, 750, 109, 23);
        frame.getContentPane().add(btnCloseroom);
        
        JButton btnOpenroom = new JButton("Raum offen");
        btnOpenroom.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnOpenroom.setBounds(843, 750, 89, 23);
        frame.getContentPane().add(btnOpenroom);
        
        JButton btnNewButton = new JButton("Speichern");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(905, 185, 89, 23);
        frame.getContentPane().add(btnNewButton);
        chckAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckAdmin.isSelected()) {
                    btnUnblockroad.setVisible(true);
                    btnBlockroad.setVisible(true);
                    btnChangeroom.setVisible(true);
                    btnOpenroom.setVisible(true) ;
                    btnReplaceroom.setVisible(true) ;
                    btnCloseroom.setVisible(true);
                    // Add other buttons you want to show/hide
                } else {
                	btnReplaceroom.setVisible(false) ;
                	btnOpenroom.setVisible(false) ; 
                    btnUnblockroad.setVisible(false);
                    btnBlockroad.setVisible(false);
                    btnChangeroom.setVisible(false);
                    btnCloseroom.setVisible(false);
                    // Add other buttons you want to show/hide
                }
            }
        });
    

    
    }
}




