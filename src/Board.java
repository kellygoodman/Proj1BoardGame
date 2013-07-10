import java.awt.Color;
import java.util.*;

public class Board {

	public static boolean iAmDebugging = true;
	private int myPoint1, myPoint2; //take this out when we're done with isOK
	private ArrayList<Connector> redConnectors;
	private ArrayList<Connector> bluConnectors;
	private ArrayList<Connector> whtConnectors;
	
	// Initialize an empty board with no colored edges.
	public Board ( ) {
		redConnectors = new ArrayList<Connector>();
		bluConnectors = new ArrayList<Connector>();
		whtConnectors = new ArrayList<Connector>();
		for (int p1 = 1 ; p1<6 ; p1++) { //add all possible connectors
			for (int p2 = (p1+1); p2<=6 ; p2++) {
				whtConnectors.add(new Connector(p1,p2));
			}
		}
	}

	// Add the given connector with the given color to the board.
	// Unchecked precondition: the given connector is not already chosen 
	// as RED or BLUE.
	public void add (Connector cnctr, Color c) { //NOT FINISHED
		if (c.equals(Color.RED)) {
			redConnectors.add(cnctr);
			whtConnectors.remove(cnctr);
		} else if (c.equals(Color.BLUE)) {
			bluConnectors.add(cnctr);
			whtConnectors.remove(cnctr);
		} else if (c.equals(Color.WHITE)) {		// used only for debugging
			whtConnectors.add(cnctr);
		}
	}

	// Set up an iterator through the connectors of the given color, 
	// which is either RED, BLUE, or WHITE. 
	// If the color is WHITE, iterate through the uncolored connectors.
	// No connector should appear twice in the iteration.  
	public Iterator<Connector> connectors (Color c) {	// NOT FINISHED
		if (c.equals(Color.RED)) {
			return redConnectors.iterator();
		} else if (c.equals(Color.BLUE)) {
			return bluConnectors.iterator();
		} else if (c.equals(Color.WHITE)) {
			return whtConnectors.iterator();
		}
		return null;
	}

	// Set up an iterator through all the 15 connectors.
	// No connector should appear twice in the iteration.  
	public Iterator<Connector> connectors ( ) {
		ArrayList<Connector> total = new ArrayList<Connector>();
		for (int p1 = 1 ; p1<6 ; p1++) { //add all possible connectors
			for (int p2 = (p1+1); p2<=6 ; p2++) {
				total.add(new Connector(p1,p2));
			}
		}
		return total.iterator();
	}

	// Return the color of the given connector.
	// If the connector is colored, its color will be RED or BLUE;
	// otherwise, its color is WHITE.
	public Color colorOf (Connector e) {
		if (redConnectors.contains(e)) {		// checks each arraylist (assumes Board.isOK returns true, i.e. connector cannot be in multiple arraylists)
			return  Color.RED;
		} else if (bluConnectors.contains(e)) {
			return Color.BLUE;
		}
		return Color.WHITE;
	}

	// Unchecked prerequisite: cnctr is an initialized uncolored connector.
	// Let its endpoints be p1 and p2.
	// Return true exactly when there is a point p3 such that p1 is adjacent
	// to p3 and p2 is adjacent to p3 and those connectors have color c.
	public boolean formsTriangle (Connector cnctr, Color c) {
		int p1 = cnctr.endPt1();
		int p2 = cnctr.endPt2();
		ArrayList<Integer> p3 = new ArrayList<Integer>();
		Iterator<Connector> iterator = connectors(c);
		Connector next;
		while (iterator.hasNext()) {
			next = iterator.next();
			if (next.endPt1() == p1) {
				p3.add(next.endPt2());
			} else if (next.endPt2() == p1) {
				p3.add(next.endPt1());
			}
		}
		iterator = connectors(c);
		while (iterator.hasNext()) {
			next = iterator.next();
			if (next.endPt1() == p2) {
				if (p3.contains(next.endPt2())) {
					return true;
				}
			} else if (next.endPt2() == p2) {
				if (p3.contains(next.endPt1())) {
					return true;
				}
			}
		}
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
	public boolean isOK ( ) { //currently incorrect since we need to decide on storage for connectors
		boolean returnVal=false;
		if (myPoint1 != myPoint2) { 					//checks Point1 != Point 2
			if ((myPoint1 >= 1) && (myPoint1<=6)) { 	//checks Point1 is in correct bounds
				if ((myPoint2>=2) && (myPoint2<=6)) { 	//checks Point 2 is in correct bounds
					if (myPoint1<myPoint2) { 			//checks Point 1 < Point 2
						returnVal = true;
					} 
				}
			}
		}
		return returnVal;
		// NEEDS TO HAVE:
		// check that no connector values repeat (within arrays, or between arrays)
		// check that sum of array list lengths is 15
		// if after blue turn: check redConnectors.size() == bluConnectors.size()
		// if after red turn: check redConnectors.size() == bluConnectors.size() + 1
		// check that there are no triangles
	}
}
