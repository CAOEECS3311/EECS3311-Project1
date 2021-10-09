import java.awt.Graphics;
import java.util.List;

/**
 * This class will help in displaying all the six shapes on the JFrame
 * @author Yixing Cao
 */
public class DisplayShape {
	/**
	 * This method will show all the six shapes on the JFrame
	 * @param allMixed list of shapes with their properties 
	 * @param g Graphics object for drawing the shape on the frame
	 */
	protected void show(List<AllMixedShapes> allMixed, Graphics g) {
		// iterating over all the six shapes for drawing
		for(AllMixedShapes mixedShape:allMixed) {
			// chance means identification of the shape (1 for circle, 2 for rectangle, and 3 for square)
			int chance = mixedShape.chance;		
        	if(chance==1) {
        		Shape circle = mixedShape.shapeType;	
        		circle.drawShape(g, circle.getColor());			// drawing the circle 
        	} else if(chance == 2) {
        		Shape rectangle = mixedShape.shapeType;
        		rectangle.drawShape(g, rectangle.getColor());		// drawing the rectangle
        	} else {
        		Shape square = mixedShape.shapeType;
        		square.drawShape(g, square.getColor());		// drawing the square
        	}
        }
	}
}
