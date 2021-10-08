import java.awt.Color;
import java.awt.Graphics;

/**
 * This class extends Shape class for representing the shape of a square
 * @author Yixing Cao
 */
class Square extends Shape {
	private int surface;		// This variable will store the surface of the square
	
	// getters for the surface of the square
	public int getSurface() {
		return surface;
	}

	// setters for the surface of the square
	public void setSurface(int surface) {
		this.surface = surface;
	}

	// This constructor will instantiate the square along with its surface calculation
	public Square(int upperX, int upperY, int width, int height, Color shapeColor) {
		super(upperX, upperY, width, height, shapeColor);		// calling base class constructor
		this.setSurface(calculateSurface(height, width));		// setting the surface of the square after calling calculateSurface()
	}

	// This method will calculate the surface of the square. (x, x+width-1, y, y+height-1)
	// Please note that height and width will be same for square
	private int calculateSurface(int height, int width) {
		int area = (width-1)*(height-1);
		return area;
	}

	// This method will draw a square with the given color
	protected void drawShape(Graphics form, Color color) {
		form.setColor(color);
		form.fillRect(upperX, upperY, width, height);
	}
}
