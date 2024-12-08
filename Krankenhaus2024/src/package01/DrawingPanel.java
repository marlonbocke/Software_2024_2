package package01;
//
//import java.awt.BasicStroke;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//
//import javax.swing.JPanel;
//
//class DrawingPanel extends JPanel {
//
//    private int[][] positionsArray1;
//    private boolean drawLine = false;
//    public DrawingPanel() {
//        setOpaque(false);
//    }
//
//    public void setPositionsArray(int[][] positionsArray) {
//    	
//        this.positionsArray1 = positionsArray;
//    	
//    	
//    	
//        drawLine = true;
//        repaint(); // Call repaint only once after setting data
//        
//        System.out.println("DrawingClass is working");
//        
//        for(int i=0; i < positionsArray1.length; i++)
//        {
//        	
//        	for(int j=0; j < positionsArray1[i].length; j++)
//            {
//            	
//        		System.out.println(positionsArray1[i][j]);
//                        	      	
//            }	
//            
//      	
//       	
//        }	
//        	
//              
//    }
//   
//    @Override
//    protected void paintComponent(Graphics g) {
//    	
//        System.out.println("paint1");
////        super.paintComponent(g);
////
////        if (drawLine && positionsArray1 != null && positionsArray1.length > 1) {
////            Graphics2D g2d = (Graphics2D) g;
////            g2d.setColor(Color.RED);
////            g2d.setStroke(new BasicStroke(2));
////
////            System.out.println("paint2");
////
////            // Schleife durchlaufen, aber nur bis zum vorletzten Punkt
////            for (int i = 0; i < positionsArray1.length - 1; i++) {
////                int x = positionsArray1[i][0];
////                int y = positionsArray1[i][1];
////                int x2 = positionsArray1[i + 1][0];
////                int y2 = positionsArray1[i + 1][1];
////                g2d.drawLine(x, y, x2, y2); // Linie zwischen zwei Punkten zeichnen
////            }
////        }
////
////        
//    }
//}
////
////
////
//
//   //some problems with the "drawline" function. paintComponent method dont't work. I will fix that tomorrow after the job interview.  
//    
//

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class DrawingPanel extends JPanel {
    private int[][] positionsArray1;
    private boolean drawLine = false;

    public DrawingPanel() {
        setOpaque(false); // Transparent
    }

    public void setPositionsArray(int[][] positionsArray) {
        this.positionsArray1 = positionsArray;
        drawLine = true;
        repaint(); // Aktualisiere das Panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Hintergrund zeichnen
        if (drawLine && positionsArray1 != null && positionsArray1.length > 1) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(2));

            // Schleife durchlaufen, aber nur bis zum vorletzten Punkt
            for (int i = 0; i < positionsArray1.length - 1; i++) {
                int x = positionsArray1[i][0];
                int y = positionsArray1[i][1];
                int x2 = positionsArray1[i + 1][0];
                int y2 = positionsArray1[i + 1][1];
                g2d.drawLine(x, y, x2, y2); // Linie zwischen zwei Punkten zeichnen
            }
        }
    }
}





