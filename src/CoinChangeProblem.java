public class CoinChangeProblem {
    public static int countWaysToMakeChange(int denominations[], int value){

        /*Your class should be named Solution.
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Don’t print output, instead return it.
         */
        int n = value;
        int numD = denominations.length;
        int[][] output = new int[n+1][numD+1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= numD; j++){
                output[i][j] = -1;
            }
        }
        return coin_change(value, denominations, denominations.length, output);
    }

    public static int coin_change(int n, int[] d, int numD, int[][] output) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (numD == 0) {
            return 0;
        }
        if (output[n][numD] > -1) {
            return output[n][numD];
        }
        int first = coin_change(n - d[0], d, numD, output);
        int[] d2 = new int[d.length-1];

        for (int i = 1; i < d.length; i++){
            d2[i-1] = d[i];
        }

        int second = coin_change(n, d2, numD - 1, output);
        output[n][numD] = first + second;
        return first + second;
    }

    public static void main(String[] args) {
        int[] d = {1,2};
        int n = 4;
        int numD = d.length;
        int[][] output = new int[n+1][numD+1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= numD; j++){
                output[i][j] = -1;
            }
        }
        System.out.println(coin_change(4, d, 2, output));
    }
}
