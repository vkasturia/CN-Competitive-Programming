import java.util.Scanner;

public class StringSearchKMP {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine().replaceAll("\\s+", "");
        String pattern = in.nextLine().replaceAll("\\s+", "");
        System.out.println(kmpSearch(inputString, pattern));
    }
    public static int[] getLongestPrefixSuffix(String pattern){
        int length = pattern.length();
        int[] lps = new int[length];
        lps[0] = 0;
        int j = 0;
        int i = 1;
        while (i < length){
            if (pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }
            else{
                if(j!=0){
                    j = lps[j-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static int kmpSearch(String text, String pattern){
        int textLength = text.length();
        int patternLength = pattern.length();

        int[] lps = getLongestPrefixSuffix(pattern);
        int i = 0;
        int j = 0;
        while (i < textLength && j < patternLength){
            if (text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            else{
                if (j!=0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        if (j==patternLength){
            return i-patternLength;
        }
        return -1;
    }
}
