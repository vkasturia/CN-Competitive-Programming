import java.util.Scanner;

public class CountBSTs {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(countTrees(n));
    }
    public static int countTrees(int n){
        long[] dp = new long[n+1];
        long y = 1000000007;
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                long x = ((dp[i - j] % y) * (dp[j - 1]) % y) % y;
                dp[i] = (dp[i]%y + x%y) % y;
            }
        }
        return (int) dp[n];
    }
}
