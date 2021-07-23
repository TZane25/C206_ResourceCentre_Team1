import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;

	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;

	public ResourceCentreTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}


	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());

		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));

		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}

	@Test
	public void testAddChromebook() {
		//fail("Not yet implemented");
		// write your code here

		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);

		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addChromebook(chromebookList, cb1);		
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());

		//The item just added is as same as the first item of the list
		assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));

		//Add another item. test The size of the list is 2?
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
	}

	@Test
	public void testRetrieveAllCamcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

		//test if the list of camcorders retrieved from the SourceCentre is empty
		String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());

		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);

		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
	}

	@Test
	public void testRetrieveAllChromebook() {
		//fail("Not yet implemented");
		// write your code here
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid chromebook arraylist to add to", chromebookList);

		// Test if the list of chromebook retrieved from the SourceCentre is empty
		String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = "";
		assertEquals("Check that ViewAllChromebookList", testOutput, allChromebook);

		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());

		//test if the expected output string same as the list of chromebook retrieved from the SourceCentre
		allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
		assertEquals("Check that ViewAllChromebookList", testOutput, allChromebook);
	}

	@Test
	public void testDoLoanCamcorder() {
		//fail("Not yet implemented");
		// write your code here
		// Test if Item list is not null but empty, so that can loan an item
		assertNotNull("Test that the Item list is not null, so that they can loan an item. ", camcorderList);

		// Given the list which consists of 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);	
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());

		// Test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

		// Test that the ‘DUE DATE’ is recorded inside the list accordingly
		String due1 = camcorderList.get(0).getDueDate();
		String due2 = camcorderList.get(1).getDueDate();
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", due1 , 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", due2, 20);
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

		// Test that the availability is true, so that it is ava to be loan out.
//		Boolean ava1 = camcorderList.get(0).getIsAvailable();
//		assertTrue(ava1);
		
//		Boolean ava2 = camcorderList.get(1).getIsAvailable();
//		assertTrue(ava2);

//		// Test that the availability will change to “No”.
//		if (due1.isEmpty() == false) { // meaning if there is a duedate
//			assertFalse(ava1);  // then the availability should be false.
//		}
//		else if (due2.isEmpty() == false) {
//			assertFalse(ava2); 
//		}
		
		// TEST THE AVA OF ITEM
		assertTrue(cc1.getIsAvailable());
		assertTrue(cc2.getIsAvailable());
		
		// LOAN THE ITEM
		ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", due1);
		ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", due2);
		
		// CHECK IF IT IS FALSE AFTER LOAN
		assertFalse(cc1.getIsAvailable());
		assertFalse(cc2.getIsAvailable());
	}

	@Test
	public void testDoLoanChromebook() {
		//fail("Not yet implemented");
		// write your code here
		// Test if Item list is not null but empty, so that can loan an item
		assertNotNull("Test that the Item list is not null, so that they can loan an item. ", chromebookList);

		// Given the list which consists of 2 items, test if the size of the list is 2
		ResourceCentre.addChromebook(chromebookList, cb1);	
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, chromebookList.size());

		// Test if the expected output string same as the list of chromebook retrieved from the SourceCentre
		String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allChromebook);

		// Test that the ‘DUE DATE’ is recorded inside the list accordingly
		String due1 = chromebookList.get(0).getDueDate();
		String due2 = chromebookList.get(1).getDueDate();
		allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", due1, "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", due2, "Win 10");
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allChromebook);

		// Test that the availability is true, so that it is ava to be loan out.
