/*
 * class containing method to find N-queens problem solution
 */
public class NQueensProblem {

    /*
     * method to place queens without any conflicts
     * placing the queen row by row by fixing column no. 
     * and checking for isSafe method 
     * @param board array as chess board
     * @param col as column number
     * @param n as no. of queens 
     * @return true if solution is possible
     * @return false if solution is not possible
     */
    public boolean nQueen(int board[][], int col, int n) {
        if (col >= n)
            return true;

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;
                if (nQueen(board, col + 1, n) == true) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    /*
     * method solves the n-queen problem by using placeQueen method
     * and show the solution if it is poassible
     * @param n as no. of queens to be placed 
     * @return true if solution is possible
     * @return false if solution is not possible
     */
    public boolean solveNQ(int n) //n is no. of queens
    {
        int board[][] = new int[n][n];

        if (nQueen(board, 0, n) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board, n);
        return true;
    }


    /*
     * method is used to find if the placement of queen is safe or not
     * @param board as 2-d array for board
     * @param row as int from where to start placing
     * @param col as int in board matrix
     * @param n as no. of queens
     * @return true if placement do not conflicts with other placements
     * @return false if conflicts occur
     */
    boolean isSafe(int board[][], int row, int col, int n) {
        int i, j;

        for (i = 0; i < col; i++) //Check this row on left side 
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) //Check upper diagonal on left side 
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < n; i++, j--) //Check lower diagonal on left side
            if (board[i][j] == 1)
                return false;

        return true;
    }

    /*
     * method prints the solution
     * @param board array
     * @param n as no. of queens
     */
    void printSolution(int board[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }
}