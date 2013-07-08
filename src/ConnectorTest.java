import static org.junit.Assert.*;

import org.junit.Test;


public class ConnectorTest {

	@Test
	public void testConnector() {
		Connector c1 = new Connector(3,4);
		assertTrue(c1.endPt1() == 3);
		assertTrue(c1.endPt2() == 4);
		assertTrue(c1.toString().equals("34"));		// checks if constructor works when p1 < p2
		Connector c2 = new Connector(4,3);
		assertTrue(c1.equals(c2));					// checks if constructor works when p1 > p2
	}

	@Test
	public void testToConnector() {
		// test toConnector() with valid user inputs
		Connector c1 = new Connector(3,4);
		Connector c2 = new Connector(6,1);
		boolean thrown = false;
		Connector c3 = null;
		
		try {
			c3 = Connector.toConnector("34");		// p1 < p2		
		} catch (IllegalFormatException e) {
			thrown = true;
		}
		assertFalse(thrown);
		assertTrue(c1.equals(c3));	
		
		try {
			c3 = Connector.toConnector("43");		// p1 > p2
		} catch (IllegalFormatException e) {
			thrown = true;
		}
		assertFalse(thrown);
		assertTrue(c1.equals(c3));
		
		try {
			c3 = Connector.toConnector(" 43");		// whitespace before digits
		} catch (IllegalFormatException e) {
			thrown = true;
		}
		assertFalse(thrown);
		assertTrue(c1.equals(c3));
		
		try {
			c3 = Connector.toConnector("61");		// digits at the boundary values
		} catch (IllegalFormatException e) {
			thrown = true;
		}
		assertFalse(thrown);
		assertTrue(c2.equals(c3));
		
		try {
			c3 = Connector.toConnector("16 ");		// whitespace after digits
		} catch (IllegalFormatException e) {
			thrown = true;
		}
		assertFalse(thrown);
		assertTrue(c2.equals(c3));
		
		try {
			c3 = Connector.toConnector("   61   ");	// whitespace before and after digits
		} catch (IllegalFormatException e) {
			thrown = true;
		}
		assertFalse(thrown);
		assertTrue(c2.equals(c3));
		
		
		// test toConnector() with invalid user inputs
		thrown = false;
		Connector c4 = null;
		try {
			c4 = Connector.toConnector("33");	// input with repeated digits
		} catch (IllegalFormatException e) {
		    thrown = true;
		}
		assertTrue(thrown);
		assertTrue(c4 == null);
		
		thrown = false;
		try {
			Connector.toConnector("01");		// input with first digit outside of bounds
		} catch (IllegalFormatException e) {
		    thrown = true;
		}
		assertTrue(thrown);
		
		thrown = false;
		try {
			Connector.toConnector("47");		// input with second digit outside of bounds
		} catch (IllegalFormatException e) {
		    thrown = true;
		}
		assertTrue(thrown);
		
		thrown = false;
		try {
			Connector.toConnector("5");			// input with only one digit
		} catch (IllegalFormatException e) {
		    thrown = true;
		}
		assertTrue(thrown);

		thrown = false;
		try {
			Connector.toConnector("222");		// input with more than 3 digits
		} catch (IllegalFormatException e) {
		    thrown = true;
		}
		assertTrue(thrown);
		
		thrown = false;
		try {
			Connector.toConnector("");			// input with empty string
		} catch (IllegalFormatException e) {
		    thrown = true;
		}
		assertTrue(thrown);
		
		thrown = false;
		try {
			Connector.toConnector("    ");		// input with only whitespace
		} catch (IllegalFormatException e) {
		    thrown = true;
		}
		assertTrue(thrown);
		
		thrown = false;
		try {
			Connector.toConnector("--17");		// input with non-integer characters
		} catch (IllegalFormatException e) {
		    thrown = true;
		}
		assertTrue(thrown);
		
		thrown = false;
		try {
			Connector.toConnector("1 2");		// input with whitespace between digits
		} catch (IllegalFormatException e) {
		    thrown = true;
		}
		assertTrue(thrown);	
	}
	
}
