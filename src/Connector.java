public class Connector {
	
	// Implement an immutable connector that connects two points on the game board.
	// Invariant: 1 <= myPoint1 < myPoint2 <= 6.
	
	private int myPoint1, myPoint2;
	
	public Connector (int p1, int p2) {
		if (p1 < p2) {
			myPoint1 = p1;
			myPoint2 = p2;
		} else {
			myPoint1 = p2;
			myPoint2 = p1;
		}
	}
	
	public int endPt1 ( ) {
		return myPoint1;
	}
	
	public int endPt2 ( ) {
		return myPoint2;
	}
	
	public boolean equals (Object obj) {
		Connector e = (Connector) obj;
		return (e.myPoint1 == myPoint1 && e.myPoint2 == myPoint2);
	}
	
	public String toString ( ) {
		return "" + myPoint1 + myPoint2;
	}
	
	private boolean isOK ( ) { //added isOK check to make connectorTest work 
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
	}
	
	// Format of a connector is endPoint1 + endPoint2 (+ means string concatenation),
	// possibly surrounded by white space. Each endpoint is a digit between
	// 1 and 6, inclusive; moreover, the endpoints aren't identical.
	// If the contents of the given string is correctly formatted,
	// return the corresponding connector.  Otherwise, throw IllegalFormatException.
	public static Connector toConnector (String s) throws IllegalFormatException {
		Connector returnConnector=null;
		//checks for correct length
		char[] connectorChars = s.toCharArray();
		for (int i = 0 ; i<connectorChars.length ;) {
			if (Character.isWhitespace(connectorChars[i])) {
				i++; //initial white space - just move to next character
			} else if (Character.isDigit(connectorChars[i]) && Character.isDigit(connectorChars[i+1])) {
				for (int k = i+2 ; k<connectorChars.length ; k++) { //check remaining chars
					if (!(Character.isWhitespace(connectorChars[k]))) {
						throw new IllegalFormatException(); //if they're not white space, throw an exception
					}
				}
				int p1 = connectorChars[i]; //Successfully checked all remaining spaces, time to make connector
				int p2 = connectorChars[i+1];
				returnConnector = new Connector(p1, p2);
			} else {
				throw new IllegalFormatException(); //hit something that is neither white space nor digits
			}
		}
		if (returnConnector.isOK()) {
			return returnConnector;
		} else {
			return null;
		}
	}
}
