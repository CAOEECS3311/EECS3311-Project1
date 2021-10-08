import java.awt.Color;
import java.awt.Graphics;

/**
 * This class extends Shape class for representing the shape of a Rectangle
 * @author Yixing Cao
 */
class Rectangle extends Shape {
	private int surface;		// This variable will store the surface of the rectangle
	
	// getters for the surface of the rectangle
	public int getSurface() {
		return surface;
	}

	// setters for the surface of the rectangle
	public void setSurface(int surface) {
		this.surface = surface;
	}

	// This constructor will instantiate the rectangle along with its surface calculation
	public Rectangle(int upperX, int upperY, int width, int height, Color shapeColor) {		
		super(upperX, upperY, width, height, shapeColor);		// calling base class constructor
		this.setSurface(calculateSurface(height, width));		// setting the surface of the rectangle after calling calculateSurface()
	}

	// This method will calculate the surface of the rectangle. (x, x+width-1, y, y+height-1)
	private int calculateSurface(int height, int width) {
		int area = (width-1)*(height-1);
		return area;
	}

	// This Method will draw a rectangle with the given color
	protected void drawShape(Graphics form, Color color) {
		form.setColor(color);
		form.fillRect(upperX, upperY, width, height);
	}
}
