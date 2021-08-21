package animated_ScreenSaver;

//File: ShapeComponent
//Name: Harsh Rana


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

import javax.swing.JComponent;

/**
 * ShapeComponent is attached to the frame to make anything/everything drawn on canvas visible to the user.
 */
public class ShapeComponent extends JComponent
{  
	
	static Random rand = new Random();
	final double pi = Math.PI;
	
	// Instance variables
	private Timer t;
	private ArrayList<Shape3Animated> shape;
	
	//Constructor
	/**
	 *Constructor creates an array list of Shape3Animated and starts the timer as soon as it is called
	 */
	public ShapeComponent(){
		shape = new ArrayList<Shape3Animated>();
		for (int i=0; i<rand.nextInt(10)+10 ; i++) {
			// The section for generation is hard coded because getHeight() and getWidth() at this point are both 0.
			shape.add(new Shape3Animated(getDouble(120,900),getDouble(120,600), getDouble(10,30) ,rand.nextInt(9)+1));	
			
		}
		startTimer();// Calls the startTimer method
	}
	
	/**
	 * just a helper method that generates a random double in the specified range
	 * @param from - The number from which the range starts
	 * @param to - The number at which the range ends
	 * @return - The generated random number
	 */
	private double getDouble(double from, double to){
		return (from + (to - from) * rand.nextDouble());
		
	}
	
	/**
	 * Sets up the timer for the animation to be run. Also has the changes to be performed and the time after which they are to be performed.
	 */
	
	public void newDir(Shape3Animated s) {
		if(s.getDirection() >= 0 && s.getDirection() <= pi/2) {
			s.setDirection(s.getDirection()+(pi/2));
		}
		else if(s.getDirection() >= pi/2 && s.getDirection() <= pi) {
			s.setDirection(s.getDirection()+(pi/2));
		}
		else if(s.getDirection() >= pi && s.getDirection() <= (3*pi)/2) {
			s.setDirection(s.getDirection()+(pi/2));
		}
		else{
			s.setDirection(s.getDirection()-(pi/2));
		}
	}
	
	private void startTimer(){
		
        class TimerListen implements ActionListener{
        	
            public void actionPerformed(ActionEvent event){
            	
            	for(Shape3Animated s : shape){
            		double xtraBigX = (s.getX()+(2*s.getDimension()))- getWidth();
            		double xtraBigY = (s.getY()+(2*s.getDimension()))- getHeight();
            		
            		// condition of touching the border of the frame
            		
            		if(xtraBigX>0) {
        				s.setX(s.getX()-xtraBigX);
        				if(s.getDirection() > 0 && s.getDirection() < pi/2) {
            				s.setDirection(s.getDirection()+(pi/2));
            			}
            			else if(s.getDirection() > 3*pi/2 && s.getDirection() < 2*pi) {
            				s.setDirection(s.getDirection()-(pi/2));
            			}
            			else if(s.getDirection() == 0){
            				s.setDirection(s.getDirection()+(pi));
            			}
            			else if(s.getDirection() == 2*pi) {
            				s.setDirection(s.getDirection()-(pi));
            			}
        				s.move();
        			}
            		
            		if(xtraBigY>0) {
            			s.setX(s.getX()-xtraBigY);
            			if(s.getDirection() > 0 && s.getDirection() < pi/2) {
            				s.setDirection(s.getDirection()+(3*pi/2));
            			}
            			else if(s.getDirection() > pi/2 && s.getDirection() < pi) {
            				s.setDirection(s.getDirection()+(pi/2));
            			}
            			else if(s.getDirection() == 3*pi/2){
            				s.setDirection(s.getDirection()+(pi));
            			}
        				s.move();
        			}
            		
            		if(s.getX()-(2*s.getDimension()) < 0) {
            			s.setX(s.getX()-(s.getX()-(2*s.getDimension())));
            			if(s.getDirection() > pi && s.getDirection() < 3*pi/2) {
            				s.setDirection(s.getDirection()+(pi/2));
            			}
            			else if(s.getDirection() > pi/2 && s.getDirection() < pi) {
            				s.setDirection(s.getDirection()-(pi/2));
            			}
            			else if(s.getDirection() == pi){
            				s.setDirection(s.getDirection()-(pi));
            			}
        				s.move();
            		}
            		
            		if(s.getY()-(2*s.getDimension()) < 0) {
            			if(s.getDirection() > 3*pi/2 && s.getDirection() < 2*pi) {
            				s.setDirection(s.getDirection()-(3*pi/2));
            			}
            			else if(s.getDirection() > pi && s.getDirection() < 3*pi/2) {
            				s.setDirection(s.getDirection()-(pi/2));
            			}
            			else if(s.getDirection() == 3*pi/2){
            				s.setDirection(s.getDirection()-(pi));
            			}
        				s.move();
            		}
            		
        			else {
        				//to move the shapes, once generated
        				s.move();
        			}
        			repaint();
        		}
            }
        }
        
        t = new Timer(1000/50, new TimerListen());
        t.start(); 
    }
	
	/**
	 * Displays the component.
	 */
	public void paintComponent(Graphics g)
	{  
		Graphics2D g2 = (Graphics2D) g;
		
		for(Shape3Animated s : shape){
			s.draw(g2);
		}
	}
}

