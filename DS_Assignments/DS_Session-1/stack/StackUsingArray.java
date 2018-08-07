package stack;

/*
 * class containing concrete implementation of stack using array
 * created on August 1, 2018
 */
public class StackUsingArray implements Stack {

	private  int stackMaxSize = 0;
	private int stackArray[];
	public StackUsingArray (int maxSizeOfStack) {
		this.stackMaxSize=maxSizeOfStack;
		stackArray = new int[stackMaxSize];
	}
	
	private int top=-1;
	
	/*
	 * method to push elements to the stack
	 * @param element as integer which is to be pushed into stack
	 * @return 1 if successfully pushed otherwise 0
	 */
	@Override 
	public int pushElement(int element) {
		if(top==(stackMaxSize-1)) {
			System.out.println("Overflowed !");
			return 0;
		}
		stackArray[++top]=element;
		return 1;
	}

	/*
	 * method is used to delete elements from stack
	 * @return 1 if removed successfully otherwise return 0
	 */
	@Override
	public int popElement() {
		if(top==-1) {
			System.out.println("Stack underflowed !");
			return 0;
		}
		stackArray[top]=0;
		top--;
		return 1;
	}

	/*
	 * method to see top element of stack
	 * @return top element from stack
	 */
	@Override
	public int topElement() {
		return stackArray[top];
	}

	/*
	 * method to display stack elements
	 */
	@Override
	public void printStack() {
		
		for(int stackIndex=top; stackIndex>=0; stackIndex--) {
			System.out.println(stackArray[stackIndex]);
		}
		
	}
	
	
}
