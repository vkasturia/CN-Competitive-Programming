public class MinimumJobCostDPBitmasking {
    public static void main(String[] args){
        int[][] cost = {{10,2,6,5}, {1,15,12,8}, {7,8,9,3}, {15,13,4,10}};
        int[] dp = new int[1<<4];
        for(int i = 0; i < (1<<4); i++){
            dp[i] = Integer.MAX_VALUE;
        }
        System.out.println(minCostIterative(cost, 4));
        System.out.println(minCost(cost, 4, 0, 0, dp));
        System.out.println(dp[0]);
    }
    public static int minCost(int[][] cost, int n, int p, int mask, int[] dp){
        if (p >= n){
            return 0;
        }
        if (dp[mask] != Integer.MAX_VALUE)
            return dp[mask];

        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++){
            if((mask & (1<<j)) == 0) {
                int ans = minCost(cost, n, p + 1, mask | (1 << j), dp) + cost[p][j];
                if (ans < minimum) {
                    minimum = ans;
                }
            }
        }
        dp[mask] = minimum;
        return minimum;
    }
    public static int minCostIterative(int[][] cost, int n){
        int[] dp = new int[1<<n];
        for(int i = 0; i <(1<<n); i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int mask = 0; mask < ((1<<n)-1); mask++){
            int temp = mask;
            int k = 0;
            while(temp > 0){
                if ((temp % 2) == 1){
                    k++;
                }
                temp = temp/2;
            }
            for(int j = 0; j < n; j++){
                if ((mask & (1<<j)) == 0){
                    dp[mask|(1<<j)] = Math.min(dp[mask|(1<<j)], dp[mask] + cost[k][j]);
                }
            }
        }
        return dp[(1<<n) - 1];
    }
}
