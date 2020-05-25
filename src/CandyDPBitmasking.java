import java.util.Scanner;

public class CandyDPBitmasking {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] like = new int[n][n];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                like[i][j] = in.nextInt();
            }
        }
        System.out.println(possibleWaysIterative(like, n));
    }

    public static long possibleWaysIterative(int[][] like, int n){
        long[] dp = new long[1<<n];
        for(int i = 0; i <(1<<n); i++){
            dp[i] = 0;
        }
        dp[0] = 1;
        for (int mask = 0; mask < ((1<<n)-1); mask++){
            int temp = mask;
            int k = 0;
            while(temp > 0){
                if ((temp % 2) == 1){
                    k++;
                }
                temp = temp/2;
            }
            for(int j = 0; j < n; j++){
                if ((mask & (1<<j)) == 0 && like[k][j] == 1){
                    dp[mask|(1<<j)] += dp[mask];
                }
            }
        }
        return dp[(1<<n) - 1];
    }
}
