import java.awt.Color;

/**
 * This Class will help in creating a list of all the six shapes for performing bubble sort on them
 * @author Yixing Cao
 *
 */
public class AllMixedShapes {
	// These are the attributes of the Mixed shapes (Rectangle, Square, Circle whatever it is)
	protected double area;		// This is the most important attribute for this class (we will sort all six shapes based on this attribute)
	protected Circle circle;
	protected Rectangle rectangle;
	protected Square square;
	protected int chance;
	protected Color color;
	
	// This constructor will instantiate AllMixedShapes specifying which one is Circle, Rectangle, or Square along with its surface area
	public AllMixedShapes(double area, Circle circle, Rectangle rectangle, Square square, int chance, Color color) {
		this.area = area;
		this.circle = circle;
		this.rectangle = rectangle;
		this.square = square;
		this.chance = chance;
		this.color = color;
	}
}