//		Boolean ava1 = chromebookList.get(0).getIsAvailable();
//		assertTrue(ava1);
//		Boolean ava2 = chromebookList.get(1).getIsAvailable();
//		assertTrue(ava2);
//		// Test that the availability will change to “No”.
//		if (due1.isEmpty() == false) { // meaning if there is a duedate
//			assertFalse(ava1);  // then the availability should be false.
//		}
//		else if (due2.isEmpty() == false) {
//			assertFalse(ava2); 
//		}
		
		// TEST THE AVA OF ITEM
		assertTrue(cb1.getIsAvailable());
		assertTrue(cb2.getIsAvailable());
		
		// LOAN THE ITEM
		ResourceCentre.doLoanChromebook(chromebookList, "CB0011", due1);
		ResourceCentre.doLoanChromebook(chromebookList, "CB0012", due2);
		
		// CHECK IF IT IS FALSE AFTER LOAN
		assertFalse(cb1.getIsAvailable());
		assertFalse(cb2.getIsAvailable());
	}

	@Test
	public void testDoReturnCamcorder() {
		//fail("Not yet implemented");
		// write your code here
		// Test if Item list is not null but empty, so that can return a new item
		assertNotNull("Test that the Item list is not null, so that they can return an item. ", camcorderList);

		// Given the list which consists of 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);	
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());

		// Test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

		// Test that the ‘DUE DATE’ will be empty accordingly
		String due1 = camcorderList.get(0).getDueDate();
		String due2 = camcorderList.get(1).getDueDate();
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", due1 , 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", due2, 20);
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

		// Test that the availability is false, meaning it is still not returned.
//		Boolean ava1 = camcorderList.get(0).getIsAvailable();
////		assertFalse(ava1);
//		Boolean ava2 = camcorderList.get(1).getIsAvailable();
////		assertFalse(ava2);
//		// Test that the availability will change to “Yes”.
//		if (due1.isEmpty() == true) { // meaning if there is NO duedate
//			assertTrue(ava1);  // then the availability should be true, it is ava.
//		}
//		else if (due2.isEmpty() == true) {
//			assertTrue(ava2); 
//		}
		
		// TEST THE AVA OF ITEM
		// Test that there is a dueDate, the book is still on loan, before it can be returned.
		assertNotNull(cc1.getDueDate());
		assertNotNull(cc2.getDueDate());
		
		// RETURN THE ITEM
		ResourceCentre.doReturnCamcorder(camcorderList, due1);
		ResourceCentre.doReturnCamcorder(camcorderList, due2);
		
		// CHECK IF IT IS TRUE AFTER LOAN
		assertTrue(cc1.getIsAvailable());
		assertTrue(cc2.getIsAvailable());
	}

	@Test
	public void testDoReturnChromebook() {
		//fail("Not yet implemented");
		// write your code here
		// Test if Item list is not null but empty, so that can return a new item
		assertNotNull("Test that the Item list is not null, so that they can return an item. ", chromebookList);
		
		// Test that there is a dueDate, the book is still on loan, before it can be returned.
//		for (int i = 0; i < chromebookList.size(); i++) {
//			assertNotNull("Test that the Item list is not null, so that they can return an item. ", chromebookList.get(i).getDueDate()); 
//		}

		// Given the list which consists of 2 items, test if the size of the list is 2
		ResourceCentre.addChromebook(chromebookList, cb1);	
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, chromebookList.size());

		// Test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		String allCamcorder= ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
		assertEquals("Check that ViewAllChromebooklist", testOutput, allCamcorder);

		// Test that the ‘DUE DATE’ will be empty accordingly
		String due1 = chromebookList.get(0).getDueDate();
		String due2 = chromebookList.get(1).getDueDate();
		allCamcorder= ResourceCentre.retrieveAllChromebook(chromebookList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", due1, "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", due2 , "Win 10");
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

		// Test that the availability is false, meaning it is still not returned.
//		Boolean ava1 = chromebookList.get(0).getIsAvailable();
////		assertFalse(ava1);
//		Boolean ava2 = chromebookList.get(1).getIsAvailable();
////		assertFalse(ava2);
//		// Test that the availability will change to “Yes”.
//		if (due1.isEmpty() == true) { // meaning if there is NO duedate
//			assertTrue(ava1);  // then the availability should be true, it is ava.
//		}
//		else if (due2.isEmpty() == true) {
//			assertTrue(ava2); 
//		}
		
		// TEST THE AVA OF ITEM
		// Test that there is a dueDate, the book is still on loan, before it can be returned.
		assertNotNull(cb1.getDueDate());
		assertNotNull(cb2.getDueDate());
		
		// RETURN THE ITEM
		ResourceCentre.doReturnChromebook(chromebookList, due1);
		ResourceCentre.doReturnChromebook(chromebookList, due2);
		
		// CHECK IF IT IS TRUE AFTER LOAN
		assertTrue(cb1.getIsAvailable());
		assertTrue(cb2.getIsAvailable());
	}

	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
