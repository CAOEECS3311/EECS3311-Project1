import java.util.List;

/**
 * This class will sort all six different shapes based on their surfaces
 * @author Yixing Cao
 */
public class SortingTechnique {
	// This is the method which will sort all six different shapes based on their surfaces
	// This method implements bubble sort on the given list of different shapes
	protected void sortShapes(List<AllMixedShapes> allMixed) {
		int lenMixed = allMixed.size();			// getting the length of list which is obviously 6
		// performing bubble sort on the list
    	for(int i=0;i<lenMixed;i++) {		// iterating for all the shapes in the list
    		for(int j=i+1;j<lenMixed;j++) {
    			AllMixedShapes tempI = allMixed.get(i);
    			AllMixedShapes tempJ = allMixed.get(j);
    			double areaI = tempI.area;
    			double areaJ = tempJ.area;
    			// if the current ith and current jth shape needs to be swapped based on their surfaces
    			if(areaI>areaJ) {
    				
    				// line number 23 to 33 will swap x and y positions of the current ith and jth shape
    				int iUpperX = tempI.shapeType.getUpperX();
    				int iUpperY = tempI.shapeType.getUpperY();
    				
    				int jUpperX = tempJ.shapeType.getUpperX();
    				int jUpperY = tempJ.shapeType.getUpperY();
    				
    				tempJ.shapeType.setUpperX(iUpperX);
        			tempJ.shapeType.setUpperY(iUpperY);
        			
        			tempI.shapeType.setUpperX(jUpperX);
        			tempI.shapeType.setUpperY(jUpperY);
    				
    				// swapping both current ith and jth shape so that sorting could move ahead
    				allMixed.set(i, tempJ);
    				allMixed.set(j, tempI);
    			}
    		}
    	} 
	}
}
