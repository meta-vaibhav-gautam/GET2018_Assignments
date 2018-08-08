package uniqueCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * class containing method to count unique character in string and cache them
 * created on August 08, 2018
 */
public class UniqueCharacter {
	
	private Map<String, Integer> cacheMap = new HashMap<String, Integer>();
	
	/**
	 * method finds the number of unique characters in the string
	 * @param inputString as String
	 * @return count of unique character
	 */
	public int countUniqueCharacter(String inputString) {
		Integer valueFromCache=null;
		Set<Character> characterSet = new HashSet<Character>();
		int count = 0;
		boolean isDuplicate=false;
		try {
			valueFromCache = cacheMap.get(inputString);
			if(valueFromCache==null) {
				for(int i=0;i<inputString.length();i++) {
					if(! characterSet.add(inputString.charAt(i))){
						characterSet.remove(inputString.charAt(i));
					}
				}
				count = characterSet.size();
			} else {
				System.out.println("(From cached strings !)");
				return valueFromCache;
			} 
		} catch (Exception e) {
			System.out.println("Some exception occurred !");
		}
		cacheMap.put(inputString, count);
		return count;
	}
}
