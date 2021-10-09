import java.awt.Color;

/**
 * This Class will help in creating a list of all the six shapes for performing bubble sort on them
 * @author Yixing Cao
 *
 */
public class AllMixedShapes {
	// These are the attributes of the Mixed shapes (Rectangle, Square, Circle whatever it is)
	protected double area;		// This is the most important attribute for this class (we will sort all six shapes based on this attribute)
	protected Shape shapeType;		// for storing shapeType
	protected int chance;		// for identifying which shape is this
	protected Color color;		// color of the currentShape
	
	// This constructor will instantiate AllMixedShapes specifying which one is Circle, Rectangle, or Square along with its surface area
	public AllMixedShapes(double area, Shape shape, int chance, Color color) {
		this.area = area;
		this.shapeType = shape;
		this.chance = chance;
		this.color = color;
	}
}
