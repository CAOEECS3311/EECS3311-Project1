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
    			int cI = tempI.chance;
    			int cJ = tempJ.chance;
    			// if the current ith and current jth shape needs to be swapped based on their surfaces
    			if(areaI>areaJ) {
    				int xIPos, xJPos, yIPos, yJPos;
    				
    				// These three X three (if..else if) cases (Line number 25 to 63) will swap the x and y positions of the current ith and jth shape 
    				if(cI==1) {
        				xIPos = tempI.circle.getUpperX();
            			yIPos = tempI.circle.getUpperY();
    				} else if(cI == 2) {
    					xIPos = tempI.rectangle.getUpperX();
            			yIPos = tempI.rectangle.getUpperY();
    				} else {
    					xIPos = tempI.square.getUpperX();
            			yIPos = tempI.square.getUpperY();
    				}
    				
    				if(cJ==1) {
        				xJPos = tempJ.circle.getUpperX();
            			yJPos = tempJ.circle.getUpperY();
        				tempJ.circle.setUpperX(xIPos);
            			tempJ.circle.setUpperY(yIPos);
    				} else if(cJ == 2) {
    					xJPos = tempJ.rectangle.getUpperX();
            			yJPos = tempJ.rectangle.getUpperY();
    					tempJ.rectangle.setUpperX(xIPos);
            			tempJ.rectangle.setUpperY(yIPos);
    				} else {
    					xJPos = tempJ.square.getUpperX();
            			yJPos = tempJ.square.getUpperY();
            			tempJ.square.setUpperX(xIPos);
            			tempJ.square.setUpperY(yIPos);
    				}
    				
    				if(cI==1) {
        				tempI.circle.setUpperX(xJPos);
            			tempI.circle.setUpperY(yJPos);
    				} else if(cI == 2) {
    					tempI.rectangle.setUpperX(xJPos);
            			tempI.rectangle.setUpperY(yJPos);
    				} else {
    					tempI.square.setUpperX(xJPos);
            			tempI.square.setUpperY(yJPos);
    				}
    				
    				// swapping both current ith and jth shape so that sorting could move ahead
    				allMixed.set(i, tempJ);
    				allMixed.set(j, tempI);
    			}
    		}
    	} 
	}
}
