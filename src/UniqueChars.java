import java.util.*;

public class UniqueChars {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Set<Character> characters = new LinkedHashSet<>();
        for(int i = 0; i < line.length(); i++) {
            characters.add(line.charAt(i));
        }
        for (Character a : characters){
            System.out.print(a);
        }
    }
}