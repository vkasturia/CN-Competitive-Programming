import java.util.Scanner;

public class Boredom {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(solve(n, arr));
    }
    public static int solve(int n, int[] arr){
        int[] freq = new int[1001];
        for (int i = 0; i < n; i++){
            int x = arr[i];
            freq[x] = freq[x] + 1;
        }
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = Math.max(freq[1], 0);

        for (int i = 2; i < 1001; i++) {
            dp[i] = Math.max(dp[i - 2] + i*freq[i], dp[i-1]);
        }
        return dp[1000];
    }
}
