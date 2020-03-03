import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        boolean[] primeNumber = new boolean[n+1];
        for (int i = 2; i <=n; i++){
            primeNumber[i] = true;
        }
        for (int i = 2; i*i <=n; i++){
            if (primeNumber[i])
                markPrimes(i, n, primeNumber);
        }
        for(int i=1; i <=n; i++){
            if(primeNumber[i])
                count++;
        }
        System.out.println(count);
    }
    public static void markPrimes(int i, int n, boolean[] primeNumber){
        for (int j = i*i; j <= n; j+=i){
            primeNumber[j] = false;
        }
    }
}
