import java.util.Scanner;

public class MinimumChocolates {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(getMin(arr, n));
    }
    public static int getMin(int[] arr, int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int min = 0;
        for (int i = 1; i < n; i++){
            if (arr[i] > arr[i - 1]){
                dp[i] = dp[i-1] + 1;
            }
            else{
                dp[i] = 1;
            }
        }
        for (int i = n-2; i >= 0; i--){
            if (arr[i] > arr[i+1] && dp[i] <= dp[i+1]){
                dp[i] = dp[i+1] + 1;
            }
        }
        for (int i=0; i < n; i++){
            min += dp[i];
        }
        return min;
    }
}
