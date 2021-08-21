package animated_ScreenSaver;

//File: Shape1
//Name: Harsh Rana

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Shape1 {
	
	//Random is static because it is also used in sub classes.
	static Random rand = new Random();
	
	//Instance Variables
    private double x, y, r;
    private final Color col;
    
    //Constructor.
    /**
     * Shape 1 is an ellipse,its length and breadth are fixed as a function of dimension.
     * @param xcen - The x coordinate of the center of the shape
     * @param ycen - The y coordinate of the center of the shape
     * @param dimensions - The height and width of shape are determined by the dimension.
     */
    public Shape1(double xcen, double ycen, double dimension) {
    	x = xcen;
    	y = ycen;
    	r = dimension;
    	col = randomColor();
    }
    
    /**
     * As the name suggests, returns a random color on being called
     * @return - a random color
     */
    private Color randomColor() {
    	int red = rand.nextInt(256);
    	int g = rand.nextInt(256);
    	int b = rand.nextInt(256);
    	return new Color(red,g,b);
    }
    
    /**
     * Draws and fills the shape .
     * @param g2 - necessary tool for the shape to be drawn
     */
    public void draw(Graphics2D g2){
     
		Ellipse2D.Double shape = new Ellipse2D.Double(x - 2*r , y-r, 4*r, 2*r);
		
		g2.draw(shape);
		g2.fill(shape);
		g2.setColor(col);
    }
    
    /**
     * Gets the value stored in instance variable x(which is the x coordinate of the center of the shape)
     * @return - value stored in instance variable x. 
     */
    public double getX() {
    	return x;
    }
    
    /**
     * Gets the value stored in instance variable y(which is the y coordinate of the center of the shape)
     * @return - value stored in instance variable y. 
     */
    public double getY() {
    	return y;
    }
    
    /**
     * Gets the value stored in instance variable r(which decides height and width of the shape)
     * @return - value stored in instance variable r. 
     */
    public double getDimension() {
    	return r;
    }
    
    /**
     * Changes the value of instance variable x. Made so that other classes can change x.
     * @param newX - The new value of x that is to be set
     */
    public void setX(double newX) {
    	x = newX;
    }
    
    /**
     * Changes the value of instance variable y. Made so that other classes can change y.
     * @param newX - The new value of y that is to be set
     */
    public void setY(double newY) {
    	y = newY;
    }
    
 }
