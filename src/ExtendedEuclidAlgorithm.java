public class ExtendedEuclidAlgorithm {
    class Triplet{
        public int x = 0;
        public int y = 0;
        public int gcd = 0;
    }

    public Triplet extendedEuclid(int a, int b){
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

    public static void main(String[] args){
        int a = 15;
        int b = 10;
        ExtendedEuclidAlgorithm ex = new ExtendedEuclidAlgorithm();
        Triplet ans = ex.extendedEuclid(a, b);
        System.out.println(ans.gcd);
        System.out.println(ans.x);
        System.out.println(ans.y);
    }
}
