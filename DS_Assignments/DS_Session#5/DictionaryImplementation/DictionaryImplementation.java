package DictionaryImplementation;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * class containing implementation of methods of Dictionary interface
 * created on August 09, 2018
 */
public class DictionaryImplementation implements Dictionary {

	private Node root = null;
	private String jsonFilePath = "";
	List<String> inorderListOfKeys = new ArrayList<String>();
	List<Pair> listOfValuesInBST = new ArrayList<Pair>();
	
	public DictionaryImplementation (String jsonFilePath) {
		this.jsonFilePath = jsonFilePath;
		insertJsonDataIntoDictionary();
	}
	
	/**
	 * method initializing dictionary with json data
	 */
	private void insertJsonDataIntoDictionary() {
		JSONParser jsonParser = new JSONParser();
		List<String> listOfKeys = new ArrayList<String>();
		List<String> listOfValues = new ArrayList<String>();

		try {
			Object obj = jsonParser.parse(new FileReader(jsonFilePath));
			JSONObject jsonObject = (JSONObject) obj;
			listOfKeys = (List)jsonObject.get("keys");
			listOfValues = (List)jsonObject.get("values");
			for(int indexOfList=0 ; indexOfList<listOfKeys.size() ; indexOfList++){
				addKeyValuePairToDictionary(listOfKeys.get(indexOfList),listOfValues.get(indexOfList));
			}
			printTree(root);
		} catch (Exception e) {
			System.out.println("Some Exception occurred !");
		}
	}
	
	/**
	 * method adds value to BST with help of createNode and addToTree methods
	 * @param String value as key
	 * @param String value as value
	 * @return node added
	 */
	@Override
	public Node addKeyValuePairToDictionary(String key, String value) {
		try {
			Node node = createNode(key,value);
			listOfValuesInBST.add(new Pair(key,value));
			if(root==null) {
				root=node;
				return root;
			}
			return (addToTree(node,root));
		} catch (Exception e) {
			System.out.println("Exception Occurred !");
		}
		return null;
	}

	@Override
	public Node deleteKeyValuePairFromDictionary(String key, Node node) {
		try {
			if(node==null) {
				return node;
			} 
			
			//traversing the BST
			if ((key.compareTo(node.getValue().getKey()) > 0 )) {
				node.setRightChild(deleteKeyValuePairFromDictionary(key, node.getRightChild())); 
			} else if((key.compareTo(node.getValue().getKey()) < 0 )) {
				node.setLeftChild(deleteKeyValuePairFromDictionary(key, node.getLeftChild()));
			} else {
				
				//deleting node having single child
				if(node.getLeftChild()==null) {
					return node.getRightChild();
				} else if(node.getRightChild()==null) {
					return node.getLeftChild();
				} 
				
				//means node having two child and we want it to be deleted
				node.setValuePair(getMinValue(node.getRightChild())); //getting minimum value from rightside as it will be suitable for maintaining tree
				node.setRightChild(deleteKeyValuePairFromDictionary(key, node.getRightChild()));
			}
		} catch (Exception e) {
			System.out.println("Exception occurred !");
		}
		return node;
	}

