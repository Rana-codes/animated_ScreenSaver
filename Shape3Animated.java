package animated_ScreenSaver;

//File: Shape3Animated
//Name: Harsh Rana


import java.awt.Graphics2D;

public class Shape3Animated extends Shape3{
	
	// for calculation purposes
	private final double pi = Math.PI;
	
	//Additional instance fields for Shape3Animated
	private double direction;  
    private int velocity; 
    
    /**
     * Shape3Animated is basically shape3 with 2 additional qualities.
     * @param xcen - The x coordinate of the center of the shape
     * @param ycen - The y coordinate of the center of the shape
     * @param dimensions - The height and width of shape are determined by the dimension.
     * @param vel - The velocity the user wants(in pixels)
     */
    public Shape3Animated(double xcen, double ycen, double dimension, int vel) {
		super(xcen, ycen, dimension);
		//Direction is chosen from 0 to 2pi because I want my shapes to move in ANY direction, not just up,down,etc.
		direction = rand.nextDouble()*(2*pi);
		velocity = vel;
	}
    
    /**
     * Moves the shape in the given direction with the given velocity.
     * (Basically changes the position of its x and y with respect to velocity)
     */
    public void move(){  
    	setX(getX()+(velocity*(Math.cos(direction))));
    	setY(getY()+(velocity*(Math.sin(direction))));
    	
    }
    
    /**
     * When the elements touch the border, their direction is changed.
     */
    public void bounceBack(){  
    	// I have subtracted - pi/2 so that the shapes bounce back at an angle. This would truly allow free movement
    	// if I just did -pi, the shapes would still go back but they would be stuck in a particular path and would just keep going back and forth.
    	direction = direction-(pi/2);
    	move();
    	
    }
    
    public void setDirection(double newDir) {
    	direction = newDir;
    }
    
    public double getDirection() {
    	return direction;
    }
   
   @Override 
   /**
	 * This draw method overrides the draw in Shape3 and it belongs to Shape3Animated.
	 */
    public void draw(Graphics2D g2){
	   super.draw(g2);
	   
	}
}
