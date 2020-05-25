import java.util.HashSet;
import java.util.Scanner;

public class CalculateGrundyNumber {
    public static int calculateMex(HashSet<Integer> Set) {
        int Mex = 0;
        while (Set.contains(Mex)) {
            Mex++;
        }
        return (Mex);
    }

    public static int calculateGrundy(int n) {
        if (n == 0) {
            return (0);
        }

        HashSet<Integer> Set = new HashSet<Integer>();
        Set.add(calculateGrundy(n / 2));
        Set.add(calculateGrundy(n / 3));
        Set.add(calculateGrundy(n / 6));
        return (calculateMex(Set));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(calculateGrundy(n));
    }
}
