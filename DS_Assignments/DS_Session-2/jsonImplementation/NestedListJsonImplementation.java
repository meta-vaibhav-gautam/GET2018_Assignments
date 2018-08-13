package jsonImplementation;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * class containing implementaion of nested list operations
 * created on August 04, 2018
 */
public class NestedListJsonImplementation implements NestedList {
	private List<List<Long>> nestedList = new ArrayList<List<Long>>();
	private JSONArray dataJsonArray ;
	private String jsonFilePath = "";
	
	public NestedListJsonImplementation(String jsonFilePath) {
		this.jsonFilePath = jsonFilePath;
		readData();
	}
	
	/*
	 * method reads data from a json file
	 */
	private void readData() {
		JSONParser jsonParser = new JSONParser();
		try {
			Object obj = jsonParser.parse(new FileReader(jsonFilePath));
			JSONObject jsonObject = (JSONObject) obj;
			nestedList = (List)jsonObject.get("list");
			System.out.println(nestedList);
		} catch (Exception exception) {
			System.out.println("Some exception ocurred !");
		}
	}
	
	/*
	 * method to calculate sum of all the integers in the nested lists
	 * @return sum of the integers
	 */
	@Override
	public long getSumOfAllIntegers(List<List<Long>> listOfValues) {
		long totalOfInteger = 0;
		for(int index=0 ; index<listOfValues.size() ; index++) {
			Object element = listOfValues.get(index);
			if(element instanceof Long) {
				totalOfInteger += (long)element;
			} else {
				totalOfInteger += getSumOfAllIntegers((List)listOfValues.get(index));
			}
		}
		
		return totalOfInteger;
	}

	/*
	 * method to find largest value from the list
	 * @return the largest value from the list
	 */
	@Override
	public long getLargestValueFromNestedList(List<List<Long>> nestedList) {
		long maxValue=0;
		for (Object value : nestedList) {
			if(value instanceof Long) {
				if(maxValue < (long)value) {
					maxValue = (long)value;
				} 
			  } else {
					maxValue = getLargestValueFromNestedList((List)value);
			}
		}
		
		return maxValue;
	}

	/*
	 * method finds the value in the list
	 * @return index of the value found
	 */
	@Override
	public boolean searchValue(long element, List<List<Long>> nestedList) {
		boolean flag=false;
		try {
			for (Object value : nestedList) {
				if(value instanceof Long) {
					if(element == (long)value) {
						flag = true;
						break;
					} 
				  } else {
					if(!flag){
						flag = searchValue(element, (List)value);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Some error ocurred !");
		}
		return flag;
	}
	
	//method to get the list
	public List<List<Long>> getNestedList() {
		return nestedList;
	}
	
}
