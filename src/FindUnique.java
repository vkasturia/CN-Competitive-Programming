import java.util.Arrays;

public class FindUnique {
    public static int findUnique(int[] arr) {
        int length = arr.length;
        Arrays.sort(arr);
        if (arr[1] != arr[0]){
            return arr[0];
        }
        else {
            for (int i = 2; i < length-1; i+=2){
                if (!(arr[i] == arr[i-1] || arr[i] == arr[i+1]))
                    return arr[i];
            }
        }
        return arr[length-1];
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 1, 6, 2, 3, 3};
        System.out.println(findUnique(arr));
    }
}
