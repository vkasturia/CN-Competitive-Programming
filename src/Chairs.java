import java.util.*;

public class Chairs {

    static int findChairs(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int chairs_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n)
        {
            if (arr[i] <= dep[j])
            {
                chairs_needed++;
                i++;

                if (chairs_needed > result)
                    result = chairs_needed;
            }

            else
            {
                chairs_needed--;
                j++;
            }
        }

        return result;
    }

    // Driver program to test methods of graph class
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String[] arrivalTimes = line1.split("\\s");
        String[] departureTimes = line2.split("\\s");

        int[] arr = new int[n];
        int[] dep = new int[n];

        for (int i =0; i < n; i++){
            arr[i] = Integer.parseInt(arrivalTimes[i]);
            dep[i] = Integer.parseInt(departureTimes[i]);
        }

        System.out.println(findChairs(arr, dep, n));
    }
}
