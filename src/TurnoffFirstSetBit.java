import java.util.Scanner;

public class TurnoffFirstSetBit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        if (N == 0){
            System.out.println(0);
            return;
        }

        int i = 0;
        while (i > -1){
            if ((N & (1 << i)) != 0){
                N = N & ~(1 << i);
                System.out.println(N);
                break;
            }
            i+=1;
        }
    }
}
