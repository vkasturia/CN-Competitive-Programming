import java.util.HashMap;
import java.util.Map;

public class KeypadCode {
    public static void main(String[] args){
        int n = 23;
        String[] result = keypad(n);
        for(String s: result){
            System.out.println(s);
        }
    }

    public static String[] keypad(int n){
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
            if (inputNumber.charAt(0) == '7' || inputNumber.charAt(0) == '9'){
                String[] output = new String[4];
                output[0] = Character.toString(keypadString.charAt(0));
                output[1] = Character.toString(keypadString.charAt(1));
                output[2] = Character.toString(keypadString.charAt(2));
                output[3] = Character.toString(keypadString.charAt(3));
                return output;
            }
            else {
                String[] output = new String[3];
                output[0] = Character.toString(keypadString.charAt(0));
                output[1] = Character.toString(keypadString.charAt(1));
                output[2] = Character.toString(keypadString.charAt(2));
                return output;
            }
        }

        else {
            int elements = (int) Math.pow(inputNumber.length(), 4);
            String[] output = new String[elements];
            int count = combinations(inputNumber, output, number_string_map);
            String[] new_output = new String[count];
            for (int i = 0; i < count; i++){
                new_output[i] = output[i];
            }
            return new_output;
        }
    }
    public static int combinations(String inputNumber, String[] output, Map<Character, String> numberMap){
        if (inputNumber.equals("")){
           output[0] = "";
           return 1;
        }
        String smallString = inputNumber.substring(1);
        int smallOutputSize = combinations(smallString, output, numberMap);

        char character = inputNumber.charAt(0);
        String keypadString = numberMap.get(character);


        String[] temp = new String[smallOutputSize];
        for (int i = 0; i < smallOutputSize; i++){
            temp[i] = output[i];
        }

            int j = 0;
            for (int i = 0; i < smallOutputSize; i++){
                if (keypadString.length() == 3) {
                    output[j] = keypadString.charAt(0) + temp[i];
                    output[j + 1] = keypadString.charAt(1) + temp[i];
                    output[j + 2] = keypadString.charAt(2) + temp[i];
                    j = j+3;
                }

                if (keypadString.length() == 4) {
                    output[j] = keypadString.charAt(0) + temp[i];
                    output[j + 1] = keypadString.charAt(1) + temp[i];
                    output[j + 2] = keypadString.charAt(2) + temp[i];
                    output[j + 3] = keypadString.charAt(3) + temp[i];
                    j = j+4;
                }
        }

        if (keypadString.length() == 4) {
            return 4 * smallOutputSize;
        } else{
            return 3 * smallOutputSize;
        }
    }
}
