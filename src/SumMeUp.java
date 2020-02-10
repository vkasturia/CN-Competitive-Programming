import java.math.BigInteger;
import java.util.Scanner;

public class SumMeUp {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger a = BigInteger.valueOf(10);
        for (int i = 0; i < n; i++){
            BigInteger sum = BigInteger.ZERO;
            BigInteger x = in.nextBigInteger();
            while (x.compareTo(BigInteger.ZERO)>0){
                BigInteger y = x.mod(a);
                sum = sum.add(y);
                x = x.divide(a);
            }
            System.out.println(sum);
            in.nextLine();
        }
    }
}
