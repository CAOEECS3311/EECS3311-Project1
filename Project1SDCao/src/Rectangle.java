import java.awt.Color;
import java.awt.Graphics;

/**
 * This class extends Shape class for representing the shape of a Rectangle, also implement both of the abstract methods of Shape
 * @author Yixing Cao
 */
class Rectangle extends Shape {
	// This constructor will instantiate the rectangle along with its surface calculation
	public Rectangle(int upperX, int upperY, int width, int height, Color shapeColor) {		
		super(upperX, upperY, width, height, shapeColor);		// calling base class constructor
		this.setSurface(calculateSurface(height, width));		// setting the surface of the rectangle after calling calculateSurface()
	}

	// This method will calculate the surface of the rectangle. (x, x+width-1, y, y+height-1)
	@Override
	protected double calculateSurface(int height, int width) {
		double area = (width-1)*(height-1)*1.0;
		return area;
	}

	// This Method will draw a rectangle with the given color
	@Override
	protected void drawShape(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(super.getUpperX(), super.getUpperY(), super.getWidth(), super.getHeight());
	}
}
