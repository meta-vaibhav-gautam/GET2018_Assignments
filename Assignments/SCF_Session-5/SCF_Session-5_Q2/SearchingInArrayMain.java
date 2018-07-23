import java.util.Scanner;
/*
 * class containing main method
 */
public class SearchingInArrayMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of Array: ");
		int size=sc.nextInt();
		int arr[]=new int[size];
		System.out.println("Enter your choice:\n1.Linear choice\t2.Binary Search (Array should be in sorted order)");
		int choice=sc.nextInt();
		System.out.println("Enter elements: ");
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		System.out.println("Enter element to be searched: ");
		int element=sc.nextInt();
		SearchingInArray obj=new SearchingInArray();
		
		switch(choice)
		{
			case 1:
				System.out.println("Searched element index : "+obj.linearSearch(arr,element));
				break;
			case 2:
				System.out.println("Searched element index : "+obj.binarySearch(arr, 0, size, element));
				break;
		}
		sc.close();
	}

}
