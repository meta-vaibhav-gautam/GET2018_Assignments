import java.util.Scanner;

/*
 * class containing main function i.e. running function
 */
public class NQueensProblemMain {

	public static void main(String[] args) 
	{
		System.out.println("Enter Number of Queens");
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        NQueensProblem obj=new NQueensProblem();
        obj.solveNQ(n);
        sc.close();
	} 
}
