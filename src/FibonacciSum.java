import java.util.Scanner;

public class FibonacciSum {
    public static int MOD = 1000000007;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long ans = (getFibonacci(m+2) - getFibonacci(n+1) + MOD) % MOD;
        System.out.println(ans);
    }

    public static long getFibonacci(long n){
        long[][] A = {{1, 1}, {1, 0}};
        if (n == 0){
            return 0;
        }
        power(A, n-1);
        return A[0][0];
    }

    public static void power(long[][] A, long n){
        if (n==0 || n==1){
            return;
        }

        power(A, n/2);
        multiply(A, A);

        if (n%2 != 0){
            long[][] M = {{1, 1}, {1, 0}};
            multiply(A, M);
        }
    }

    public static void multiply(long[][] A, long[][] M){
        long firstValue = A[0][0]*M[0][0] + A[0][1]* M[1][0];
        long secondValue = A[0][0]*M[0][1] + A[0][1]* M[1][1];
        long thirdValue = A[1][0]*M[0][0] + A[1][1]* M[1][0];
        long fourthValue = A[1][0]*M[0][1] + A[1][1]* M[1][1];
        A[0][0] = firstValue;
        A[0][1] = secondValue;
        A[1][0] = thirdValue;
        A[1][1] = fourthValue;
    }
}