	/**
	 * method to get corresponding value of the key from tree
	 * @return value as string
	 */
	@Override
	public String getValue(String key,Node node) {
		try {
			if(node.getValue().getKey().equals(key)) {
				return node.getValue().getValue();
			} else {
				if(key.compareTo(node.getValue().getKey()) >0 ) {
					return getValue(key,node.getRightChild());
				} else {
					return getValue(key,node.getLeftChild());
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred !");
			return null;
		}
	}

	/**
	 * method sorts the key value pair of the BST
	 * @return sorted list of key values
	 */
	@Override
	public List<Pair> getSortedListOfKeys() {	
		for(int i=0;i<listOfValuesInBST.size();i++) {
			for(int j=0; j<(listOfValuesInBST.size()-1)-i;j++) {
				if(listOfValuesInBST.get(j).getKey().compareTo(listOfValuesInBST.get(j+1).getKey()) > 0) {
					Pair tempObject1 = listOfValuesInBST.get(j);
					Pair tempObject2 = listOfValuesInBST.get(j+1);
					listOfValuesInBST.remove(j);
					listOfValuesInBST.add(j, tempObject2);
					listOfValuesInBST.remove(j+1);
					listOfValuesInBST.add((j+1),tempObject1);
				}
			}
		}
		return listOfValuesInBST;
	}
	

	@Override
	public List<Pair> getSortedListOfKeysInRange(String k1, String k2) {
		List<Pair> sortedList = new ArrayList<Pair>();
		for (Pair value : listOfValuesInBST) {
			if((value.getKey().compareTo(k1)>=0) && (value.getKey().compareTo(k2)<=0)) {
				sortedList.add(value);
			}
		}
		for(int i=0;i<sortedList.size();i++) {
			for(int j=0; j<(sortedList.size()-1)-i;j++) {
				if(sortedList.get(j).getKey().compareTo(sortedList.get(j+1).getKey()) > 0) {
					Pair tempObject1 = sortedList.get(j);
					Pair tempObject2 = sortedList.get(j+1);
					sortedList.remove(j);
					sortedList.add(j, tempObject2);
					sortedList.remove(j+1);
					sortedList.add((j+1),tempObject1);
				}
			}
		}
		return sortedList;
	}
	
	/**
	 * method create new Node with pair values
	 * @param String key value pair
	 * @return node created
	 */
	private Node createNode(String key, String value) {
		Node node = null;
		Pair valuePair = null;
		try {
			if(key == null || value == null) {
				System.out.println("Either the key or value is null !");
				return null;
			} else {
				valuePair = new Pair(key,value);
				node = new Node (valuePair, null, null);
			}
		} catch (Exception e) {
			System.out.println("Exception Occurred !");
		}
		return node;
	}
	
	/**
	 * method adds newly created node its appropriate position in BST
	 * @param node value to be added
	 * @param node at which we have to add
	 * @return node added
	 */
	private Node addToTree(Node nodeToBeAdded, Node node) {
		try {
			if(node == null) {
				node = nodeToBeAdded;
			} else {
				if(nodeToBeAdded.compareTo(node) >= 0) {
					//if value is greater than current node
					node.setRightChild(addToTree(nodeToBeAdded,node.getRightChild())); 
				} else {
					//if value is less than current node
					node.setLeftChild(addToTree(nodeToBeAdded,node.getLeftChild())); 
				}
			}
		} catch (Exception e) {
			System.out.println("Exception Occurred !");
		}
		
		return node;
	}
	
	private Pair getMinValue(Node root) {
		Pair minValue= null;
		while(root.getLeftChild()!=null) {
			minValue=root.getLeftChild().getValue();
			root = root.getLeftChild();
		}
		return minValue;
	}
	
	/**
	 * method create list of inorder traversal nodes
	 */
	private void getInorderListOfKeys(Node root) {
		if(root==null) {
			return;
		} else {
			printTree(root.getLeftChild());
			inorderListOfKeys.add(root.getValue().getKey());
			printTree(root.getRightChild());
		}
	}
	
	/**
	 * print inorderTraversal of tree
	 */
	public void printTree(Node root) {
		if(root==null) {
			return;
		} else {
			printTree(root.getLeftChild());
			System.out.print(root.getValue().getKey()+", ");
			printTree(root.getRightChild());
		}
	}

	public void printListOfValuesInBST(Pair pair) {
		if(pair!=null) {
			System.out.println(pair.getKey()+"---> "+pair.getValue());
			System.out.println();
		} else {
			return;
		}
	}
	
	/**
	 * @ root of the BST
	 */
	public Node getRoot() {
		return root;
	}
	
	
}
