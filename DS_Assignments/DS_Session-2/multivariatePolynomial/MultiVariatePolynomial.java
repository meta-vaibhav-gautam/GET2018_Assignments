package multivariatePolynomial;

import java.util.List;

/*
 * class containing nested list representation of multivariate polynomial
 * created on August 06, 2018
 */
public class MultiVariatePolynomial {
private List<List<Integer>> polynomialList = null;
	
	public MultiVariatePolynomial(List<List<Integer>> polynomialList) {
		this.polynomialList = polynomialList;
	}
	
	/*
	 * method to display coefficient list of multivariate polynomial
	 */
	public void displayPolynomial() {
		for(List<Integer> coefficientList : polynomialList) {
			System.out.println("coeffcient list of variable: ");
			int length = coefficientList.size();
			for(int i=0 ; i<length ; i++) {
				System.out.print(coefficientList.get((length-1)-i)+" ");
			}
			System.out.println();
		}
	}
}
