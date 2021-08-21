package animated_ScreenSaver;

//File: Shape2
//Name: Harsh Rana


import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Shape2 extends Shape1{
	// No additional instance variables needed for shape 2.
	
	//Constructor.
    /**
     * Shape 2 is an ellipse that is drawn over shape 1.
     * @param xcen - The x coordinate of the center of the shape
     * @param ycen - The y coordinate of the center of the shape
     * @param dimensions - The height and width of shape are determined by the dimension.
     */
    public Shape2(double xcen, double ycen, double dimension) {
    	
    	// Stores the instance variables in the superclass
		super(xcen, ycen, dimension);
	}

	@Override
	/**
	 * This draw method overrides the draw in Shape1 and it belongs to Shape2.
	 */
    public void draw(Graphics2D g2){
		
		
		
		// Remaining elements required to complete shape2.
		Ellipse2D.Double shape = new Ellipse2D.Double(getX()-getDimension() , getY()-2*getDimension(), 2*getDimension(), 4*getDimension());
		g2.draw(shape);
		g2.fill(shape);
		
		// Implements the draw method one level up, in this case that is Shape1.
		super.draw(g2);
	
	}
}