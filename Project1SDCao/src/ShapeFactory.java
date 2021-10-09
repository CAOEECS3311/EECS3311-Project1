import java.awt.Color;
import java.util.List;
import java.util.Random;

/**
 * This class will help in instantiating all the six shapes on the jframe
 * @author Yixing Cao
 */
public class ShapeFactory {
	// This method will instantiate for the given shapeType
	public Shape buildShape(String shapeType, int xLoc, int yLoc, int width, int height, Color color) {
		if(shapeType.equals("Circle")) {
			return new Circle(xLoc, yLoc, width, height, color);			// instantiating circle
		} else if(shapeType.equals("Rectangle")) {
			return new Rectangle(xLoc, yLoc, width, height, color);			// instantiating rectangle
		} else {
			return new Square(xLoc, yLoc, width, height, color);			// instantiating square
		}
	}
}
