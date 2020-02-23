import java.util.Scanner;

public class PalindromicSubstrings {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().replaceAll("\\s+", "");
        System.out.println(lps(s));
    }
    public static int lps(String s){
        int n = s.length();
        int x = 0;
        for (int i = 0; i < n; i++){
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                int curr_l = r-l+1;
                x++;
                l--;
                r++;
            }
            l = i;
            r = i+1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                int curr_l = r-l+1;
                x++;
                l--;
                r++;
            }
        }
        return x;
    }
}
