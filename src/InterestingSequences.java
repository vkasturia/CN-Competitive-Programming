import java.util.Scanner;

public class InterestingSequences {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int l = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
           arr[i] = in.nextInt();
        }

        int min = 1000000;
        int max = -1;

        for (int i = 0; i < n; i++){
            if (min > arr[i]){
                min = arr[i];
            }
            if (max < arr[i]){
                max = arr[i];
            }
        }

        if (min == max){
            System.out.println(0);
            return;
        }
        long minCost = 1000000000;

        for (int j = min; j <= max; j++){
            int decrease = 0;
            int increase = 0;
            int cost = 1000000;
            for (int i = 0; i < n; i++) {
                if (arr[i] > j) {
                    decrease += (arr[i] - j);
                }
                if (arr[i] < j) {
                    increase += (j - arr[i]);
                }


            }
            if (increase < decrease){
                continue;
            }
            else {
                cost = decrease * k + (increase - decrease) * l;
            }
            if (cost < minCost){
                minCost = cost;
            }
        }
        System.out.println(minCost);
    }
}
