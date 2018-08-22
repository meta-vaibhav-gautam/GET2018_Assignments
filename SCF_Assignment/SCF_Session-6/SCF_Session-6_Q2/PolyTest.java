import static org.junit.Assert.*;

import org.junit.Test;

/*
 * junit test class containing test cases
 * created on july 25, 2018
 */
public class PolyTest {

	//positive test for evaluate() method
	@Test
	public void testEvaluatePass() {
		Poly obj=new Poly();
		obj.setPolynomialCoefficientArray(new int[]{3,1,2,4});
		double result=obj.evaluate(2);
		
		assertEquals(36, (int)result);
	}
	
	//negative test for evaluate() method
	@Test
	public void testEvaluateFail() {
		Poly obj=new Poly();
		obj.setPolynomialCoefficientArray(new int[]{3,1,2,4});
		double result=obj.evaluate(2);
		
		assertNotEquals(60, (int)result);
	}
	
	//positive test for degree() method
	@Test
	public void testDegreePass() {
		Poly obj=new Poly();
		obj.setPolynomialCoefficientArray(new int[]{3,1,2,4});
		int result=obj.degree(obj);
		
		assertEquals(3, result);
	}
	
	//negative test for degree() method
	@Test
	public void testDegreeFail() {
		Poly obj=new Poly();
		obj.setPolynomialCoefficientArray(new int[]{3,1,2,4});
		int result=obj.degree(obj);
		
		assertNotEquals(4, result);
	}
	
	//positive test for addPolynomial() method
	@Test
	public void testaddPolynomialPass() {
		Poly obj1=new Poly();
		obj1.setPolynomialCoefficientArray(new int[]{3,1,2,4});
		Poly obj2=new Poly();
		obj2.setPolynomialCoefficientArray(new int[]{1,2,3});
		int expected[]=new int[]{3,2,4,7};
		int result[]=obj1.addPoly(obj1,obj2);
		
		assertArrayEquals(expected, result);
	}
	
	//positive test for multiplyPolynomial()
	@Test
	public void testmultiplyPolynomialPass() {
		Poly obj1=new Poly();
		obj1.setPolynomialCoefficientArray(new int[]{3,1,2,4});
		Poly obj2=new Poly();
		obj2.setPolynomialCoefficientArray(new int[]{1,2});
		int expected[]=new int[]{3,7,4,8,8};
		int result[]=obj1.multiplyPoly(obj1,obj2);
		
		assertArrayEquals(expected, result);
	}
	

}
