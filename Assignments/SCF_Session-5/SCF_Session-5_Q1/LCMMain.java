import java.util.Scanner;

/*
 * class containing main method
 */
public class LCMMain {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first number: ");
		int x=sc.nextInt();
		System.out.println("Enter Second number: ");
		int y=sc.nextInt();
		LCM obj=new LCM();
		HCF hcfObj=new HCF();
		System.out.println("LCM of given inputs: "+obj.findLCM(x, y));
		System.out.println("HCF of given inputs: "+hcfObj.findHCF(x,y));
		sc.close();
	}

}
