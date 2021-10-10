import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * This class is the starter class for the project execution. This class contains main()
 * @author Yixing Cao
 */
public class Project1Starter {
	
	List<AllMixedShapes> allMixed = new ArrayList<AllMixedShapes>();		// This list will contain all six different shapes based on their surfaces 
	Random rand = new Random();				// for generating random size of shapes and random color every time we click on "Load Button"
	// These are the two buttons on JFrame
	private JButton loadShapes = new JButton("Load Shapes");
    private JButton sortShapes = new JButton("Sort Shapes");
    private RectsPanel panel = new RectsPanel();    // panel container for this project
    private JFrame frame = new JFrame("Display shapes");		// Frame window for storing the six different shapes
    
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
     * This constructor will help in creating frame window, buttons and panel.
     * Also this constructor will implement actionListeners for the above two buttons
     */
    public Project1Starter() {
    	
    	// ActionListener for "Sort Shapes" button
    	sortShapes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	SortingTechnique sortingTechnique = new SortingTechnique();			// creating object of SortingTechnique for calling sortShapes()
            	sortingTechnique.sortShapes(allMixed);			// calling sortShapes() for sorting six different shapes based on their surfaces
            	panel.repaint();			// repaint() for calling to this component's paint method ASAP
            }
        }); 
    	
    	// ActionListener for "Load Shapes" button
        loadShapes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	allMixed.clear();	// for loading six different shapes each time
            	ShapeFactory shapeFactory = new ShapeFactory();			// creating object of ShapeFactory for calling buildShape()
            	
            	int xLoc = 20;		// starting position of x-coordinate of the first shape
            	int yLoc = 3;		// starting position of y-coordinate of the first shape
            	
            	// iterating six times for creating six different shapes
            	for(int i=0;i<6;i++) {
                	int currentWidth = 50+Math.abs(rand.nextInt())%30;			// generating random width for the current shape
                	int currentHeight = 50+Math.abs(rand.nextInt())%30;		// generating random height for the current shape
                	int minVal = Math.min(currentWidth, currentHeight);			// getting the minimum value in both height and width for circle
                	int chance = Math.abs(rand.nextInt())%3+1;		// this variable will identify what is the current shape (Circle/Square/Rectangle)
                	Shape currentShape = null;
                	if(chance == 1) {				// Draw Circle
                		currentShape = shapeFactory.buildShape("Circle", xLoc, yLoc, minVal, minVal, generateNewColor());
                	} else if(chance == 2) {		// Draw Rectangle
                		currentShape = shapeFactory.buildShape("Rectangle", xLoc, yLoc, currentWidth, currentHeight, generateNewColor());
                	} else {						// Draw Square
                		currentShape = shapeFactory.buildShape("Square", xLoc, yLoc, currentWidth, currentWidth, generateNewColor());
                	}
                	AllMixedShapes newShape = new AllMixedShapes(currentShape.getSurface(), currentShape, chance, currentShape.getColor());	// this is for sorting purpose
                	allMixed.add(newShape);			// adding currentShape to the list
                	// Every time, x-position and y-position for the new shape will be incremented with constant value
                	xLoc += 83;			 
                	yLoc += 83;
            	} 
            	panel.repaint();		// repaint() for calling to this component's paint method ASAP
            } 
        });
        
        // Here is the default options for frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);		// as mentioned in requirement 
        frame.setLayout(new FlowLayout());
        frame.add(loadShapes, BorderLayout.NORTH);        
        frame.add(sortShapes, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setResizable(false); 
    }
    
    // This class will help in calling paint() and calling show() of DisplayShape class
    @SuppressWarnings("serial")
	private class RectsPanel extends JPanel {
    	protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            DisplayShape displayShape = new DisplayShape();
            displayShape.show(allMixed, g);
        }

    	// preferred dimension
        public Dimension getPreferredSize() {
            return new Dimension(600, 600);
        }
    }
    
    // This is the main() which will start the project execution
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	@SuppressWarnings("unused")
				Project1Starter pS1 = new Project1Starter();			// project execution starts from here
            }
        });
    }
}
