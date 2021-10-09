import java.awt.Color;
import java.awt.Graphics;

/**
 * This class extends Shape class for representing the shape of a Circle, also implement both of the abstract methods of Shape
 * @author Yixing Cao
 */
class Circle extends Shape {
	private static final double PI = 3.14159;			// static variable PI, this is useful for calculating surface of a circle
	
	// This constructor will instantiate the circle along with its surface calculation
	Circle(int upperX, int upperY, int width, int height, Color shapeColor) {
		super(upperX, upperY, width, height, shapeColor);		// calling base class constructor
		this.setSurface(calculateSurface(this.getHeight(), this.getWidth()));		// setting the surface of the circle after calling calculateSurface()
	}

	// This method will calculate the surface of the circle. (PI*Radius*Radius)
	// Radius will be half of the height/width. Please note that height and width are equal for circle 
	@Override
	protected double calculateSurface(int height, int width) {
		double radius = (double)(width)/2.0;
		double area = PI*radius*radius;
		return area;
	}

	// This Method will draw a circle with the given color
	@Override
	protected void drawShape(Graphics g, Color color) {
		g.setColor(color);
		g.fillOval(super.getUpperX(), super.getUpperY(), super.getWidth(), super.getHeight());
	}

}
