import java.util.Arrays;
import java.util.Scanner;

public class ProblemDiscussion {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long k = in.nextLong();
        Long[] arr = new Long[N];
        for (int i = 0; i < N; i++){
            arr[i] = in.nextLong();
        }
        Arrays.sort(arr);
        long answer = arr[N-1] - arr[0];
        long small = arr[0] + k;
        long big = arr[N-1] - k;

        if (small > big){
            long temp = small;
            small = big;
            big = temp;
        }

        for (int i = 1; i < N-1; i++){
            long subtract = arr[i] - k;
            long add = arr[i] + k;
            if (subtract >= small || add <= big){
                continue;
            }
            if (big - subtract <= add - small){
                small = subtract;
            }
            else{
                big = add;
            }
        }
        System.out.println(Math.min(answer, big - small));
    }
}
