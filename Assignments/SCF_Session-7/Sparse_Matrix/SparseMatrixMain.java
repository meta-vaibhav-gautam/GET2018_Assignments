import java.util.Scanner;


public class SparseMatrixMain {

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
		SparseMatrix sparseMatrix;
		/*int matrix[][];
		matrix=takeInput();
		sparseMatrix=new SparseMatrix(matrix);
		int transpose[][]=sparseMatrix.calculateTransposeOfMatrix();
		
		for(int i=0;i<transpose.length;i++) {
			for(int j=0;j<transpose[0].length;j++) {
				System.out.print(transpose[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\nCheck for symmetrical : "+sparseMatrix.checkForSymmetricalMatrix());
		*/
		int matrix1[][]=takeInput();
		SparseMatrix sparseMatrix1=new SparseMatrix(matrix1);
		int matrix2[][]=takeInput();
		SparseMatrix sparseMatrix2=new SparseMatrix(matrix2);
		
		int resultantMatrix[][]=sparseMatrix1.addMatrices(sparseMatrix1, sparseMatrix2);
		
		System.out.println("\nSum::::\n");
		for(int i=0;i<resultantMatrix.length;i++) {
			for(int j=0;j<resultantMatrix[0].length;j++) {
				System.out.print(resultantMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
