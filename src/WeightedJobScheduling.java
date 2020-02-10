import java.util.*;


class Job implements Comparable<Job>{
    int start;
    int finish;
    int profit;

    Job(int start, int finish, int profit) {
        this.start = start ;
        this.finish = finish;
        this.profit = profit;
    }

    @Override
    public int compareTo(Job o) {
        int x=finish-o.finish;
        return x;
    }
};

class WeightedJobScheduling {
    public static void main(String args[] ) {
        MyScanner scan = new MyScanner();
        int N = scan.nextInt();
        Job[] jobs=new Job[N];
        for (int i = 0; i < N; i++) {
            jobs[i] = new Job(scan.nextInt(),scan.nextInt(),scan.nextInt());
        }
        Arrays.sort(jobs);
        System.out.println(findMaxProfitBinarySearch(jobs, N));
    }

    public static int findMaxProfit(Job[] jobs, int N){
       int[] dp = new int[N];
       dp[0] = jobs[0].profit;

       for (int i = 1; i < N; i++){
           int including = jobs[i].profit;
           int lastNonConflicting = -1;

           for (int j = i-1; j >= 0; j--){
               if (jobs[j].finish <= jobs[i].start){
                   lastNonConflicting = j;
                   break;
               }
           }
           if (lastNonConflicting != -1){
               including += dp[lastNonConflicting];
           }
           dp[i] = Math.max(including, dp[i-1]);
       }
       return dp[N-1];
    }

    public static int findMaxProfitBinarySearch(Job[] jobs, int N){
        int[] dp = new int[N];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < N; i++){
            int including = jobs[i].profit;
            int lastNonConflicting = -1;

            lastNonConflicting = binarySearch(jobs, i);

            if (lastNonConflicting != -1){
                including += dp[lastNonConflicting];
            }
            dp[i] = Math.max(including, dp[i-1]);
        }
        return dp[N-1];
    }

    public static int binarySearch(Job jobs[], int index) {
        int lo = 0, hi = index - 1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (jobs[mid].finish <= jobs[index].start)
            {
                if (jobs[mid + 1].finish <= jobs[index].start)
                    lo = mid + 1;
                else
                    return mid;
            }
            else
                hi = mid - 1;
        }
        return -1;
    }
}

