package DictionaryImplementation;

import java.util.List;

/**
 * interface containing methods for operation on dictionary
 * created on Ausust 09, 2018
 */
public interface Dictionary {
	
	public Node addKeyValuePairToDictionary (String key, String value);
	public Node deleteKeyValuePairFromDictionary(String key,Node root) ;
	public String getValue(String key,Node root);
	public List<Pair> getSortedListOfKeys();
	public List<Pair> getSortedListOfKeysInRange(String k1, String k2);
	
}
