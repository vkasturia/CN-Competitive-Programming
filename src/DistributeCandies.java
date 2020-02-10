import java.util.Arrays;
import java.util.Scanner;

public class DistributeCandies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int iterations = in.nextInt();

        while (iterations > 0) {
            int boxes = in.nextInt();
            long students = in.nextInt();

            long[] candiesInBox = new long[boxes];
            for (int i = 0; i < boxes; i++) {
                candiesInBox[i] = in.nextInt();
            }

            Arrays.sort(candiesInBox);
            long minCandies = 0;
            long maxCandies = candiesInBox[boxes - 1];

            long ans = -1;

            while (minCandies <= maxCandies) {
                long mid = minCandies + (maxCandies - minCandies) / 2;

                if (check(students, candiesInBox, boxes, mid)) {
                    ans = mid;
                    minCandies = mid + 1;
                } else {
                    maxCandies = mid - 1;
                }

            }
            System.out.println(ans);
            iterations--;
        }
    }

    static boolean check(long students, long[] candiesInBox,int boxes,long mid){

        long countStudents = 0;
        for(int i = 0; i < boxes; i++){
            long studentsGotCandies = candiesInBox[i] / mid;

            countStudents += studentsGotCandies;

            if(countStudents >= students){
                return true;
            }
        }
        return false;
    }
}