import java.util.HashMap;
import java.util.Map;

public class KeypadCombinationsCode {
    public static void main(String[] args){
        int n = 7;
        printKeypad(n);
    }

    public static void printKeypad(int n){
        Map<Character, String> number_string_map = new HashMap<>();
        number_string_map.put('2', "abc");
        number_string_map.put('3', "def");
        number_string_map.put('4', "ghi");
        number_string_map.put('5', "jkl");
        number_string_map.put('6', "mno");
        number_string_map.put('7', "pqrs");
        number_string_map.put('8', "tuv");
        number_string_map.put('9', "wxyz");

        String inputNumber = String.valueOf(n);
        if(inputNumber.length() == 1){
            String keypadString = number_string_map.get(inputNumber.charAt(0));
            System.out.println(Character.toString(keypadString.charAt(0)));
            System.out.println(Character.toString(keypadString.charAt(1)));
            System.out.println(Character.toString(keypadString.charAt(2)));
            if (inputNumber.charAt(0) == '7' || inputNumber.charAt(0) == '9'){
                System.out.println(Character.toString(keypadString.charAt(3)));
            }
        }

        else {
            String output = "";
            combinations(inputNumber, output, number_string_map);
        }
    }

    public static void combinations(String input, String output, Map<Character, String> numberMap) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        char character = input.charAt(0);
        String keypadString = numberMap.get(character);

        combinations(input.substring(1), output + keypadString.charAt(0), numberMap);
        combinations(input.substring(1), output + keypadString.charAt(1), numberMap);
        combinations(input.substring(1), output + keypadString.charAt(2), numberMap);
        if (keypadString.length() == 4) {
            combinations(input.substring(1), output + keypadString.charAt(3), numberMap);
        }
    }
}
