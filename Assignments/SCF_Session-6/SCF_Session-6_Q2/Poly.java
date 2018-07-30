import java.util.Scanner;

/*
 * class containing all the methods used for the operation on polynomials
 * created on july 25, 2018
 */
public final class Poly implements polyInterface {

    private int polynomialCoefficientArray[]; //Array to store coefficient of the variables

    /*
     * method is used to set arr for every object
     * @param arr array as input
     */
    public void setPolynomialCoefficientArray(int[] arr) {
        int length = arr.length;
        
        this.polynomialCoefficientArray = new int[length];
        int i = 0, j = 0;
        for (i = (length - 1), j = 0; i >= 0 && j < length; i--, j++) //reversing polynomialCoefficientArray
        {
            this.polynomialCoefficientArray[i] = arr[j];
        }
    }

    /*
     * method is used to return array of coefficients of polynomials
     */
    public int[] getPolynomialCoefficientArray() {
        return polynomialCoefficientArray;
    }

    /*
     * method evaluates the value from a polynomial by replacing x by parameter
     * @param x as float
     * return result evaluated as double
     */
    @Override
    public double evaluate(float x) {

        int polynomial[] = getPolynomialCoefficientArray();
        double result = 0;
        for (int i = 0; i < polynomial.length; i++) {
            result += polynomial[i] * Math.pow(x, i);
        }
        return result;
    }

    /*
     * method returns the degree of the polynomial
     * @param Poly class object
     * @return degree of the polynomial
     */
    @Override
    public int degree(Poly p) {
        return polynomialCoefficientArray.length - 1;
    }

    /*
     * method adds two polynomials
     * @param Poly class object p1 as first polynomial
     * @param Poly class object p2 as second polynomial
     * @return result array as addition computed
     */
    @Override
    public int[] addPoly(Poly p1, Poly p2) {
        int lengthPoly1 = p1.polynomialCoefficientArray.length;
        int lengthPoly2 = p2.polynomialCoefficientArray.length;
        int length = lengthPoly1 > lengthPoly2 ? lengthPoly1 : lengthPoly2;
        int tempResult[] = new int[length];
        int result[] = new int[length];
        int i = 0, j = 0;

        for (i = 0; i < length; i++) {
            if (i >= lengthPoly1) {
                tempResult[i] = p2.polynomialCoefficientArray[i];
            } else if (i >= lengthPoly2) {
                tempResult[i] = p1.polynomialCoefficientArray[i];
            } else {
                tempResult[i] = p1.polynomialCoefficientArray[i] + p2.polynomialCoefficientArray[i];
            }
        }
        for (i = (length - 1), j = 0; i >= 0 && j < length; i--, j++) //reversing tempResult
        {
            result[i] = tempResult[j];
        }
        return result;
    }

    /*
     * method multiplies two polynomials
     * @param Poly class object p1 as first polynomial input
     * @param Poly class object p2 as second polynomial input
     * @return result array as product computed
     */
    @Override
    public int[] multiplyPoly(Poly p1, Poly p2) {
        int lengthPoly1 = p1.polynomialCoefficientArray.length;
        int lengthPoly2 = p2.polynomialCoefficientArray.length;
        int length = lengthPoly1 + lengthPoly2 - 1;
        int tempResult[] = new int[length];
        int result[] = new int[length];
        int i = 0, j = 0;
        
        for (i = 0; i < lengthPoly2; i++) {
            for (j = 0; j < lengthPoly1; j++) {
                tempResult[i + j] += p2.polynomialCoefficientArray[i] * p1.polynomialCoefficientArray[j];
            }
        }
        
        for (i = (length - 1), j = 0; i >= 0 && j < length; i--, j++) //reversing tempResult
        {
            result[i] = tempResult[j];
        }
        
        return result;
    }

    /*
     * method is used to take input from user
     */
    public void takeInput() {
        Scanner sc = new Scanner(System.in);
        int polynomial[];
        System.out.println("Enter no. of inputs:");
        int n = sc.nextInt();
        System.out.println("Enter polynomial coefficients:\n(0 if no coefficient is present)");
        polynomial = new int[n];
        System.out.println("Enter data: ");
        
        for (int i = 0; i < n; i++) {
            polynomial[i] = sc.nextInt();
        }
        
        setPolynomialCoefficientArray(polynomial);
    }

}