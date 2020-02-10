import java.util.Scanner;

public class LootHouses {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(getMaxMoney(arr, n));
    }

    public static int getMaxMoney(int[] arr, int n){
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++){
            dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
}
