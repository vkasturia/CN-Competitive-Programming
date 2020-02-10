import java.io.*;
import java.util.*;

public class LoveForChars {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        char[] charArray = new char[a];
        charArray = line.toCharArray();
        HashMap<Character, Integer> char_count_map = new HashMap<Character, Integer>();

        char_count_map.put('a', 0);
        char_count_map.put('s', 0);
        char_count_map.put('p', 0);
        for (Character x : charArray){
            if (x == 'a'){
                    int i = char_count_map.get('a');
                    i++;
                    char_count_map.put(x, i);
            }
            else if (x.equals('s')){
                    int i = char_count_map.get('s');
                    i++;
                    char_count_map.put(x, i);
            }

            else if (x.equals('p')){
                    int i = char_count_map.get('p');
                    i++;
                    char_count_map.put(x, i);
            }
        }
        System.out.print(char_count_map.get('a') + " " + char_count_map.get('s') + " " + char_count_map.get('p'));

    }
}