

import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseDBManagerTest_STUDENT {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204",41790,4,"SC410","Jimmy Jones");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC204",41790,4,"SC410","Jimmy Jones");
		dataMgr.add("CMSC203",17381,4,"SC780","I dont know");
		dataMgr.add("CMSC204",71237,4,"SC250","Allan");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:71237 Credits:4 Instructor:Allan Room:SC250");
		assertEquals(list.get(1),"\nCourse:CMSC203 CRN:17381 Credits:4 Instructor:I dont know Room:SC780");
		assertEquals(list.get(2),"\nCourse:CMSC204 CRN:41790 Credits:4 Instructor:Jimmy Jones Room:SC410");
		
	 	
		
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 98290 4 SC780 Jimmy Jones");
			inFile.print("CMSC204 41790 2 SC410 Allan");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC203",dataMgr.get(98290).getID());
			assertEquals("CMSC204",dataMgr.get(41790).getID());
			assertEquals("SC410",dataMgr.get(41790).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
