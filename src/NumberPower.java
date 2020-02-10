import java.util.Scanner;

public class NumberPower {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int n = in.nextInt();
        System.out.println(power(a,n));
    }

    public static int power (int a, int n){
        if (n == 1){
            return a;
        }
        return a * power(a, n-1);
    }
}
