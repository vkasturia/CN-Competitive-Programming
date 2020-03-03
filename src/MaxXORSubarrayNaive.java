import java.util.Scanner;

class MaxXORSubarrayNaive {
    static int maxSubarrayXOR(int arr[], int n) {
        int ans = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            int curr_xor = 0;
            for (int j=i; j<n; j++)  {
                curr_xor = curr_xor ^ arr[j];
                ans = Math.max(ans, curr_xor);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(maxSubarrayXOR(arr, n));
    }
}