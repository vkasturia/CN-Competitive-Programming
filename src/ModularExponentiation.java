public class ModularExponentiation {
    public static void main(String[] args){
        int a = 2;
        int b = 10;
        int c = 5;
        System.out.println(modularExponentiation(a, b, c));
    }

    public static int modularExponentiation(int a, int b, int c){
        if (a == 0){
            return 0;
        }
        if (b == 0){
            return 1;
        }

        long ans;
        if ((b%2) == 0){
            long smallAns = modularExponentiation(a, b/2, c);
            ans = (smallAns*smallAns) % c;
        }
        else {
            long smallAns = modularExponentiation(a, b-1, c);
            ans = (a%c);
            ans = (ans*smallAns)%c;
        }
        return (int) ((ans + c) % c);
    }
}
