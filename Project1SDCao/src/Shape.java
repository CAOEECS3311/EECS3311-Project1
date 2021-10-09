import java.awt.Color;
import java.awt.Graphics;

/**
 * This class is an abstract base class which embodies the generic concept of a Shape
 * @author Yixing Cao
 */
public abstract class Shape {
	
	// These are the useful variables for any type of shape
	private int upperX; 
	private int upperY;
	private int width;
	private int height;
	private Color shapeColor;
	private double surface;
	
	/**
	 * This constructor will instantiate the shape with passed coordinates and properties 
	 * @param upperX upper X (top left) coordinate of the shape
	 * @param upperY upper Y (top left) coordinate of the shape
	 * @param width	width of the shape
	 * @param height height of the shape
	 * @param shapeColor color of the shape
	 */
	public Shape (int upperX, int upperY, int width, int height, Color shapeColor) {
		this.setUpperX(upperX);
		this.setUpperY(upperY);
		this.setColor(shapeColor);
		this.setWidth(width);
		this.setHeight(height);
	}

	// these are the abstract methods of Shape which derived class are forced to implement
	protected abstract double calculateSurface(int height, int weight);
	protected abstract void drawShape(Graphics g, Color color);
	
	// getters for the attributes/properties of the Shape
    public Color getColor() {
		return shapeColor;
	}
    
    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
    
	public int getUpperX() {
		return upperX;
	}
	
	public int getUpperY() {
		return upperY;
	}

	public double getSurface() {
		return surface;
	}
	
	// setters for the attributes/properties of the Shape
	public void setSurface(double surface) {
		this.surface = surface;
	}
	
	 public void setColor(Color aShapeColor) {
		 this.shapeColor = aShapeColor;
	 }
	 
	 public void setWidth( int width) {
		 this.width = width;
	 }
	    
	 public void setHeight(int height) {
		 this.height = height;
	 }
	 
	 public void setUpperX(int upperX) {
		 this.upperX = upperX;
	 }
		
	 public void setUpperY(int upperY) {
		 this.upperY = upperY;
	 }
}
