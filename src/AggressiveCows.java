import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static int distance = 0;
    public static void calculateMinimumDistance(int startDistance, int endDistance, int cows, int[] shedIds){
        if (startDistance+1 <= endDistance) {
            int cowsToPlace = cows;

            int mid_distance = (startDistance + endDistance) / 2;
            int i = 0;
            while (i < shedIds.length) {
                int j = i + 1;
                while (j < shedIds.length) {
                    if ((shedIds[j] - shedIds[i]) >= mid_distance) {
                        cowsToPlace--;
                        i = j;
                    } else {
                        j = j + 1;
                    }
                }
                if (j == shedIds.length) {
                    i = shedIds.length;
                }
            }
            if (cowsToPlace == 1) {
                distance = mid_distance;
                calculateMinimumDistance(mid_distance, endDistance, cows, shedIds);
            } else {
                calculateMinimumDistance(startDistance, mid_distance, cows, shedIds);
            }
        }
        return;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int iterations = in.nextInt();
        while (iterations > 0) {
            in.nextLine();
            String a = in.nextLine();
            String[] arr = a.split("\\s");
            int sheds = Integer.parseInt(arr[0]);
            int[] shedIds = new int[sheds];
            int cows = Integer.parseInt(arr[1]);
            for (int i = 0; i < sheds; i++){
                shedIds[i] = in.nextInt();
            }
            Arrays.sort(shedIds);
            int min_distance = 0;
            int max_distance = shedIds[sheds-1] - shedIds[0];
            calculateMinimumDistance(min_distance, max_distance, cows, shedIds);
            System.out.println(distance);
            iterations--;
        }
    }
}
