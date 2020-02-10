import java.util.Arrays;
import java.util.Scanner;

public class TajMahal {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] peopleStanding = new long[n];

        for (int i = 0; i < n; i++){
            peopleStanding[i] = in.nextInt();
        }

        long[] timeEnter = new long[n];

        for (int i = 0; i < n; i++){
            if (peopleStanding[i] - i >= 0) {
                long time = (peopleStanding[i] - i) / n;
                if ((peopleStanding[i] - i) % n != 0)
                    time = time + 1;
                timeEnter[i] = i + time * n;
            }
            else{
                long time = 0;
                timeEnter[i] = i;
            }
        }
        long min = 1000000;
        int minIndex = -1;
        for (int i = 0; i < n; i++){
            if (min > timeEnter[i]){
                min = timeEnter[i];
                minIndex = i;
            }
        }
        System.out.println(minIndex + 1);
    }
}
