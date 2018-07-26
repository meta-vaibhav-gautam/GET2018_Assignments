/*
 * class containing methods for operations on sparse matrix
 * created on july 25, 2018
 */
public final class SparseMatrix {

    private final int matrix[][];

    /*
     * parameterized constructor to initialize matrix
     */
    public SparseMatrix(int matrix[][]) {
        this.matrix = matrix;
    }

    /*
     * method returns the sparseMatrix initialized
     */
    public int[][] getSparseMatrix() {
        return matrix;
    }

    /*
     * method calculates the transpose of the sparse matrix
     * @param sparseMatrix integer 2-D array
     * @return transpose of the 2-D sparse matrix array
     */
    public int[][] calculateTransposeOfMatrix() {

        int columnNumber = 0;

        int sparseMatrix[][] = convertToOptimizedMatrix();
        int columnCount = sparseMatrix[0].length;
        int transposedMatrix[][] = new int[3][columnCount];

        for (columnNumber = 0; columnNumber < columnCount; columnNumber++) {

            transposedMatrix[0][columnNumber] = sparseMatrix[1][columnNumber];
            transposedMatrix[1][columnNumber] = sparseMatrix[0][columnNumber];
            transposedMatrix[2][columnNumber] = sparseMatrix[2][columnNumber];

        }
        return transposedMatrix;
    }

