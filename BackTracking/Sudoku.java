package BackTracking;

public class Sudoku {
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        for(int i=0; i<9; i++) {
            if(sudoku[i][col] == digit) {
                return false;
            }
        }
        for(int j=0; j<9; j++) {
            if(sudoku[row][j] == digit) {
                return false;
            }
        }
        int starting_row = (row/3) * 3;
        int starting_col = (col/3) * 3;

        for(int i=starting_row; i<starting_row+3; i++) {
            for(int j=starting_col; j<starting_col+3; j++) {
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void printSudoku(int[][] sudoku) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean sudokuSolver(int[][] sudoku,int row,int col) {
        // base case
        if(row == 9) {
            return true;
        }
        //recursion
        int nextRow = row;
        int nextCol = col+1;

        if(col+1 == 9) {
            nextCol = 0;
            nextRow = row+1;
        }
        if(sudoku[row][col] != 0) {
            return sudokuSolver(sudoku,nextRow,nextCol);
        }

        for(int digit=1; digit<=9; digit++) {
            if(isSafe(sudoku,row,col,digit)) {
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku,nextRow,nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] sudoku = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };

        if(sudokuSolver(sudoku,0,0)) {
            System.out.println("Solution Exists!");
            printSudoku(sudoku);
        }
        else {
            System.out.println("Solution Doesn't Exist.");
        }

    }
}
