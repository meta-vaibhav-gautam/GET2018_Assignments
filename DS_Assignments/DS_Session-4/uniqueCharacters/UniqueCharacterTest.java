package uniqueCharacters;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * junit test class to containing test methos
 * created on August 08, 2018
 */
public class UniqueCharacterTest {

	/**
	 * method to test countUniqueCharacter success scenario
	 */
	@Test
	public void testCountUniqueCharater_Success() {
		int result = new UniqueCharacter().countUniqueCharacter("Metacube");
		
		assertEquals(6, result);
	}

	/**
	 * method to test countUniqueCharacter failure scenario
	 */
	@Test
	public void testCountUniqueCharater_Failure() {
		int result = new UniqueCharacter().countUniqueCharacter("Metacube");
		
		assertNotEquals(7, result);
	}

}
