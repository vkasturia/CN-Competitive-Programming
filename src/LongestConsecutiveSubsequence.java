import java.util.*;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args){
        int n = 20;
        //int[] arr = new int[]{3, 7, 2, 1, 9, 8, 1};
        int[] arr = new int[]{693, 697, 299, 662, 290, 288, 925, 234, 257, 192, 687, 144, 142, 710, 66, 955, 321, 629, 989, 621};
        int b = arr[0];
        LinkedList<Integer> arrList = new LinkedList(Arrays.asList(arr));
        Arrays.sort(arr);
        List<Set<Integer>> listOfSet = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++){
            boolean inserted = false;
            for (int j = 0; j < listOfSet.size(); j++){
                set = listOfSet.get(j);
                if (set.contains(arr[i]-1)) {
                    set.add(arr[i]);
                    inserted = true;
                    break;
                }
            }
            if (!inserted){
                set = new TreeSet<>();
                set.add(arr[i]);
                listOfSet.add(set);
            }
        }
        int max = 0;
        ArrayList<Integer> maxList = new ArrayList<>();
        if (listOfSet.size() == n){
            maxList = new ArrayList<>(Arrays.asList(b));
            for(int i = 0; i < maxList.size(); i++){
                System.out.println(maxList.get(i));
            }
            return;
        }
        for (int i = 0; i < listOfSet.size(); i++){
            int setSize = listOfSet.get(i).size();
            ArrayList<Integer> newList = new ArrayList<>(listOfSet.get(i));
            if (setSize > max){
                max = setSize;
                maxList = newList;
            }
            else if (setSize == max){
                int maxListIndex = arrList.indexOf(maxList.get(0));
                int newListIndex = arrList.indexOf(newList.get(0));
                if (maxListIndex > newListIndex)
                    maxList = newList;
            }
        }
        for(int i = 0; i < maxList.size(); i++){
            System.out.println(maxList.get(i));
        }
    }
}
