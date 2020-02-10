import java.util.Arrays;
import java.util.Scanner;

public class NikunjAndDonuts {
    public static void main(String[] args){
        long ans = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int j = 0;
        for (int i = n-1; i >= 0; i--){
            ans += (Math.pow(2, j)*arr[i]);
            j++;
        }
        System.out.println(ans);
    }
}
