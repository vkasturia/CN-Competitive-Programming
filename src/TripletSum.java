import java.util.Arrays;

public class TripletSum {
    public static void main(String[] args){
        int n = 7;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7 };
        int sum = 12;
        findTriplet(arr, sum);
    }
    public static void findTriplet(int[] arr, int sum){
        Arrays.sort(arr);
        int length = arr.length;
        for (int i = 0; i < length-2; i++){
            for (int j = i+1; j < length-1; j++){
                for (int k= j+1; k< length; k++){
                    if (arr[i] + arr[j] + arr[k] == sum)
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                }
            }
        }
    }
}
