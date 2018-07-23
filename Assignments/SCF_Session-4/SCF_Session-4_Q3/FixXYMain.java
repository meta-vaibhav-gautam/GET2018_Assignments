import java.util.Scanner;

/*
 * class containing main method
 */
public class FixXYMain {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of elements: ");
		int elements=sc.nextInt();
		int elementsArray[]=new int[elements];
		System.out.println("Enter elements: ");
		for(int i=0;i<elements;i++)
		{
			elementsArray[i]=sc.nextInt();
		}
		FixXY obj=new FixXY();
		System.out.println();
		System.out.println("Enter x: ");
		int x=sc.nextInt();
		System.out.println("Enter y: ");
		int y=sc.nextInt();
		int output[]=obj.fixXYPosition(elementsArray, x, y);
		for(int val:output){
			System.out.print(val+" ");
		}
		sc.close();
	}
}
