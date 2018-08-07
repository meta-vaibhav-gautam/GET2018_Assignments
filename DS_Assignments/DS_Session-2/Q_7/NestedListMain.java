package Q_7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * class containing main method
 */
public class NestedListMain {
	public static void main(String args[]) {
		Scanner scanner = new Scanner (System.in);
		List<Object> nestedList = new LinkedList<Object>();
		nestedList = NestedList.takeInput(nestedList);
		NestedList obj = new NestedList(nestedList);
		System.out.println(obj.getValue("TH",nestedList));
	}
	
}
