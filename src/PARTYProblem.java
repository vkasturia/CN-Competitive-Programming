import java.util.Scanner;

public class PARTYProblem {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int maxWeight = in.nextInt();
        int n = in.nextInt();
        int[] value = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++){
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
        }
        System.out.println(knapsack(weight, value, maxWeight));
        System.out.println(knapsack2(weight, value, 26));
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

    public static int knapsack2(int[] weight, int[] value, int maxValue){
        int n = weight.length;
        int[][] dp = new int[n+1][maxValue+1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= maxValue; j++){
                dp[i][j] = -1;
            }
        }
        return knapsackHelper2(n, weight, value, maxValue, dp);
    }

    public static int knapsackHelper2(int n, int[] weight, int[] value, int maxValue, int [][] dp){
        if (maxValue == 0 || n == 0){
            return 0;
        }

        if (dp[n][maxValue] > -1){
            return dp[n][maxValue];
        }

        if (value[n-1] <= maxValue){
            int option1 = weight[n-1] + knapsackHelper2(n-1, weight, value, maxValue - value[n-1], dp);
            int option2 = knapsackHelper2(n-1, weight, value, maxValue, dp);
            dp[n][maxValue] = Math.max(option1, option2);
            return dp[n][maxValue];
        }
        else{
            dp[n][maxValue] = knapsackHelper2(n-1, weight, value, maxValue, dp);
            return dp[n][maxValue];
        }
    }
}
