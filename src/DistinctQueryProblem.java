import java.util.Arrays;
import java.util.Scanner;

public class DistinctQueryProblem {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++){
            arr[i] = in.nextInt();
        }
        int q = in.nextInt();
        Event[] query = new Event[q];
        for (int i = 0; i < q; i++){
            query[i] = new Event(in.nextInt(), in.nextInt(), i);
        }
        Arrays.sort(query);
        int[] BIT = new int[n+1];
        int[] ans = new int[q];

        int total = 0;
        int k = 0;
        int[] last = new int[1000001];
        for (int i = 0; i <=1000000; i++){
            last[i] = -1;
        }
        for (int i = 1; i <=n; i++){
            if (last[arr[i]] != -1){
                update(last[arr[i]], -1, n, BIT);
            }else{
                total++;
            }
            update(i, 1, n, BIT);
            last[arr[i]] = i;
            while(k < q && query[k].second == i){
                ans[query[k].index] = total - value(query[k].first -1, BIT);
            }
        }
        for(int i = 0; i < q; i++){
            System.out.println(ans[i]);
        }
    }
    public static void update(int index, int value, int n, int[] BIT){
        for (; index <= n; index += (index & (-index))){
            BIT[index] += value;
        }
    }
    public static int value(int index, int[] BIT){
        int count = 0;
        for (; index > 0; index -= (index & (-index))){
            count += BIT[index];
        }
        return count;
    }
}

class Event implements Comparable<Event>{
    int first;
    int second;
    int index;

    public Event(int first, int second, int index){
        this.first = first;
        this.second = second;
        this.index = index;
    }

    @Override
    public int compareTo(Event event) {
        return second - event.second;
    }
}