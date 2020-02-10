import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WarmReception {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String[] arrivalTimes = line1.split("\\s");
        String[] departureTimes = line2.split("\\s");

        int[] arrivalTimeArray = new int[n];
        int[] departureTimeArray = new int[n];
        Map<Integer, Integer> time_count_map = new LinkedHashMap<>();

        for (int i =0; i < n; i++){
            int length = arrivalTimes[i].length();
            int length2 = departureTimes[i].length();
            if (length <=2)
                arrivalTimeArray[i] = Integer.parseInt(arrivalTimes[i]);
            else
                arrivalTimeArray[i] = Integer.parseInt(arrivalTimes[i].substring(0, length - 2)) * 60 + Integer.parseInt(arrivalTimes[i].substring(length-2, length));
            if(length2 <=2){
                departureTimeArray[i] = Integer.parseInt(departureTimes[i]);
            }
            else {
                departureTimeArray[i] = Integer.parseInt(departureTimes[i].substring(0, length2 - 2)) * 60 + Integer.parseInt(departureTimes[i].substring(length2 - 2, length2));
            }
        }
        for (int i = 0; i <= 1440; i+=30){
            time_count_map.put(i, 0);
        }
        for (int i = 0; i <= 1440; i+=30){
            for (int j =0; j < n; j++){
                if (i >= arrivalTimeArray[j] && i <= departureTimeArray[j]){
                    time_count_map.put(i, time_count_map.get(i) + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= 1440; i+=30){
            if (time_count_map.get(i) > max){
                max = time_count_map.get(i);
            }
        }
        System.out.print(max);
    }
}
