package edu.loudoun.jchs.exercises.chap3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrafficLight extends JFrame {

    public TrafficLight() {

        initUI();
    }
    
    /**
     * Define the window in which the traffic light will be rendered.
     */
    private void initUI() {
        
        add(new Surface());
        
        setTitle("Basic shapes");
        setSize(250, 525);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

    	//Render the window
        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                TrafficLight ex = new TrafficLight();
                ex.setVisible(true);
            }
        });
    }
    
    /**
     * Inner class that extends a JPanel.  This is the "canvas"
     * upon which shapes are rendered.  In this case, we're using
     * Graphics2D to define rectangular and circular shapes to
     * mimic a traffic light.
     * 
     * @author scottnestor - TEALS, 2015
     *
     */
    class Surface extends JPanel {

        private void doDrawing(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            g2d.setPaint(new Color(150, 150, 150));

            RenderingHints rh = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            rh.put(RenderingHints.KEY_RENDERING,
                   RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setRenderingHints(rh);

            //g2d.fillRect(30, 20, 50, 50);
            //g2d.fillRect(120, 20, 90, 60);
            g2d.fillRoundRect(25, 25, 200, 450, 25, 25);

            //g2d.fill(new Ellipse2D.Double(10, 100, 80, 100));
            //g2d.fillArc(120, 130, 110, 100, 5, 150);
            g2d.setColor(Color.RED);
            g2d.fillOval(62, 50, 125, 125);
            g2d.setColor(Color.YELLOW);
            g2d.fillOval(62, 190, 125, 125);
            g2d.setColor(Color.GREEN);
            g2d.fillOval(62, 330, 125, 125);
       } 

        @Override
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            doDrawing(g);
        }    
    }
    
}
