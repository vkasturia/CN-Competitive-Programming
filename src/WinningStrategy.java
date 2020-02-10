import java.util.Scanner;

public class WinningStrategy {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        int totalSwaps = 0;

        for (int i = n-1; i >=2; i--){
            if (arr[i] != (i+1)){
                if (arr[i-1] == (i+1)){
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    totalSwaps += 1;
                }
                else if (arr[i-2] == (i+1)){
                    int temp = arr[i-1];
                    arr[i-1] = arr[i-2];
                    arr[i-2] = temp;
                    temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                    totalSwaps += 2;
                }
                else{
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (arr[1] != 2){
            if (arr[0] == 2)
                totalSwaps += 1;
            else {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");
        System.out.println(totalSwaps);
    }
}
