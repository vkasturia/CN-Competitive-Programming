import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairSum {
    public static void main(String[] args){
        int size = 6;
        int input[] = {2, 1, -2, 2, 3, -2};
        Set<Integer> numSet = new HashSet<>();
        Map<Integer, Integer> num_numCount_map = new HashMap<>();
        for (int i = 0; i < input.length; i++){
            if (num_numCount_map.containsKey(input[i])){
                num_numCount_map.put(input[i], num_numCount_map.get(input[i]) + 1);
            }
            else{
                num_numCount_map.put(input[i], 1);
            }
            numSet.add(input[i]);
        }
        for(Integer i : numSet){
            if (num_numCount_map.containsKey(i*-1)){
                int a = num_numCount_map.get(i);
                int b = num_numCount_map.get(i*-1);
                int counter =  a * b;
                for (int j = 0; j < counter; j++){
                    if (i < 0)
                        System.out.println(i + " " + i*-1);
                    else
                        System.out.println(i*-1 + " " + i);
                }
                num_numCount_map.put(i, 0);
                num_numCount_map.put(i*-1, 0);
            }
        }
    }
}
