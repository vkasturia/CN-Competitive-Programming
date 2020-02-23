import java.util.Scanner;

public class ZAlgorithm {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String text = "abcdsafbcdfasbcda";
        String pattern = "bcd";
        searchString(text, pattern);
    }

    public static void searchString(String text, String pattern){
        String str = pattern + "$" + text;
        int n = str.length();
        int[] Z = new int[n];
        buildZ(Z, str);
        for (int i = 0; i < n; i++){
            if (Z[i] == pattern.length()){
                System.out.println(i-pattern.length()-1);
            }
        }
    }
    public static void buildZ(int[] Z, String str){
        int l = 0;
        int r = 0;
        int n = str.length();
        for (int i = 1; i < n; i++){
           if(i > r) {
               l = i;
               r = i;
               while (r < n && str.charAt(r - l) == str.charAt(r)) {
                   r++;
               }
               Z[i] = r - l;
               r--;
           } else{
               int k = i-l;
               if(Z[k] <= r-i){
                   Z[i] = Z[k];
               }else{
                   l=i;
                   while(r < n && str.charAt(r-l) == str.charAt(r)){
                       r++;
                   }
                   Z[i] = r-l;
                   r--;
               }
           }
        }
    }
}
