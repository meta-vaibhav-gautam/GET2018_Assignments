import java.util.Scanner;
import java.util.Stack;
class Pallindrome{
	public boolean checkPallindrome(String str){
		boolean flag=false;
		Stack stack=new Stack();
		for(int i=0;i<str.length();i++){
			stack.push(str.charAt(i));
		}
		
		String reverseString="";
		while(!stack.isEmpty()){
			reverseString=reverseString+(stack.pop());
		}
		
		if(reverseString.equals(str))
			flag=true;
		
		return flag;
	}
}

public class PallindromeCheck {
	
	public static void main(String args[]){
		Pallindrome obj=new Pallindrome();
		System.out.println("Enter string: ");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		if(obj.checkPallindrome(str)){
			System.out.println("String is a pallindrome.");
		}
		else
		{
			System.out.println("String is not a pallindrome.");
		}
	}
}
