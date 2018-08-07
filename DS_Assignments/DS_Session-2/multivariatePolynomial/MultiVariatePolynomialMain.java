package multivariatePolynomial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * class containing main method
 * created on August 06, 2018
 */
public class MultiVariatePolynomialMain {
	private static List<List<Integer>> polynomialList= new ArrayList<List<Integer>>();
	private static List<Integer> coefficientList = null;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String args[]) {
		System.out.println("Enter the no. of variables the Polynomial have: ");
		int numberOfVariables = scanner.nextInt();
		for(int i=0 ; i<numberOfVariables ; i++) {
			System.out.println("Enter the number of coefficients for the "+(i+1)+" variable:");
			int numberOfCoefficient = scanner.nextInt();
			System.out.println("Enter the coefficients for the "+(i+1)+" variable:");
			coefficientList = new ArrayList<Integer>();
			for(int j=0;j<numberOfCoefficient;j++) {
				coefficientList.add(j, scanner.nextInt());
			}
			polynomialList.add(coefficientList);
		}
		
		MultiVariatePolynomial obj = new MultiVariatePolynomial(polynomialList);
		System.out.println("Polynomial you entered :");
		obj.displayPolynomial();
		
	}
}
