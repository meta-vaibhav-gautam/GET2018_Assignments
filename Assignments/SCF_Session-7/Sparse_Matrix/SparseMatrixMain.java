import java.util.Scanner;

/*
 * class containing main method
 * created on july 26, 2018
 */
public class SparseMatrixMain {

	/*
	 * method is used to take input from user
	 * @return a 2D matrix entered by user
	 */
	public static int[][] takeInput() {
		int rowCount=0,columnCount=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of row: ");
		rowCount=sc.nextInt();
		System.out.println("Enter the no. of columns: ");
		columnCount=sc.nextInt();
		int matrix[][]=new int [rowCount][columnCount];
		
		System.out.println("Enter sparse matrix (no. of zeroes must be more than non-zero elements):");
		
		for(int rowNumber=0;rowNumber<rowCount;rowNumber++) {
			for(int columnNumber=0;columnNumber<columnCount;columnNumber++) {
				System.out.print("matrix ["+rowNumber+"] ["+columnNumber+"]= ");
				matrix[rowNumber][columnNumber]=sc.nextInt();
			}
			System.out.println();
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		System.out.println("Enter your choice\n1. transpose\n2. is symmetric\n3. add matrix\n4. multiply matrix\n");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		SparseMatrix sparseMatrix;
		SparseMatrix sparseMatrix1;
		SparseMatrix sparseMatrix2;
		
		switch(choice) {
			case 1:
				int matrix[][]=takeInput();
				sparseMatrix=new SparseMatrix(matrix);
				System.out.println("\nEntered Matrix:\n");
				int transposedMatrix[][]=sparseMatrix.calculateTransposeOfMatrix();
				System.out.println("\nTranspose Matrix:\n");
				sparseMatrix.printSparseMatrix(transposedMatrix);
				break;
				
			case 2:
				int symmetricMatrix[][]=takeInput();
				sparseMatrix=new SparseMatrix(symmetricMatrix);
				System.out.println("Check for symmetric matrix: "+sparseMatrix.checkForSymmetricalMatrix());
				break;
				
			case 3:
				System.out.println("\n1st Matrix:\n");
				int matrix1[][]=takeInput();
				sparseMatrix1=new SparseMatrix(matrix1);
				System.out.println("\n2nd Matrix:\n");
				int matrix2[][]=takeInput();
				sparseMatrix2=new SparseMatrix(matrix2);
				int result[][]=sparseMatrix2.addMatrices(sparseMatrix1, sparseMatrix2);
				sparseMatrix2.printSparseMatrix(result);
				break;
			case 4:
				System.out.println("\n1st Matrix:\n");
				int matrix3[][]=takeInput();
				sparseMatrix1=new SparseMatrix(matrix3);
				System.out.println("\n2nd Matrix:\n");
				int matrix4[][]=takeInput();
				sparseMatrix2=new SparseMatrix(matrix4);
				int result1[][]=sparseMatrix2.addMatrices(sparseMatrix1, sparseMatrix2);
				sparseMatrix2.printSparseMatrix(result1);
				break;
			default:
				System.out.println("Incorrect choice...");
		}
	}

}
