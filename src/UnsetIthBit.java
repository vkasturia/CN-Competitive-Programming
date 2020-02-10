import java.util.Scanner;

public class UnsetIthBit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int i = in.nextInt();
        N = N & ~(1 << i);
        System.out.println(N);
    }
}
