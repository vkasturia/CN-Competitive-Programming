import java.util.Scanner;

public class NQueenProblem {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        placeNQueens(n);
    }
    public static void placeNQueens(int n){
        int[][] board = new int[n][n];
        NQueenHelper(n, 0, board);
    }
    public static void NQueenHelper(int n, int row, int[][] board){
        if (row == n){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.print("\n");
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isPossible(n, row, col, board)) {
                board[row][col] = 1;
                NQueenHelper(n, row+1, board);
                board[row][col] = 0;
            }
        }
        return;
    }
    public static boolean isPossible(int n, int row, int col, int[][] board){
        int j = row;
        int k = col;
        while (row >= 0){
            if (board[row][col] == 1){
                return false;
            }
            row -= 1;
        }
        row = j;
        while (row >= 0 && col >= 0){
            if (board[row][col] == 1){
                return false;
            }
            row -= 1;
            col -= 1;
        }
        row = j;
        col = k;
        while (row >= 0 && col < n){
            if (board[row][col] == 1){
                return false;
            }
            row -=1;
            col +=1;
        }
        return true;
    }
}
