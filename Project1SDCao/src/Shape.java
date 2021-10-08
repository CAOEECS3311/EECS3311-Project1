import java.awt.Color;

/**
 * This class is a base class which embodies the generic concept of a Shape
 * @author Yixing Cao
 */
public class Shape {
	
	// These are the useful variables for any type of shape
	protected int upperX; 
	protected int upperY;
	protected int width;
	protected int height;
	protected Color shapeColor;
	
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
	
	// setters for the attributes/properties of the Shape
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
