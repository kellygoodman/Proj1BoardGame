import java.awt.Color;
import java.util.*;

public class Board {

	public static boolean iAmDebugging = true;
	private int myPoint1, myPoint2;
	
	// Initialize an empty board with no colored edges.
	public Board ( ) {
		// You fill this in.
	}
	
	// Add the given connector with the given color to the board.
	// Unchecked precondition: the given connector is not already chosen 
	// as RED or BLUE.
	public void add (Connector cnctr, Color c) {
		// You fill this in.
	}
	
	// Set up an iterator through the connectors of the given color, 
	// which is either RED, BLUE, or WHITE. 
	// If the color is WHITE, iterate through the uncolored connectors.
	// No connector should appear twice in the iteration.  
	public Iterator<Connector> connectors (Color c) {
		// You fill this in.
		return null;
	}
	
	// Set up an iterator through all the 15 connectors.
	// No connector should appear twice in the iteration.  
	public Iterator<Connector> connectors ( ) {
		// You fill this in.
		return null;
	}
	
	// Return the color of the given connector.
	// If the connector is colored, its color will be RED or BLUE;
	// otherwise, its color is WHITE.
	public Color colorOf (Connector e) {
		// You fill this in.
		return Color.WHITE;
	}
	
	// Unchecked prerequisite: cnctr is an initialized uncolored connector.
	// Let its endpoints be p1 and p2.
	// Return true exactly when there is a point p3 such that p1 is adjacent
	// to p3 and p2 is adjacent to p3 and those connectors have color c.
	public boolean formsTriangle (Connector cnctr, Color c) {
		// You fill this in.
		return false;
	}
	
	// The computer (playing BLUE) wants a move to make.
	// The board is assumed to contain an uncolored connector, with no 
	// monochromatic triangles.
	// There must be an uncolored connector, since if all 15 connectors are colored,
	// there must be a monochromatic triangle.
	// Pick the first uncolored connector that doesn't form a BLUE triangle.
	// If each uncolored connector, colored BLUE, would form a BLUE triangle,
	// return any uncolored connector.
	public Connector choice ( ) {
		// You fill this in.
		return null;
	}

	// Return true if the instance variables have correct and internally
	// consistent values.  Return false otherwise.
	// Unchecked prerequisites:
	//	Each connector in the board is properly initialized so that 
	// 	1 <= myPoint1 < myPoint2 <= 6.
	public boolean isOK ( ) {
		if ((myPoint1 >= 1) && (myPoint1<=6)) {
			if ((myPoint2>=2) && (myPoint2<=6)) {
				if (myPoint1<myPoint2) {
					return true;
				} else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		return true;
	}
}
