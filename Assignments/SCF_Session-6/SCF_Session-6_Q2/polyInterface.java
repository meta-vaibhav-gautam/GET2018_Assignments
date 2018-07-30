/*
 * interface containing abstract methods
 * for operation on polynomials
 */
public interface polyInterface {

	double evaluate(float x);
	int degree(Poly p);
	int[] addPoly(Poly p1,Poly p2);
	int[] multiplyPoly(Poly p1,Poly p2);
}
