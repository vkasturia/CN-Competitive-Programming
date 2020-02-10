import java.util.Scanner;

public class BalikaVadhu {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int iterations = in.nextInt();
        while (iterations > 0){
            in.nextLine();
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            int k = in.nextInt();
            if (lcs2(s1, s2) >= k)
                System.out.println(blessingsScore(s1, s2, k));
            else
                System.out.println(0);
            iterations--;
        }
    }
    public static int blessingsScore(String s1, String s2, int k){
        int m = s1.length();
        int n = s2.length();
        int[][][] dp = new int[m+1][n+1][k+1];
        for (int i = 0; i < m+1; i++){
            for (int j = 0; j < n+1; j++){
                for (int z = 0; z < k+1; z++) {
                    dp[i][j][z] = -1;
                }
            }
        }
        return blessingsScoreHelper(s1, s2, m , n, k, dp);
    }

    public static int blessingsScoreHelper(String s1, String s2, int m, int n, int k, int[][][] dp){
        if (s1.isEmpty() || s2.isEmpty()){
            return 0;
        }
        if (k == 0){
            return 0;
        }

        if (dp[m][n][k] > -1){
            return dp[m][n][k];
        }
        else {
            if (s1.charAt(0) == s2.charAt(0)) {
                int option1 = (int) s1.charAt(0) + blessingsScoreHelper(s1.substring(1), s2.substring(1), m-1, n-1, k-1, dp);
                int option2 = blessingsScoreHelper(s1, s2.substring(1), m, n-1, k, dp);
                int option3 = blessingsScoreHelper(s1.substring(1), s2, m-1, n, k, dp);
                dp[m][n][k] = Math.max(option1, Math.max(option2, option3));
                return dp[m][n][k];
            } else {
                int option1 = blessingsScoreHelper(s1, s2.substring(1), m, n-1, k, dp);
                int option2 = blessingsScoreHelper(s1.substring(1), s2, m-1, n, k, dp);
                dp[m][n][k] = Math.max(option1, option2);
                return dp[m][n][k];
            }
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
}
