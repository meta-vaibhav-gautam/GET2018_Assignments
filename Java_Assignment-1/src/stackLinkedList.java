import java.util.*;
/*
 * class containing operations of stack 
 * such as push, pop, top, isEmpty
 */
class stackImplementation{
	
	List<Integer> stack=new LinkedList<Integer>();
	Scanner sc=new Scanner(System.in);
	int top=-1;
	
	//method to insert elements in stack
	public void Push(int element){
		top++;
		stack.add(element);
	}
	
	 //method to pop element from stack
	public void Pop(){
		if(!(stack.isEmpty())){
			stack.remove(top);
			top--;
		}
		else
			System.out.println("stack underflowed !");
	}
	
	//element to look topmost element in stack
	public int Top(){
		return stack.get(top);
	}
	
	//method to display stack elements
	public void show(){
		for(int i=top;i>=0;i--)
		{
			System.out.println(stack.get(i));
		}
	}
	
}
