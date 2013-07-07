//import static org.junit.Assert.*;

//import org.junit.Test;
import junit.framework.TestCase;

public class ConnectorTest extends TestCase{

//	@Test
	public void testConnector() {
		Connector c1 = new Connector(3,4);
		assertTrue(c1.endPt1() == 3);
		assertTrue(c1.endPt2() == 4);
		assertTrue(c1.toString().equals("34"));
		Connector c2 = new Connector(4,3);
		assertTrue(c1.equals(c2));
	}

//	@Test
	public void testToConnector() {
		// test toConnector() with valid user inputs
		Connector c1 = new Connector(3,4);
		Connector c2 = new Connector(6,1);
		
		Connector c3 = Connector.toConnector("34");
		assertTrue(c1.equals(c3));
		Connector c4 = Connector.toConnector("43");
		assertTrue(c1.equals(c4));
		Connector c5 = Connector.toConnector(" 43");
		assertTrue(c1.equals(c5));
		Connector c6 = Connector.toConnector("61");
		assertTrue(c1.equals(c6));
		Connector c7 = Connector.toConnector("16 ");
		assertTrue(c2.equals(c7));
		Connector c8 = Connector.toConnector("   61  ");
		assertTrue(c2.equals(c8));
		
		
		// test toConnector() with invalid user inputs
		boolean thrown = false;
		try {
			Connector.toConnector("33");
		} catch (IllegalFormatException e) {
		    thrown = true;
		}
		assertTrue(thrown);
		
		Connector c9 = Connector.toConnector("33");		
		assertTrue(c9.equals(null));	
		Connector c10 = Connector.toConnector("01");
		assertTrue(c10.equals(null));
		Connector c11 = Connector.toConnector("47");
		assertTrue(c11.equals(null));
		Connector c12 = Connector.toConnector("5");
		assertTrue(c12.equals(null));
		Connector c13 = Connector.toConnector("222");
		assertTrue(c13.equals(null));
		Connector c14 = Connector.toConnector("");
		assertTrue(c14.equals(null));
		Connector c15 = Connector.toConnector("   ");
		assertTrue(c15.equals(null));
		Connector c16 = Connector.toConnector("-- ");
		assertTrue(c16.equals(null));
		
	}
	
}