    /*
     * method checks if the matrix initialized is symmetric or not
     * @return true if symmetric otherwise return false
     */
    public boolean checkForSymmetricalMatrix() {
        int rowCount = 3;
        int rowNumber = 0, columnNumber = 0;

        int sparseMatrix[][] = convertToOptimizedMatrix();
        int transposedMatrix[][] = sortTheMatrix(calculateTransposeOfMatrix()); //getting sorted transpose of matrix 
        int columnCount = sparseMatrix[0].length;

        for (rowNumber = 0; rowNumber < rowCount; rowNumber++) {

            for (columnNumber = 0; columnNumber < columnCount; columnNumber++) {
                if (!(sparseMatrix[rowNumber][columnNumber] == transposedMatrix[rowNumber][columnNumber])) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * method is used to two matrices and return a resultant matrix
     * @param SparseMatrix object s1
     * @param SparseMatrix object s2
     * @return resultantMatrix as sum of two matrices
     */
    public int[][] addMatrices(SparseMatrix s1, SparseMatrix s2) {
        int firstMatrix[][] = s1.getSparseMatrix();
        printSparseMatrix(s1.convertToOptimizedMatrix());
        System.out.println("-------------------------");
        printSparseMatrix(sortTheMatrix(s1.convertToOptimizedMatrix()));
        
        int secondMatrix[][] = s2.getSparseMatrix();
        int columnCount = firstMatrix[0].length + secondMatrix[0].length;
        int firstMatrixColumnCount = firstMatrix[0].length;
        int resultantMatrix[][] = new int[3][columnCount];

        int returningResultantMatrix[][];
        for (int columnNumber = 0; columnNumber < firstMatrix[0].length; columnNumber++) {
            resultantMatrix[0][columnNumber] = firstMatrix[0][columnNumber];
            resultantMatrix[1][columnNumber] = firstMatrix[1][columnNumber];
            resultantMatrix[2][columnNumber] = firstMatrix[2][columnNumber];
        }
        for (int columnNumber = 0; columnNumber < secondMatrix[0].length; columnNumber++) {
            resultantMatrix[0][columnNumber + firstMatrixColumnCount] = secondMatrix[0][columnNumber];
            resultantMatrix[1][columnNumber + firstMatrixColumnCount] = secondMatrix[1][columnNumber];
            resultantMatrix[2][columnNumber + firstMatrixColumnCount] = secondMatrix[2][columnNumber];
        }

        resultantMatrix = sortTheMatrix(resultantMatrix);

        //printSparseMatrix(resultantMatrix); ////////////////////////////////////

        returningResultantMatrix = new int[3][resultantMatrix[0].length];
        for (int columnNumber = 0; columnNumber < resultantMatrix[0].length; columnNumber++) {
            if (resultantMatrix[0][columnNumber] != resultantMatrix[0][columnNumber + 1] || resultantMatrix[1][columnNumber] != resultantMatrix[1][columnNumber + 1]) {

                returningResultantMatrix[0][columnNumber] = resultantMatrix[0][columnNumber];
                returningResultantMatrix[1][columnNumber] = resultantMatrix[1][columnNumber];
                returningResultantMatrix[2][columnNumber] = resultantMatrix[2][columnNumber];

            } else {

                int index = columnNumber;
                returningResultantMatrix[0][columnNumber] = resultantMatrix[0][columnNumber];
                returningResultantMatrix[1][columnNumber] = resultantMatrix[1][columnNumber];

                if ((index != resultantMatrix[0].length - 1)) {

                    while (resultantMatrix[0][index] == resultantMatrix[0][index + 1] && resultantMatrix[1][index] == resultantMatrix[1][index + 1]) {
                        returningResultantMatrix[2][index] += resultantMatrix[2][index] + resultantMatrix[2][index + 1];
                        index++;
                    }

                    columnNumber = index + 1;
                } else {
                    returningResultantMatrix[2][columnNumber] = resultantMatrix[2][columnNumber];
                }
            }

        }
        return resultantMatrix;
    }

    /*
     * method is used to convert the matrix in optimized form
     * @param matrix as 2D array
     * @return 2D array as optimized matrix
     */
    private int[][] convertToOptimizedMatrix() {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int rowNumber = 0, columnNumber = 0;
        int nonZeroValuesCount = countNonZeroElementsInMatrix();

        int convertedOptimizedMatrix[][];

        convertedOptimizedMatrix = new int[3][nonZeroValuesCount];
        int optimizedMatrixColumnNumber = 0;

        for (rowNumber = 0; rowNumber < rowCount; rowNumber++) {

            for (columnNumber = 0; columnNumber < columnCount; columnNumber++) {
                if (matrix[rowNumber][columnNumber] > 0) {

                    convertedOptimizedMatrix[0][optimizedMatrixColumnNumber] = rowNumber;
                    convertedOptimizedMatrix[1][optimizedMatrixColumnNumber] = columnNumber;
                    convertedOptimizedMatrix[2][optimizedMatrixColumnNumber] = matrix[rowNumber][columnNumber];

                    optimizedMatrixColumnNumber++;

                }
            }
        }
        return convertedOptimizedMatrix;
    }

    /*
     * method is used to count non zero elements of the matrix
     * @param matrix as 2D array
     * return count of non-zero elements calculated
     */
    private int countNonZeroElementsInMatrix() {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int rowNumber = 0, columnNumber = 0;
        int nonZeroValuesCount = 0;

        for (rowNumber = 0; rowNumber < rowCount; rowNumber++) {

            for (columnNumber = 0; columnNumber < columnCount; columnNumber++) {
                if (matrix[rowNumber][columnNumber] > 0) {
                    nonZeroValuesCount++;
                }
            }
        }
        return nonZeroValuesCount;
    }

    /*
     * method is used to sort converted optimized matrix obtained
     * @return 2D array as sorted matrix
     */
    private int[][] sortTheMatrix(int matrix[][]) {
        int sortedSparseMatrix[][] = matrix;
        int columnCount = sortedSparseMatrix[0].length;

        int columnNumber = 0, tempColumnNumber = 0;

        for (columnNumber = 0; columnNumber < columnCount - 1; columnNumber++) {
            for (tempColumnNumber = 0; tempColumnNumber < columnCount - columnNumber - 1; tempColumnNumber++) {
                int index = tempColumnNumber;

                if (sortedSparseMatrix[0][index] >sortedSparseMatrix[0][index + 1] ) {

                    int temp = sortedSparseMatrix[0][index];
                    sortedSparseMatrix[0][index] = sortedSparseMatrix[0][index + 1];
                    sortedSparseMatrix[0][index + 1] = temp;

                    temp = sortedSparseMatrix[1][index];
                    sortedSparseMatrix[1][index] = sortedSparseMatrix[1][index + 1];
                    sortedSparseMatrix[1][index + 1] = temp;

                    temp = sortedSparseMatrix[2][index];
                    sortedSparseMatrix[2][index] = sortedSparseMatrix[2][index + 1];
                    sortedSparseMatrix[2][index + 1] = temp;

                }
            }
        }

        return sortedSparseMatrix;
    }

    /*private int[][] sort(int matrix[][]) {
    	int maximumColumnNumber=0;
    	int elementCount=0;
    	int columnCount=matrix[0].length;
    	
    	for(int column=0 ; column<columnCount ; column++) {
    		if(maximumColumnNumber<matrix[1][column]) {
    			maximumColumnNumber=matrix[1][column];
    		}
    	}
    	
    	int lengthOfTemporaryArray=maximumColumnNumber+1; 
    	int temporaryArray[]=new int [lengthOfTemporaryArray];
    	int index=0;
    	for(int column=0 ; column<columnCount ; column++) {
    		if(index==matrix[1][column]) {
    			elementCount++;
    		}
    	}
    }*/

    /*
     * method is used to print sparse matrix completely 
     * @param sparseMatrix as 2-D array
     */
    public void printSparseMatrix(int sparseMatrix[][]) {
        int rowCount = 3; //row count will always be 3 for a sparse matrix representation
        int columnCount = sparseMatrix[0].length;
        int rowNumber = 0, columnNumber = 0;

        for (rowNumber = 0; rowNumber < rowCount; rowNumber++) {

            for (columnNumber = 0; columnNumber < columnCount; columnNumber++) {
                System.out.print(sparseMatrix[rowNumber][columnNumber] + " ");
            }
            System.out.println();
        }
    }
}