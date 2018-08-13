package stack;

import java.util.LinkedList;
import java.util.List;

/*
 * class containing  concrete implementation of stack using linked list
 * created on August 1, 2018
 */
public class StackUsingLinkedList implements Stack{

	private List<Integer> stackList=new LinkedList<Integer>();
	int top=-1;
	
	/*
	 * method to push elements in stack
	 * @param integer element
	 * @return 1 if successfully added to stack otherwise 0
	 */
	@Override
	public int pushElement(int element) {
		top++;
		stackList.add(element);
		return 1;
	}
	
	/*
	 * method used to delete element from stack
	 * @return 1 if deleted successfully otherwise return 0
	 */
	@Override
	public int popElement() {
		if(top==-1) {
			System.out.println("Stack underflowed !");
			return 0;
		}
		stackList.remove(top);
		top--;
		return 1;
	}
	
	/*
	 * method to see the top element of the stack
	 * return 0 if stack is empty otherwise topmost element
	 */
	@Override
	public int topElement() {
		if(top==-1) {
			System.out.println("stack is empty !");
			return 0;
		}
		return stackList.get(top);
	}
	
	/*
	 * method to display stack elements
	 */
	@Override
	public void printStack() {
		
		for(int stackIndex=top; stackIndex>=0; stackIndex--) {
			System.out.println(stackList.get(stackIndex));
		}
		
	}
	
}
