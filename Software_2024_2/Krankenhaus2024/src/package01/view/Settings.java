package package01.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Settings extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private boolean blockMode = false;
    private static List<Point> blockedRoads = new ArrayList<>();
    private JLabel statusLabel;
    private Point lastPoint = null;
    
    public Settings() {
        setTitle("Road Block Manager");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);
        
        // Toolbar for buttons
        JToolBar toolBar = new JToolBar();
        contentPane.add(toolBar, BorderLayout.NORTH);
        
        JButton blockBtn = new JButton("Block Road");
        JButton unblockBtn = new JButton("Unblock Road");
        JButton saveBtn = new JButton("Save Blocks");
        JButton loadBtn = new JButton("Load Blocks");
        
        toolBar.add(blockBtn);
        toolBar.add(unblockBtn);
        toolBar.add(saveBtn);
        toolBar.add(loadBtn);
        
        // Status label
        statusLabel = new JLabel("Click to block/unblock roads");
        contentPane.add(statusLabel, BorderLayout.SOUTH);
        
        // Map panel with mouse listener
        JPanel mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw hospital plan image
                ImageIcon img = new ImageIcon(Main_window.class.getResource("/package01/hospital_plan.png"));
                g.drawImage(img.getImage(), 0, 0, this);
                
                // Draw blocked roads
                g.setColor(Color.RED);
                for (Point p : blockedRoads) {
                    g.fillOval(p.x - 5, p.y - 5, 10, 10);
                }
            }
        };
        
        mapPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clickPoint = new Point(e.getX(), e.getY());
                if (blockMode) {
                    if (lastPoint != null) {
                        addIntermediatePoints(lastPoint, clickPoint);
                    }
                    blockedRoads.add(clickPoint);
                    lastPoint = clickPoint;
                } else {
                    blockedRoads.removeIf(p -> p.distance(clickPoint) < 10);
                    lastPoint = null;
                }
                mapPanel.repaint();
            }
        });
        
        contentPane.add(mapPanel, BorderLayout.CENTER);
        
        // Button actions
        blockBtn.addActionListener(e -> {
            blockMode = true;
            statusLabel.setText("Blocking mode active");
        });
        
        unblockBtn.addActionListener(e -> {
            blockMode = false;
            statusLabel.setText("Unblocking mode active");
        });
        
        saveBtn.addActionListener(e -> saveBlockedRoads());
        loadBtn.addActionListener(e -> loadBlockedRoads());
    }
    
    private void addIntermediatePoints(Point p1, Point p2) {
        int steps = 10;
        for (int i = 1; i < steps; i++) {
            int x = p1.x + (p2.x - p1.x) * i / steps;
            int y = p1.y + (p2.y - p1.y) * i / steps;
            blockedRoads.add(new Point(x, y));
        }
    }
    
    public static List<Point> getBlockedRoads() {
        return blockedRoads;
    }
    
    private void saveBlockedRoads() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("blocked_roads.dat"))) {
            oos.writeObject(blockedRoads);
            statusLabel.setText("Blocked roads saved successfully");
        } catch (IOException ex) {
            statusLabel.setText("Error saving blocked roads");
        }
    }
    
    private void loadBlockedRoads() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("blocked_roads.dat"))) {
            @SuppressWarnings("unchecked")
			List<Point> object = (List<Point>) ois.readObject();
			blockedRoads = object;
            repaint();
            statusLabel.setText("Blocked roads loaded successfully");
        } catch (IOException | ClassNotFoundException ex) {
            statusLabel.setText("Error loading blocked roads");
        }
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Settings frame = new Settings();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
