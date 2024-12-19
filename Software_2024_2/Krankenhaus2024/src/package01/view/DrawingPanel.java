package package01.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class DrawingPanel extends JPanel {
    private int[][] positionsArray1;
    private boolean drawLine = false;

    public void setPositionsArray(int[][] positionArray) {
        this.positionsArray1 = positionArray;
        drawLine = true;
        repaint(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (drawLine && positionsArray1 != null && positionsArray1.length > 1) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(2));

            for (int i = 0; i < positionsArray1.length - 1; i++) {
                int x = positionsArray1[i][0];
                int y = positionsArray1[i][1];
                int x2 = positionsArray1[i + 1][0];
                int y2 = positionsArray1[i + 1][1];
                g2d.drawLine(x, y, x2, y2);
            }
        }
    }
}















