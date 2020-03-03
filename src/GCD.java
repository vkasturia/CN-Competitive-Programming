import java.util.Scanner;

public class GCD {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(gcd(a,b));
    }
    public static int gcd(int a, int b){
        if (a < b){
            return gcd(b,a);
        }
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}
