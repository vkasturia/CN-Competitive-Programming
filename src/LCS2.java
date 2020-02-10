import java.util.*;

public class LCS2 {
    public static void main(String[] args){
        //int n = 20;
        int[] arr = new int[]{693, 697, 299, 662, 290, 288, 925, 234, 257, 192, 687, 144, 142, 710, 66, 955, 321, 629, 989, 621};
        int n = 10;
        //int[] arr = new int[]{3, 7, 2, 1, 9, 8, 1};
        List<Integer> arrList = new LinkedList<>();
        ArrayList<Integer> lcs = new ArrayList<>();
        int max_length = 0;
        int max_start = arr[0];
        Map<Integer, Boolean> num_numCheck_map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            num_numCheck_map.put(arr[i], true);
            arrList.add(arr[i]);
        }
        int begin = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (num_numCheck_map.get(arr[i])){
                num_numCheck_map.put(arr[i], false);
                int start = arr[i];
                int max = 1;
                int j = i;
                while (num_numCheck_map.containsKey(start+1)){
                    start = start +1;
                    num_numCheck_map.put(start, false);
                    max++;
                }
                start = arr[i];
                while (num_numCheck_map.containsKey(start - 1)){
                    start -= 1;
                    num_numCheck_map.put(start, false);
                    max++;
                }
                if (max_length <= max){
                    if (max_length == max) {
                        int a = arrList.indexOf(max_start);
                        int b = arrList.indexOf(start);
                        if (a > b) {
                            max_length = max;
                            max_start = start;
                        }
                    }
                    else {
                        max_length = max;
                        max_start = start;
                    }
                }
            }
        }
        for (int i = max_start; i < max_start + max_length; i++){
            lcs.add(i);
            System.out.println(i);
        }

    }
}
