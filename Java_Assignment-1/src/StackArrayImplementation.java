import java.util.Scanner;

class StackArrayMethods{
	int stackArray[]=new int[5];
	int top=-1;
	
	public void Push(int element){
		if(top<5){
			top++;
			stackArray[top]=element;
		}
		else
			System.out.println("Stack overflowed !");
	}
	
	public void Pop(){
		stackArray[top]=0;
		top--;
		
	}
	
	public int Top(){
		if(isEmpty())
			return 0;
		else
			return stackArray[top];
	}
	
	public boolean isEmpty(){
		if(top!=-1)
			return false;
		else
			return true;
	}
	
	public void show(){
		for(int i=0;i<=top;i++){
			System.out.println(stackArray[i]);
		}
	}
}

public class StackArrayImplementation {
	public static void main(String args[]){
		int numberOfElement=0;
		int choice=0;
		Scanner sc=new Scanner(System.in);
		StackArrayMethods obj=new StackArrayMethods();
		while(choice!=5){
		System.out.println("enter your choice: 1.Push  2.Pop  3.top  4.isEmpty 5.exit");
		choice=sc.nextInt();
		
		switch(choice){
		case 1:
				System.out.println("Enter no. of elements to be entered: ");
				numberOfElement=sc.nextInt();
				for(int i=0;i<numberOfElement;i++)
					obj.Push(sc.nextInt());
				obj.show();
				break;
		case 2:
				obj.Pop();
				obj.show();
				break;
		case 3:
				System.out.println(obj.Top());
				break;
		case 4:
				System.out.println(obj.isEmpty());
				break;
		case 5:
				break;
		default:
				System.out.println("incorrect choice !");
	 }
	}
	}
}

