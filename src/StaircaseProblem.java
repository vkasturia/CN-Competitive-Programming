import java.util.Scanner;

public class StaircaseProblem {
    public static long possibleWays(int n, long[] arr) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2){
            return 2;
        }

        if (arr[n] > 0) {
            return arr[n];
        }

        long output = possibleWays(n - 1, arr) + possibleWays(n - 2, arr) + possibleWays(n-3, arr);
        arr[n] = output;
        return output;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n+1];
        long ans = possibleWays(n, arr);
        System.out.println(ans);
    }
}
