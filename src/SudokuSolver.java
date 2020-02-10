import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[9][9];


        for (int i = 0; i < 9; i++){
            String line = in.nextLine();
            String[] lineSplit = line.split("");
            for (int j = 0; j < 9; j++){
                grid[i][j] = Integer.parseInt(lineSplit[j]);
            }
        }

        if (solveSudoku(grid))
            System.out.println(true);
        else
            System.out.println(false);
    }

    public static boolean solveSudoku(int[][] grid){
        Object[] values = findEmptyLocation(grid);
        int row = (int) values[0];
        int col = (int) values[1];
        if (row == -1 && col == -1){
            return true;
        }
        else{
            for (int i = 0; i <= 9; i++){
                if (isSafe(grid, row, col, i)){
                    grid[row][col] = i;
                    if (solveSudoku(grid)){
                        return true;
                    }
                    grid[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] grid, int row, int col, int num){
        if (isSafeInRow(grid, row, num) && isSafeInColumn(grid, col, num) && isSafeInSubGrid(grid, row, col, num)){
            return true;
        }
        return false;
    }

    public static boolean isSafeInRow(int[][] grid, int row, int num){
        for (int i = 0; i < 9; i++){
            if (grid[row][i] == num)
                return false;
        }
        return true;
    }

    public static boolean isSafeInColumn(int[][] grid, int col, int num){
        for (int i = 0; i < 9; i++){
            if (grid[i][col] == num)
                return false;
        }
        return true;
    }

    public static boolean isSafeInSubGrid(int[][] grid, int row, int col, int num){
        int rowFactor = row - row % 3;
        int colFactor = col - col % 3;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (grid[i+rowFactor][j+colFactor] == num)
                    return false;
            }
        }
        return true;
    }

    public static Object[] findEmptyLocation(int[][] grid){
        Object[] values = new Object[2];
        values[0] = -1;
        values[1] = -1;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (grid[i][j] == 0){
                    values[0] = i;
                    values[1] = j;
                    return values;
                }
            }
        }
        return values;
    }
}
