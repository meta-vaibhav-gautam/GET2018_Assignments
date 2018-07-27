import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/*
 * jUnit class containing test methods
 * created on July 26, 2018
 */
public class SparseMatrixTest {

	//test method for calculateTransposeOfMatrix success scenario
	@Test
	public void testCalculateTransposeOfMatrix_Success() {
		int matrix[][]=new int[][] {
				{1,0,0,0},
				{0,0,2,0},
				{3,0,0,0}
		};
		int expected[][]=new int[][] {
				{0,2,0},
				{0,1,2},
				{1,2,3}
		};
		SparseMatrix sparseMatrix=new SparseMatrix(matrix);
		int result[][]=sparseMatrix.calculateTransposeOfMatrix();
		boolean flag=isMatrixEqual(result, expected);
		
		assertEquals(true,flag);
	}
	
	//method to test CalculateTransposeOfMatrix method failure scenario
	@Test
	public void testCalculateTransposeOfMatrix_Failure() {
		int matrix[][]=new int[][] {
				{1,0,0,0},
				{0,0,2,0},
				{3,0,0,0}
		};
		int expected[][]=new int[][] {
				{0,2,0},
				{0,1,2},
				{1,2,3}
		};
		SparseMatrix sparseMatrix=new SparseMatrix(matrix);
		int result[][]=sparseMatrix.calculateTransposeOfMatrix();
		boolean flag=isMatrixEqual(result, expected);
		
		assertNotEquals(false,flag);
	}

	//method to check if two matrices are equal or not
	private boolean isMatrixEqual(int result[][],int expected[][]) {
		boolean flag=true;
		for(int rowNumber=0;rowNumber<result.length;rowNumber++) {
			if(!(Arrays.equals(result[rowNumber], expected[rowNumber]))) {
				flag=false;
				break;
			}
		}
		return flag;
	}
}
