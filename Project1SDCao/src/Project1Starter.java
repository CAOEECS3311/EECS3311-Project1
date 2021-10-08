import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
	
	// These are the two buttons on JFrame
	private JButton loadShapes = new JButton("Load Shapes");
    private JButton sortShapes = new JButton("Sort Shapes");
    private RectsPanel panel = new RectsPanel();    // panel container for this project
    private JFrame frame = new JFrame("Display shapes");		// Frame window for storing the six different shapes
    
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
            	allMixed.clear();
            	ShapeFactory shapeFactory = new ShapeFactory();			// creating object of ShapeFactory for calling fillShape()
            	shapeFactory.fillShape(allMixed);		// This method will instantiate all the six different shapes
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
	public class RectsPanel extends JPanel {
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
