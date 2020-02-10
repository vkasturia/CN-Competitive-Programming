import java.util.Scanner;

public class MaxSquareWithAllZeros {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(findMaxSquareWithAllZeros(grid));
    }
    public static int findMaxSquareWithAllZeros(int[][] input){
        int rows = input.length;
        int cols = input[0].length;
        int max = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            if (input[i][0] == 0){
                dp[i][0] = 1;
                max = dp[i][0];
            }
            else{
                dp[i][0] = 0;
            }
        }
        for (int i = 0; i < cols; i++){
            if (input[0][i] == 0){
                dp[0][i] = 1;
                max = dp[0][i];

            }
            else{
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if (input[i][j] == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                else
                    dp[i][j] = 0;
                if (dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}
