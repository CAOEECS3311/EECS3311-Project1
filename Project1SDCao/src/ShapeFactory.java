import java.awt.Color;
import java.util.List;
import java.util.Random;

/**
 * This class will help in instantiating all the six shapes on the jframe
 * @author Yixing Cao
 */
public class ShapeFactory {
	Random rand = new Random();				// for generating random size of shapes and random color every time we click on "Load Button"
	/**
	 * This method will generate different combinations of colors (R,G,B) on every load shape button click
	 * @return
	 */
	protected Color generateNewColor() {
		// generating random numbers for different color combinations
    	int R = Math.abs(rand.nextInt());	
    	int G = Math.abs(rand.nextInt());
    	int B = Math.abs(rand.nextInt());
    	
    	// making random numbers in range after modulo with 255 because color range lies in 0-255
    	B %= 255;
    	R %= 255;
    	G %= 255;
    	Color color = new Color(R,B,G);			// making object of new color combination
    	return color;		// returning new color combination
    }
	
	/**
	 * This method will instantiate all the six shapes on the JFrame
	 * @param allMixed
	 */
	protected void fillShape(List<AllMixedShapes> allMixed) {
		int xLoc = 20;		// starting position of x-coordinate of the first shape
    	int yLoc = 3;		// starting position of y-coordinate of the first shape
    	
    	// iterating six times for showing six different shapes
    	for(int i=0;i<6;i++) {
        	int currentWidth = 50+Math.abs(rand.nextInt())%30;			// generating random width for the current shape
        	int currentHeight = 50+Math.abs(rand.nextInt())%30;		// generating random height for the current shape
        	int minVal = Math.min(currentWidth, currentHeight);			// getting the minimum value in both height and width for circle
        	int chance = Math.abs(rand.nextInt())%3+1;		// this variable will identify what is the current shape (Circle/Square/Rectangle)
        	if(chance == 1) {				// Draw Circle
        		Circle circle = new Circle(xLoc, yLoc, minVal, minVal, generateNewColor());			// instantiating circle
            	AllMixedShapes currentShape = new AllMixedShapes(circle.getSurface(), circle, null, null, chance, circle.getColor());	// this is for sorting purpose
            	allMixed.add(currentShape); 	// adding current circle shape into the list of Mixed Shapes
        	} else if(chance == 2) {		// Draw Rectangle
        		Rectangle rectangle = new Rectangle(xLoc, yLoc, currentWidth, currentHeight, generateNewColor());			// instantiating rectangle
        		AllMixedShapes currentShape = new AllMixedShapes(rectangle.getSurface(), null, rectangle, null, chance, rectangle.getColor());
            	allMixed.add(currentShape);		// adding current rectangle shape into the list of Mixed Shapes
        	} else {						// Draw Square
        		Square square = new Square(xLoc, yLoc, currentWidth, currentWidth, generateNewColor());			// instantiating square
        		AllMixedShapes currentShape = new AllMixedShapes(square.getSurface(), null, null, square, chance, square.getColor());
            	allMixed.add(currentShape);		// adding current square shape into the list of Mixed Shapes
        	}
        	// Every time, x-position and y-position for the new shape will be incremented with constant value
        	xLoc += 83;			 
        	yLoc += 83;
    	} 

	}
}
