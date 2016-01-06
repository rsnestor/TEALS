package edu.loudoun.jchs.exercises.chap3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomCircles extends JFrame {
	
	int num = 100;
	public static final int SURFACE_WIDTH = 980;
	public static final int SURFACE_HEIGHT = 640;
	Random rand = new Random();

    public RandomCircles(int num) {

        initUI();
        this.num = num;
    }
    
    /**
     * Define the window in which the drawing will be rendered.
     */
    private void initUI() {
        
        add(new Surface());
        
        setTitle("Basic shapes");
        setSize(SURFACE_WIDTH, SURFACE_HEIGHT);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
    	
    	final int numCircles = (args.length>0)?Integer.parseInt(args[0]):100;
    	//Render the window
        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                RandomCircles ex = new RandomCircles(numCircles);
                ex.setVisible(true);
            }
        });
    }
    
    /**
     * Inner class that extends a JPanel.  This is the "canvas"
     * upon which shapes are rendered.  
     * 
     * @author scottnestor - TEALS, 2015
     *
     */
    class Surface extends JPanel {

        private void doDrawing(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            //grey background
            g2d.setPaint(new Color(150, 150, 150));
            
            RenderingHints rh = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            rh.put(RenderingHints.KEY_RENDERING,
                   RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setRenderingHints(rh);
            
            while (num>0){
            	drawPocadot(g2d);
            	num--;
            }

       }
        
       protected void drawPocadot(Graphics2D g2d) {
    	   
    	   int x = rand.nextInt(SURFACE_WIDTH-19)+10; //range 20-960
    	   int y = rand.nextInt(SURFACE_HEIGHT-19)+10; //range 20-620
    	   int seed = ((SURFACE_WIDTH-(x+10))>(SURFACE_HEIGHT-(y+10)))?(SURFACE_HEIGHT-(y+10)):(SURFACE_WIDTH-(x+10));
    	   int size = rand.nextInt(((seed>y)?y:seed)+1);
    	   //adjust the size to keep within boundary
           g2d.setColor(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
    	   g2d.fillOval(x,y,size,size);

    	   if (x-size<10 || x+size>970 || y-size<10 || y+size> 630 || ((x+size>SURFACE_WIDTH-10) || (y+size>SURFACE_HEIGHT-10) || (SURFACE_HEIGHT-(y+size)<10) || (SURFACE_WIDTH-(x+size)<10))) {
        	   System.out.printf("%d,%d,%d | x=%d-%d | y=%d-%d\n",x,y,size,x-size,x+size,y-size,y+size);    		   
    	   }
    	   
       }

        @Override
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            doDrawing(g);
        }    
    }
    
}
