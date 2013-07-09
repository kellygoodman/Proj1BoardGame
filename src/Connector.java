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
		char[] connectorChars = s.trim().toCharArray();
		
		if (connectorChars.length != 2) {
			if (Board.iAmDebugging) {
				System.out.println("Throwing exception: number of digits not equal to 2");
			}
			throw new IllegalFormatException();
		}
		int p1 = Character.getNumericValue(connectorChars[0]);
		int p2 = Character.getNumericValue(connectorChars[1]);
		
		if (Board.iAmDebugging) {
			System.out.println("p1 = "+ p1);
			System.out.println("p2 = "+ p2);
		}
		returnConnector = new Connector(p1, p2);
		
		if (returnConnector.isOK()) {
			if (Board.iAmDebugging) {
				System.out.println("Connector is ok");
			}
			return returnConnector;
		} else {
			if (Board.iAmDebugging) {
				System.out.println("Throwing exception: Connector is NOT ok");
			}
			throw new IllegalFormatException();
		}
	}
}
