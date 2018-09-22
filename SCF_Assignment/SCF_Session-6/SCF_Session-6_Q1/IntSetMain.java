import java.util.Scanner;

/*
 * class containing main method
 * created on july 24, 2018
 */
public class IntSetMain {

	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		IntSet obj=new IntSet();
		System.out.println("Enter your choice\n1. isMember()\n2. size()\n3. isSubset()\n4. getCompliment()\n5. union()\n");
		
		int choice=scan.nextInt();
		switch(choice){
			case 1:
				obj.takeInput();
				System.out.println("Enter the element: ");
				int element=scan.nextInt();
				System.out.println(obj.isMember(element));
				break;
			case 2:
				System.out.println("Size of set: "+obj.size());
				break;
			case 3:
				System.out.println("Enter super set:");
				obj.takeInput();
				System.out.println("Subset :");
				IntSet objSubSet=new IntSet();
				objSubSet.takeInput();
				System.out.println("\n"+obj.isSubset(objSubSet));
				break;
			case 4:
				System.out.printf("compliment");
				IntSet complimentObj=new IntSet();
				System.out.println("Enter a set:");
				complimentObj.takeInput();
				int complimentSet[]=complimentObj.getCompliment(complimentObj);
				for(int val:complimentSet)
				{
					System.out.print(val+" ");
				}
				break;
			case 5:
				IntSet set1=new IntSet();
				IntSet set2=new IntSet();
				int arr[]=obj.union(set1, set2);
				for(int val:arr)
					System.out.print(val+" ");
				break;
			default:
				System.out.println("Incorrect choice...");
		}
		scan.close();
	}
}
