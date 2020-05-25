import java.util.Scanner;

public class AdvancedGCD {
    private static int gcd(int reduceNum, int b) {
        return b == 0 ? reduceNum : gcd(b, reduceNum % b);
    }

    private static int reduceB(int a, String b) {
        int result = 0;
        for (int i = 0; i < b.length(); i++) {
            result = (result * 10 + b.charAt(i) - '0') % a;
        }
        return result;
    }

    private static int gcdLarge(int a, String b) {
        int num = reduceB(a, b);
        return gcd(num, a);
    }

    public static void main(String[] args) {
        //int a = 1221;
        //String b = "19837658191095787329";
        //System.out.println(gcdLarge(a, b));

        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        while(testCases > 0){
            int a = in.nextInt();
            String b = in.nextLine().trim();
            System.out.println(gcdLarge(a, b));
            testCases--;
        }
    }
}
