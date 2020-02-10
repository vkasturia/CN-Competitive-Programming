import java.util.Scanner;

public class FirstSetBit {
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
                System.out.println((int) Math.pow(2, i));
                break;
            }
            i+=1;
        }
    }
}
