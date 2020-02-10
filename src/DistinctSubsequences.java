import java.util.Arrays;
import java.util.Scanner;

public class DistinctSubsequences {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int iterations = in.nextInt();
        while (iterations > 0){
            String line = in.nextLine();
            System.out.println(distinctSubsequences(line));
            iterations--;
        }
    }
    public static int distinctSubsequences(String S) {
        int MOD = 1000000007;
        int N = S.length();
        S = S.toLowerCase();
        int[] dp = new int[N+1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < N; ++i) {
            int x = S.charAt(i) - 'a';
            dp[i+1] = dp[i] * 2 % MOD;
            if (last[x] >= 0)
                dp[i+1] -= dp[last[x]];
            dp[i+1] %= MOD;
            last[x] = i;
        }

        dp[N]--;
        if (dp[N] < 0) dp[N] += MOD;
        return dp[N];
    }
}
