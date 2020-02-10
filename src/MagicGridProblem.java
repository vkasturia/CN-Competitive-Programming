import java.util.Scanner;

public class MagicGridProblem {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        while (testCases > 0){
            int rows = in.nextInt();
            int cols = in.nextInt();
            int[][] grid = new int[rows][cols];
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    grid[i][j] = in.nextInt();
                }
            }
            int cost = min_cost(grid, rows, cols);
            testCases--;
        }
    }
    public static int min_cost(int[][] input, int m, int n) {
        int[][] dp = new int[m][n];

        dp[m - 1][n-1] = Math.max(input[m-1][n-1], 1);

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n -1] = Math.max(dp[i + 1][n-1] - input[i][n-1], 1);
        }

        for (int j = n - 2; j >=0; j--) {
            dp[m -1][j] = Math.max(dp[m - 1][j + 1] - input[m-1][j], 1);
        }

        for (int i = m - 2; i >=0; i--) {
            for (int j = n - 2; j >=0 ; j--) {
                int min_points =  Math.min(dp[i+1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(min_points - input[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
