import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++){
            weight[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            value[i] = in.nextInt();
        }
        int maxWeight = in.nextInt();
        System.out.println(knapsackIterative(weight, value, maxWeight));
    }

    public static int knapsack(int[] weight, int[] value, int maxWeight){
        int n = weight.length;
        int[][] dp = new int[n+1][maxWeight+1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= maxWeight; j++){
                dp[i][j] = -1;
            }
        }
        return knapsackHelper(n, weight, value, maxWeight, dp);
    }

    public static int knapsackHelper(int n, int[] weight, int[] value, int maxWeight, int [][] dp){
        if (maxWeight == 0 || n == 0){
            return 0;
        }

        if (dp[n][maxWeight] > -1){
            return dp[n][maxWeight];
        }

        if (weight[n-1] <= maxWeight){
            int option1 = value[n-1] + knapsackHelper(n-1, weight, value, maxWeight - weight[n-1], dp);
            int option2 = knapsackHelper(n-1, weight, value, maxWeight, dp);
            dp[n][maxWeight] = Math.max(option1, option2);
            return dp[n][maxWeight];
        }
        else{
            dp[n][maxWeight] = knapsackHelper(n-1, weight, value, maxWeight, dp);
            return dp[n][maxWeight];
        }
    }

    public static int knapsackIterative(int[] weight, int[] value, int maxWeight){
        int n = weight.length;
        int[][] dp = new int [n+1][maxWeight+1];
        for (int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }
        for (int j = 0; j < maxWeight+1; j++){
            dp[0][j] = 0;
        }
        for (int i = 1; i < n+1; i++){
            for (int w = 0; w < maxWeight + 1; w++){
                dp[i][w] = dp[i-1][w];
                if (weight[i-1] <= w){
                    dp[i][w] = Math.max(dp[i][w],value[i-1] + dp[i-1][w-weight[i-1]]);
                }
            }
        }
        return dp[n][maxWeight];
    }
}
