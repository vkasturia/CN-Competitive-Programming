import java.util.Scanner;

public class SachinAndVarun {
    class Triplet{
        public long x = 0;
        public long y = 0;
        public long gcd = 0;
    }

    public Triplet extendedEuclid(long a, long b){
        if (b==0){
            Triplet ans = new Triplet();
            ans.gcd = a;
            ans.x = 1;
            ans.y = 0;
            return ans;
        }
        Triplet smallAns = extendedEuclid(b, a%b);
        Triplet ans = new Triplet();
        ans.gcd = smallAns.gcd;
        ans.x = smallAns.y;
        ans.y = smallAns.x - (a/b)*smallAns.y;
        return ans;
    }

    public static long mmInverse(long a, long m){
        SachinAndVarun sv = new SachinAndVarun();
        Triplet ans = sv.extendedEuclid(a, m);
        return (ans.x % m + m) % m;
    }

    public static long gcd(long a, long b){
        if (a < b){
            return gcd(b,a);
        }
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        while (testCases > 0){
            long a, b, d;
            a = in.nextLong();
            b = in.nextLong();
            d = in.nextLong();
            long g = gcd(a, b);

            if (d%g != 0){
                System.out.println(0);
                testCases--;
                continue;
            }

            if (d == 0){
                System.out.println(1);
                testCases--;
                continue;
            }

            a = a/g;
            b = b/g;
            d = d/g;

            long y1 = ((d%a) * mmInverse(b, a)) % a;
            long firstValue = d/b;
            if (d < y1*b){
                System.out.println(0);
                continue;
            }

            long n = (firstValue - y1)%a;
            long ans = n+1;
            System.out.println(ans);
            testCases--;
        }
    }
}
