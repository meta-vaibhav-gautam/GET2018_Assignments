package jsonImplementation;

import java.util.List;

/*
 * interface containing operations on nested list
 * created on August 4, 2018
 */
public interface NestedList {
	
	public long getSumOfAllIntegers(List<List<Long>> listOfValues);
	public long getLargestValueFromNestedList(List<List<Long>> nestedList);
	public boolean searchValue(long value, List<List<Long>> nestedList);
	
}
