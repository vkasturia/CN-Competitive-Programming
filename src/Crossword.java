import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Crossword {

    static int index = 0;
    static Map<String, String> word_boolean_map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Character[][] crossword = new Character[10][10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                char x = (char) System.in.read();
                if (x != '\n')
                    crossword[i][j] = x;
                else
                    crossword[i][j] = (char) System.in.read();
            }
        }
        in.nextLine();
        String line = in.nextLine();
        String[] words = line.split(";");
        crosswordSolver(crossword, words);
    }

    public static boolean crosswordSolver(Character[][] crossword, String[] words){
        if (index == words.length){
            printCrossword(crossword);
            return true;
        }
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10; j++) {
                if (crossword[i][j] == '-' || crossword[i][j] == words[index].charAt(0)) {
                    if (isValidVertical(crossword, words[index], i , j)){
                        setVertical(crossword, words[index], i , j);
                        if (!crosswordSolver(crossword, words)) {
                            index--;
                            resetVertical(crossword, words[index], i, j);
                        }
                    }
                    if(isValidHorizontal(crossword, words[index], i, j)){
                        setHorizontal(crossword, words[index], i, j);
                        if (!crosswordSolver(crossword, words)) {
                            index--;
                            resetHorizontal(crossword, words[index], i, j);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void printCrossword(Character[][] crossword){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                System.out.print(crossword[i][j]);
            }
            System.out.println();
        }
    }

    public static void setVertical(Character[][] crossword, String word, int i, int j){
        int count = 0;
        String minusAtPlace = "";
        while(i < 10 && j < 10 && count < word.length() && (crossword[i][j] == '-' || crossword[i][j] == word.charAt(count))){
            if (crossword[i][j] == '-'){
                minusAtPlace += "T";
                crossword[i][j] = word.charAt(count);
            }
            else{
                minusAtPlace += "F";
            }
            count++;
            j++;
        }
        word_boolean_map.put(word, minusAtPlace);
        index++;
    }

    public static void resetVertical(Character[][] crossword, String word, int i, int j){
        String minusAtPlace = word_boolean_map.get(word);
        for (int k = 0; k < word.length(); k++){
            if (minusAtPlace.charAt(k) == 'T'){
                crossword[i][j] = '-';
            }
            j++;
        }
        index--;
    }

    public static void resetHorizontal(Character[][] crossword, String word, int i, int j){
        String minusAtPlace = word_boolean_map.get(word);
        for (int k = 0; k < word.length(); k++){
            if (minusAtPlace.charAt(k) == 'T'){
                crossword[i][j] = '-';
            }
            i++;
        }
        index--;
    }

    public static void setHorizontal(Character[][] crossword, String word, int i, int j){
        int count = 0;
        String minusAtPlace = "";
        while(i < 10 && j < 10 && count < word.length() && (crossword[i][j] == '-' || crossword[i][j] == word.charAt(count))){
            if (crossword[i][j] == '-'){
                minusAtPlace += "T";
                crossword[i][j] = word.charAt(count);
            }
            else{
                minusAtPlace += "F";
            }
            count++;
            i++;
        }
        word_boolean_map.put(word, minusAtPlace);
        index++;
    }

    public static boolean isValidVertical(Character[][] crossword, String word, int i, int j){
        int count = 0;

        while (count < word.length() && (crossword[i][j] == '-' || crossword[i][j] == word.charAt(count))){
            count += 1;
            j++;
        }


        if (count == word.length()){
            return true;
        }
        return false;
    }

    public static boolean isValidHorizontal(Character[][] crossword, String word, int i, int j){
        int count = 0;

        while (count < word.length() && (crossword[i][j] == '-' || crossword[i][j] == word.charAt(count))) {
            count += 1;
            i++;
        }

        if (count == word.length()){
            return true;
        }
        return false;
    }
}
