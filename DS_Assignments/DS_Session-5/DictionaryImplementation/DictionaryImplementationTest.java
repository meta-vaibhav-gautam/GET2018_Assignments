package DictionaryImplementation;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * class containing test methods 
 * created on August 09, 2018
 */
public class DictionaryImplementationTest {

	
	DictionaryImplementation object = new DictionaryImplementation("D:\\eclipse\\Metacube\\DS_Session-5\\src\\DictionaryImplementation\\inputData.json");
	
	/**
	 * method to test addKeyValuePairToDictionary method success scenario
	 */
	@Test
	public void testaAddKeyValuePairToDictionary_Success() {
		Node node = object.addKeyValuePairToDictionary("Hello","Greetings");
		
		assertEquals(true,(node!=null));
	}

	/**
	 * method to test addKeyValuePairToDictionary method failure scenario
	 */
	@Test
	public void testaAddKeyValuePairToDictionary_Failure() {
		Node node = object.addKeyValuePairToDictionary(null, null);
		
		assertNotEquals(true,(node!=null));
	}
	
	/**
	 * method to test deleteKeyValuePairToDictionary method success scenario
	 */
	@Test
	public void testDeleteKeyValuePairToDictionary_Success() {
		object.addKeyValuePairToDictionary("wasp", "value");
		Node node = object.deleteKeyValuePairFromDictionary("wasp",object.getRoot());
		
		assertEquals(true,(node==null));
	}
	
	/**
	 * method to test deleteKeyValuePairToDictionary method failure scenario
	 */
	@Test
	public void testDeleteKeyValuePairToDictionary_Failure() {
		Node node = object.deleteKeyValuePairFromDictionary("abcd",object.getRoot());
		
		assertNotEquals(true,(node!=null));
	}

	/**
	 * method to test getValue method success scenario
	 */
	@Test
	public void testGetValue_Success() {
		object.addKeyValuePairToDictionary("electrocute", "to kill using electric shock");
		String value = object.getValue("electrocute",object.getRoot());
		String expected ="to kill using electric shock";
		
		assertEquals(expected,value);
	}
	
	/**
	 * method to test getValue method failure scenario
	 */
	@Test
	public void testGetValue_Failure() {
		String value = object.getValue("abcd",object.getRoot());
		
		assertEquals(null,value);
	}
	
}
