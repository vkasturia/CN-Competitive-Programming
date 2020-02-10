public class EditDistance {
    public static void main(String[] args){
        String s1 = "kitten";
        String s2 = "sitting";
        System.out.println(editDistance(s1, s2));
    }
    public static int editDistance(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (s1.charAt(i-1) != s2.charAt(j-1))
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                else
                    dp[i][j] = Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
            }
        }
        return dp[m][n];
    }
}
