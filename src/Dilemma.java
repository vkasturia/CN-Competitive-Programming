import java.util.Scanner;

public class Dilemma {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] input = new String[n];
        in.nextLine();
        for (int i = 0; i < n; i++){
            input[i] = in.nextLine().trim();
        }
        System.out.println(minimumTouchesRequired(n, input));
    }

    public static int minimumTouchesRequired(int n, String[] input){
        int[][] dp = new int[input[0].length()][1<<(n+1)];
        for (int i = 0; i < input[0].length(); i++){
            for (int j = 0; j < (1<<(n+1)); j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return findTouches(input[0].length() - 1, (1<<n)-1, input, dp);
    }

    public static int findTouches(int pos, int mask, String[] input, int[][] dp){
        if (((mask) & (mask-1)) == 0)
            return 0;

        if (pos < 0){
            return 10000;
        }
        if (dp[pos][mask] != Integer.MAX_VALUE){
            return dp[pos][mask];
        }

        int newmask1 = 0;
        int newmask2 = 0;
        int touches = 0;

        for (int i = 0; i < input.length; i++){
            if ((mask & (1<<i)) == 1) {
                touches++;
                if (input[i].charAt(pos) == '0') {
                    newmask1 |= 1<<i;
                }
                else {
                    newmask2 |= 1 << i;
                }
            }
        }
        int ans1 = findTouches(pos-1, newmask1, input, dp) + findTouches(pos-1, newmask2, input, dp) + touches;
        int ans2 = findTouches(pos-1, mask, input, dp);
        int ans = Math.min(ans1, ans2);
        dp[pos][mask] = ans;
        return ans;
    }
}
