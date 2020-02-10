import java.util.Scanner;

public class ShortestSubsequence {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        System.out.println();
    }
    public static int shortestSeq(String S, String T) {
        int m = S.length(), n = T.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1005;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = S.charAt(i - 1);
                int k;
                for (k = j - 1; k >= 0; k--) {
                    if (T.charAt(k) == ch) {
                        break;
                    }
                }
                if (k == -1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][k] + 1);
                }
            }
        }

        int ans = dp[m][n];
        if (ans >= 1005) {
            ans = -1;
        }
        return ans;
    }
}
