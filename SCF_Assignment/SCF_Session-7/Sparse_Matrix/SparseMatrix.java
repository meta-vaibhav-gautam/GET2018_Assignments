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
    	int resultantMatrix[][];
        int firstMatrix[][] = s1.convertToOptimizedMatrix();
        int secondMatrix[][] = s2.convertToOptimizedMatrix();
        int columnCountForResultantMatrix = firstMatrix[0].length + secondMatrix[0].length;
        int firstMatrixColumnCount = firstMatrix[0].length;
        int secondMatrixColumnCount=secondMatrix[0].length;
        int commonElementCount=0;
        int index=0,i=0;
        resultantMatrix= new int[3][columnCountForResultantMatrix];
        
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
        
        //count no. of common element to be used in finding length of returning matrix
        while(i<firstMatrixColumnCount && i<secondMatrixColumnCount) {
        	if((firstMatrix[0][index]==secondMatrix[0][index]) && (firstMatrix[1][index]==secondMatrix[1][index])) {
        		commonElementCount++;
        	}
        	i++;
        }
        
        returningResultantMatrix = new int[3][resultantMatrix[0].length-commonElementCount]; //common values of resultant matrix will be added and stored in this matrix
        
        for (int columnNumber = 0; columnNumber < resultantMatrix[0].length-1; columnNumber++) {
        	
            if (resultantMatrix[0][columnNumber] != resultantMatrix[0][columnNumber + 1] || resultantMatrix[1][columnNumber] != resultantMatrix[1][columnNumber + 1]) {

                returningResultantMatrix[0][index] = resultantMatrix[0][columnNumber];
                returningResultantMatrix[1][index] = resultantMatrix[1][columnNumber];
                returningResultantMatrix[2][index] = resultantMatrix[2][columnNumber];

            } else {

                returningResultantMatrix[0][index] = resultantMatrix[0][columnNumber];
                returningResultantMatrix[1][index] = resultantMatrix[1][columnNumber];
                returningResultantMatrix[2][index] = resultantMatrix[2][columnNumber]+resultantMatrix[2][columnNumber+1];
                columnNumber++;
            }
            index++;
        }
        return returningResultantMatrix;
    }

    /*method is used to obtain product of two matrices
     * @param SparseMatrix object as s1
     * @param SparseMatrix object as s2
     * @return a 2D array as product
     */
    public int[][] multiplyMatrices(SparseMatrix s1, SparseMatrix s2) {
    	int resultantMatrix[][];
    	int firstMatrix[][]=s1.matrix;
    	int secondMatrix[][]=s2.matrix;
    	resultantMatrix=new int[firstMatrix.length][secondMatrix[0].length];
    	firstMatrix=s1.convertToOptimizedMatrix();
    	secondMatrix=sortTheMatrix(s2.calculateTransposeOfMatrix());
    	int k=0;
    	for(int i=0;i<resultantMatrix.length;i++) {
    		
    		for(int j=0;j<resultantMatrix[0].length;j++) {
    			
    			for(int temp=0;temp<secondMatrix[0].length;temp++) {
    				
    				if(firstMatrix[1][j]==secondMatrix[1][temp]) {
        				resultantMatrix[j][temp]=firstMatrix[2][j]*secondMatrix[2][temp];
        			} else {
        				resultantMatrix[j][temp]=0;
        			}
    			}
    		}
    	}
    	
    	SparseMatrix temporaryObject=new SparseMatrix(resultantMatrix);
    	return temporaryObject.convertToOptimizedMatrix();
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
                
                if (sortedSparseMatrix[0][index] >sortedSparseMatrix[0][index + 1]) {

                    int temp = sortedSparseMatrix[0][index];
                    sortedSparseMatrix[0][index] = sortedSparseMatrix[0][index + 1];
                    sortedSparseMatrix[0][index + 1] = temp;

                    temp = sortedSparseMatrix[1][index];
                    sortedSparseMatrix[1][index] = sortedSparseMatrix[1][index + 1];
                    sortedSparseMatrix[1][index + 1] = temp;

                    temp = sortedSparseMatrix[2][index];
                    sortedSparseMatrix[2][index] = sortedSparseMatrix[2][index + 1];
                    sortedSparseMatrix[2][index + 1] = temp;

                } else {
                	 if (sortedSparseMatrix[0][index] == sortedSparseMatrix[0][index + 1]) {
                     	if (sortedSparseMatrix[1][index] > sortedSparseMatrix[1][index + 1]) {
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
            }
        }
        
        return sortedSparseMatrix;
    }

    /*
     * method is used to print sparse matrix completely 
     * @param sparseMatrix as 2-D array
     */
    public void printSparseMatrix(int sparseMatrix[][]) {
        int rowCount = sparseMatrix.length; //row count will always be 3 for a sparse matrix representation
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