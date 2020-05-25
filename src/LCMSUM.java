import java.util.Arrays;
import java.util.Scanner;

public class LCMSUM {
    public static int[] eulerPhi(int n){
        int[] phi = new int[n+1];
        for (int i = 1; i <= n; i++){
            phi[i] = i;
        }
        for(int i = 2; i <= n; i++){
            if (phi[i] == i){
                phi[i] = i-1;
                for (int j = 2*i; j <=n; j+= i){
                    phi[j] = (phi[j]*(i-1))/i;
                }
            }
        }
        return phi;
    }

    public static boolean[] divisors(int n) {
        boolean[] divisors = new boolean[n+1];
        Arrays.fill(divisors, false);
        for (int i=1;i<=n;i++) {
            if (n % i == 0)
                divisors[i] = true;
        }
        return divisors;
    }

    public static long sum(int[] phi, boolean[] divisors, int n){
        long sum = 0;
        for (int i = 1; i <= n; i++){
            if (divisors[i]){
                sum += (phi[i] * i);
            }
        }
        sum += 1;
        sum *= n;
        sum = sum/2;
        return sum;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] phi = eulerPhi(n);
        boolean[] divisors = divisors(n);
        long ans = sum(phi, divisors, n);
        System.out.println(ans);
    }
}
