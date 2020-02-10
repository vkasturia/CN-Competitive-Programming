import java.util.Scanner;

public class CollectingBalls {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long balls = in.nextLong();
        binarySearch(1, balls, balls);
    }

    public static void binarySearch(long low, long high, long balls){
        if (low  <=  high) {
            long mid = (low + high) / 2 ;

            long curr = balls;
            long sum = 0;

            while (curr > 0){
                sum += Math.min(mid, curr);
                curr = curr - mid;
                curr = curr - curr/10;
            }

            if (sum*2 < balls) {
                low = mid + 1;
                binarySearch(low, high, balls);
            }else {
                high = mid - 1;
                binarySearch(low, high, balls);
            }
        }
        else{
            long mid = (low + high) / 2 ;

            long curr = balls;
            long sum = 0;

            while (curr > 0){
                sum += Math.min(mid, curr);
                curr = curr - mid;
                curr = curr - curr/10;
            }

            if (sum*2 < balls) {
                System.out.println(low+1);
            }
            else{
                System.out.println(low);
            }
        }

    }
}