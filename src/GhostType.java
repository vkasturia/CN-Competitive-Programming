import java.util.Arrays;
import java.util.Scanner;

public class GhostType {
    static int n;
    static long[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dp = new long[1<<n];
        Arrays.fill(dp, -1);

        for(int i=0 ; i<n ; i++){
            dp[1<<i]=1;
        }

        System.out.println(go((1<<n)-1));
    }

    public static long go(int mask){
        long res=0;
        if (dp[mask] != -1)
            return dp[mask];

        boolean flag=true;
        for( int i=1 ; i<=n ; i++ ){
            flag=true;
            if( (mask&(1<<(i-1)))!=0 ){
                for( int j=1 ; j<=n ; j++ ){
                    if( i!=j && (mask&(1<<(j-1)))!=0 && (i&j)==j ){
                        flag=false;
                        break;
                    }
                }
                if( flag ){
                    res+=go(mask-(1<<(i-1)) );
                }
            }

        }
        dp[mask]=res;
        return res;
    }
}
