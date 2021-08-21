package animated_ScreenSaver;

//File: Shape3
//Name: Harsh Rana

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Shape3 extends Shape2{
	// No additional instance variables needed for shape 3.
	
		//Constructor
	    /**
	     * Shape 3 is an square that is drawn over shape 2.
	     * @param xcen - The x coordinate of the center of the shape
	     * @param ycen - The y coordinate of the center of the shape
	     * @param dimensions - The height and width of shape are determined by the dimension.
	     */
   public Shape3(double xcen, double ycen, double dimension) {
		super(xcen, ycen, dimension);
	}

	@Override   
	/**
	 * This draw method overrides the draw in Shape2 and it belongs to Shape3.
	 */
    public void draw(Graphics2D g2){

		
		// Remaining elements required to complete shape3.
		Rectangle2D.Double shape = new Rectangle2D.Double(getX()-(1.5)*getDimension() , getY()-1.5*getDimension(), 3*getDimension(), 3*getDimension()); 
		g2.draw(shape);
		g2.fill(shape);
		

		// Implements the draw method one level up, in this case that is Shape2.
		super.draw(g2);
		
	}

}
