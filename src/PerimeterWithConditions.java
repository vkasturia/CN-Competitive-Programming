import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PerimeterWithConditions {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextLong();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        long max = 0;
        int j = 0;
        for (int i = 0; i < n-2; i++){
            if (arr[i] < arr[i+1] + arr[i+2]){
                max = Math.max(max, arr[i] + arr[i+1] + arr[i+2]);
                j = i;
                break;
            }
        }
        if (max > 0)
            System.out.println(arr[j+2] + " " + arr[j+1] + " " + arr[j]);
        else
            System.out.println(-1);
    }
}
