import java.util.Scanner;

public class BalancedBT {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        System.out.println(balancedBTs(h));
    }

    public static int balancedBTs(int h){
        if (h == 0)
            return 1;
        if (h == 1)
            return 1;
        int m = 1000000000 + 7;
        int x = balancedBTs(h-1);
        int y = balancedBTs(h-2);

        long first = ((long) x * (long) x);
        long second = (long) (2 * (long) x * (long) y);
        int ans1 = (int)(first % m);
        int ans2 = (int)(second % m);
        return (ans1  + ans2) % m;
    }
}
