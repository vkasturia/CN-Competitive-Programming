import java.util.Scanner;

public class MomosMarket {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int shops = in.nextInt();
        long[] costAtShop = new long[shops];

        for (int i = 0; i < shops; i++){
            costAtShop[i] = in.nextInt();
        }

        int days = in.nextInt();
        long[] savingsPerDay = new long[days];

        for (int i = 0; i < days; i++){
            savingsPerDay[i] = in.nextInt();
        }

        long[] prefixSumArray = new long[shops];
        prefixSumArray[0] = costAtShop[0];

        for (int i = 1; i < shops; i++){
            prefixSumArray[i] = costAtShop[i] + prefixSumArray[i-1];
        }

        for (int i = 0; i < days; i++){
            int index = binarySearch(prefixSumArray, savingsPerDay[i]);
            if (index != -1) {
                long savingsAfterMomos = savingsPerDay[i] - prefixSumArray[index];
                System.out.println(index + 1 + " " + savingsAfterMomos);
            }
            else{
                System.out.println(0 + " " + savingsPerDay[i]);
            }
        }
    }

    public static int binarySearch(long[] prefixSumArray, long savings){
        int low = 0;
        int high = prefixSumArray.length - 1;
        if (savings <= prefixSumArray[0]) {
            return -1;
        }
        if (savings == prefixSumArray[0]) {
            return 0;
        }
        if (savings > prefixSumArray[high]) {
            return high;
        }

        while (low  <  high-1) {
            int mid = low + (high - low) / 2 ;
            if (prefixSumArray[mid] <= savings) {
                low = mid;
            }else {
                high = mid - 1;
            }
        }
        return prefixSumArray[high] <= savings ? high : low;
    }
}
