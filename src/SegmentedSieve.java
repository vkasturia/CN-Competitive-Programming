import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SegmentedSieve {
    public static int MAX = 100001;
    public static void main(String[] args){
        List<Integer> primes = sieve();
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        while (testCases > 0){
            long l = in.nextLong();
            long r = in.nextLong();
            printPrimes (l, r, primes);
            testCases--;
        }
    }
    public static List<Integer> sieve(){
        boolean[] isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);
        for (int i = 2; i*i <MAX; i++){
            if (isPrime[i]){
                for (int j = i*i; j < MAX; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i < MAX; i+=2){
            if (isPrime[i]){
                primes.add(i);
            }
        }
        return primes;
    }
    public static void printPrimes(long l, long r, List<Integer> primes){
        boolean[] isPrime = new boolean[(int)r- (int)l+1];
        Arrays.fill(isPrime, true);
        for(int i=0; primes.get(i)*(long)primes.get(i) <= r; i++){
            int currPrime = primes.get(i);
            long base = (l/(currPrime))*(currPrime);
            if(base < l){
                base = base + currPrime;
            }

            for(long j = base; j<=r; j+= currPrime){
                isPrime[(int)j- (int)l] = false;
            }

            if(base == currPrime){
                isPrime[(int) base- (int)l] = true;
            }
        }

        for(int i=0; i<=r-l; i++){
            if(isPrime[i] == true){
                System.out.println(i + l);
            }
        }
    }
}
