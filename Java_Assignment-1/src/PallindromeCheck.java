import java.util.Scanner;
import java.util.Stack;

/*
 * Class containing main method
 */

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
