import java.util.Arrays;
import java.util.Scanner;

public class MehtaAndBankRobbery {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int W = in.nextInt();
        Paar[] items = new Paar[n];
        for (int i = 0; i < n; i++){
            items[i] = new Paar(in.nextLong(), in.nextLong());
        }
        Arrays.sort(items);
        long[][][] dp = new long[2][n+1][W+1];
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < W; k++){
                    dp[i][j][k] = 0;
                }
            }
        }

        int[] primes = {1, 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29};

        for (int i = 1; i <= n; i++){
            for(int j =1; j <= W; j++){
                dp[0][i][j] = dp[0][i-1][j];
                if (j >= items[i-1].weight){
                    dp[0][i][j] = Math.max(dp[0][i][j], dp[0][i-1][j-(int) items[i-1].weight] + items[i-1].value);
                }
            }
        }
        for (int prime = 1; prime <= 10; prime++){
            int p = prime % 2;
            for (int i = 1; i <=n; i++){
                for(int j =1; j <= W; j++){
                    dp[p][i][j] = dp[p][i-1][j];
                    if (j >= items[i-1].weight){
                        dp[p][i][j] = Math.max(dp[p][i][j], Math.max(dp[p][i-1][j-(int) items[i-1].weight] + items[i-1].value, dp[p^1][i-1][j-(int) items[i-1].weight] + items[i-1].value * primes[prime]));
                    }
                }
            }
        }
        System.out.println(dp[0][n][W]);
    }
}
class Paar implements Comparable<Paar>{
    long weight;
    long value;
    public Paar(long weight, long value){
        this.weight = weight;
        this.value = value;
    }
    @Override
    public int compareTo(Paar o) {
        long x = weight-o.weight;
        if(x==0) {
            x = value - o.value;
        }
        return (int) x;
    }
}

