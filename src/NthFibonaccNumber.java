public class NthFibonaccNumber {
    public static void main(String[] args){
        System.out.println(getFibonacci(8));
    }

    public static int getFibonacci(int n){
        int[][] A = {{1, 1}, {1, 0}};
        if (n == 0){
            return 0;
        }
        power(A, n-1);
        return A[0][0];
    }

    public static void power(int[][] A, int n){
        if (n==0 || n==1){
            return;
        }

        power(A, n/2);
        multiply(A, A);

        if (n%2 != 0){
            int[][] M = {{1, 1}, {1, 0}};
            multiply(A, M);
        }
    }

    public static void multiply(int[][] A, int[][] M){
        int firstValue = A[0][0]*M[0][0] + A[0][1]* M[1][0];
        int secondValue = A[0][0]*M[0][1] + A[0][1]* M[1][1];
        int thirdValue = A[1][0]*M[0][0] + A[1][1]* M[1][0];
        int fourthValue = A[1][0]*M[0][1] + A[1][1]* M[1][1];
        A[0][0] = firstValue;
        A[0][1] = secondValue;
        A[1][0] = thirdValue;
        A[1][1] = fourthValue;
    }
}
