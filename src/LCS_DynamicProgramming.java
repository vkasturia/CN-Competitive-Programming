public class LCS_DynamicProgramming {
    public static void main(String[] args){
        String s1 = "abcdefg";
        String s2 = "b1d3ffg";
        System.out.println(lcsIterative(s1, s2));
    }

    public static int lcs(String s1, String s2){
        if (s1.isEmpty() || s2.isEmpty()){
            return 0;
        }
        if (s1.charAt(0) == s2.charAt(0)){
            return 1 + lcs(s1.substring(1), s2.substring(1));
        }
        else{
            int option1 = lcs(s1, s2.substring(1));
            int option2 = lcs(s1.substring(1), s2);
            return Math.max(option1, option2);
        }
    }

    public static int lcs2(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++){
            for (int j = 0; j < n+1; j++){
                dp[i][j] = -1;
            }
        }
        return lcs2Helper(s1, s2, m , n, dp);
    }

    public static int lcs2Helper(String s1, String s2, int m, int n, int[][] dp){
        if (s1.isEmpty() || s2.isEmpty()){
            return 0;
        }
        if (dp[m][n] > -1){
            return dp[m][n];
        }
        else {
            if (s1.charAt(0) == s2.charAt(0)) {
                dp[m][n] = 1 + lcs2Helper(s1.substring(1), s2.substring(1), m-1, n-1, dp);
                return dp[m][n];
            } else {
                int option1 = lcs2Helper(s1, s2.substring(1), m, n-1, dp);
                int option2 = lcs2Helper(s1.substring(1), s2, m-1, n, dp);
                dp[m][n] = Math.max(option1, option2);
                return dp[m][n];
            }
        }
    }

    public static int lcsIterative(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++){
            for (int j = 0; j < n+1; j++){
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i <= m; i++){
            dp[i][0] = 0;
        }
        for (int j = 0; j <=n; j++){
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <=n; j++){
                if (s1.charAt(m-i) == s2.charAt(n-j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int ans = dp[m][n];
        return ans;
    }
}
