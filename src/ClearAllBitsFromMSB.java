import java.util.Scanner;

public class ClearAllBitsFromMSB {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int i = in.nextInt();
        for (int j = 31; j >= i; j--){
            N = N & ~(1 << j);
        }
        System.out.println(N);
    }
}
