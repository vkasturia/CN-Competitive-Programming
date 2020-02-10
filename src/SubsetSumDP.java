import java.util.Scanner;

public class SubsetSumDP {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] val = new int[n];
        for (int i = 0; i < n; i++){
            val[i] = in.nextInt();
        }
        int sum = in.nextInt();
        if (subsetSum(val, n, sum))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static boolean subsetSum(int[] val, int n, int sum){
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i <= sum; i++){
            dp[0][i] = false;
        }
        for (int i = 0; i <= n; i++){
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= sum; j++){
                dp[i][j] = dp [i-1][j];
                if (j >= val[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-val[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
