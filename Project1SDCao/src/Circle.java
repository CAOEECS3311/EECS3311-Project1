import java.awt.Color;
import java.awt.Graphics;

/**
 * This class extends Shape class for representing the shape of a Circle
 * @author Yixing Cao
 */
class Circle extends Shape {
	private double surface;		// This variable will store the surface of the circle
	private static final double PI = 3.14;			// static variable PI, this is useful for calculating surface of a circle
	
	// getters for the surface of the circle
	public double getSurface() {
		return surface;
	}
	
	// setters for the surface of the circle
	public void setSurface(double surface) {
		this.surface = surface;
	}

	// This constructor will instantiate the circle along with its surface calculation
	public Circle(int upperX, int upperY, int width, int height, Color shapeColor) {
		super(upperX, upperY, width, height, shapeColor);		// calling base class constructor
		this.setSurface(calculateSurface(this.getHeight(), this.getWidth()));		// setting the surface of the circle after calling calculateSurface()
	}

	// This method will calculate the surface of the circle. (PI*Radius*Radius)
	// Radius will be half of the height/width. Please note that height and width are equal for circle 
	private double calculateSurface(int height, int width) {
		int radius = width/2;
		double area = PI*radius*radius;
		return area;
	}

	// This Method will draw a circle with the given color
	protected void drawShape(Graphics form, Color color) {
		form.setColor(color);
		form.fillOval(upperX, upperY, width, height);
	}
}
