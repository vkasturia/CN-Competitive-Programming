import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DivisorsOfFactorial {
    public static int MAX = 500001;
    public static long MOD = 1000000007;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        List<Integer> primeNumberList = new ArrayList<>();
        boolean[] primeNumber = new boolean[MAX+1];
        for (int i = 2; i <=MAX; i++){
            primeNumber[i] = true;
        }
        for (int i = 2; i*i <=MAX; i++){
            if (primeNumber[i])
                markPrimes(i, primeNumber);
        }
        primeNumberList.add(2);
        for(int i=3; i <=MAX; i+=2){
            if(primeNumber[i])
                primeNumberList.add(i);
        }

        int testCases = in.nextInt();
        while(testCases > 0){
            int n = in.nextInt();
            System.out.println(divisors(n, primeNumberList));
            testCases--;
        }
    }

    public static long divisors(int n, List<Integer> primeNumbersList){
        long result = 1;
        for (int i = 0; primeNumbersList.get(i) <= n; i++){
            int k = primeNumbersList.get(i);
            long count = 0;
            while ((n/k) != 0){
                count = (count + (n/k))% MOD;
                k = k*primeNumbersList.get(i);
            }
            result = result * ((count + 1)%MOD)%MOD;
        }
        return result;
    }
    public static void markPrimes(int i, boolean[] primeNumber){
        for (int j = i*i; j <= MAX; j+=i){
            primeNumber[j] = false;
        }
    }
}
