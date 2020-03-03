import java.util.Scanner;

class SUBXOR {
    static int maxSubarrayXOR(int arr[], int n, int k) {
        int count = 0;
        for (int i=0; i<n; i++) {
            int curr_xor = 0;
            for (int j=i; j<n; j++)  {
                curr_xor = curr_xor ^ arr[j];
                if (k > curr_xor){
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        while (testCases > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(maxSubarrayXOR(arr, n, k));
            testCases--;
        }
    }
}