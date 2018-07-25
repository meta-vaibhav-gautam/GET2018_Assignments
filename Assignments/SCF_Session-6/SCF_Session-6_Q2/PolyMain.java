import java.util.Scanner;

/*
 * class containing main method
 * created on july 25, 2018
 */
public class PolyMain {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		Poly obj=new Poly();
		Poly objPolynomial1=new Poly();
		Poly objPolynomial2=new Poly();
		System.out.println("Enter your choice\n1. Evaluate\n2. find degree\n3. add polynomial\n4. multiply polynomial()\n");
		
		int choice=scan.nextInt();
		switch(choice){
			case 1:
				obj.takeInput();
				System.out.println("Enter the value of x: ");
				float x=scan.nextInt();
				System.out.println("value evaluated : "+obj.evaluate(x));
				break;
				
			case 2:
				obj.takeInput();
				System.out.println("Degree of polynomial : "+obj.degree(obj));
				break;
				
			case 3:
				System.out.println("Enter polynomial 1:");
				objPolynomial1.takeInput();
				System.out.println("Enter Polynomial 2: ");
				objPolynomial2.takeInput();
				
				int result[]=obj.addPoly(objPolynomial1, objPolynomial2);
				for(int val:result)
				{
					System.out.print(val+" ");
				}
				break;
			case 4:
				System.out.println("Enter polynomial 1:");
				objPolynomial1=new Poly();
				objPolynomial1.takeInput();
				System.out.println("Enter Polynomial 2: ");
				objPolynomial2=new Poly();
				objPolynomial2.takeInput();
				
				int multiplyResult[]=obj.multiplyPoly(objPolynomial1, objPolynomial2);
				for(int val:multiplyResult)
				{
					System.out.print(val+" ");
				}
				break;
			default:
				System.out.println("Incorrect choice...");
		}
		scan.close();
	}
	

}
