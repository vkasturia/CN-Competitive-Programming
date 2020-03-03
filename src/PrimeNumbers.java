import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        for (int i = 2; i <= n; i++){
            boolean prime = isPrime(i);
            if(prime)
                count++;
        }
        System.out.println(count);
    }
    public static boolean isPrime(int n){
        int count = 0;
        for (int i = 1; i * i <= n; i++){
            if (n % i == 0){
                if (i * i == n){
                    count += 1;
                }
                else{
                    count += 2;
                }
            }
        }
        if (count == 2){
            return true;
        }
        else{
            return false;
        }
    }
}
