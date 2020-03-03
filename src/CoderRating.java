import java.util.Arrays;
import java.util.Scanner;

public class CoderRating {
    public static int[] bit = new int[100001];

    public static void update(int y){
        for( ; y<=100000; y +=  y & (-y)){
            bit[y]++;
        }
    }

    public static int query(int y){
        int value = 0;
        for( ; y>0; y-= y&(-y)){
            value += bit[y];
        }
        return value;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Coder[] arr = new Coder[n];

        for(int i=0;i<n;i++){
            arr[i] = new Coder(in.nextInt(), in.nextInt(), i);
        }

        Arrays.sort(arr);

        int[] ans = new int[n];

        for(int i=0;i<n;){
            int endIndex = i;

            while(endIndex < n && arr[endIndex].x == arr[i].x && arr[endIndex].y == arr[i].y){
                endIndex++;
            }
            // query

            for(int j=i; j<endIndex; j++){
                ans[arr[j].index] = query(arr[j].y);
            }

            for(int j=i;j<endIndex;j++){
                update(arr[j].y);
            }

            i = endIndex;
        }

        for(int i=0;i<n;i++){
            System.out.println(ans[i]);
        }
    }

}

class Coder implements Comparable<Coder>{
    int x;
    int y;
    int index;

    public Coder(int x, int y, int index){
        this.x = x;
        this.y = y;
        this.index = index;
    }

    @Override
    public int compareTo(Coder o) {
        int a = x-o.x;
        if(a==0) {
            int b = y-o.y;
            return b;
        }
        return a;
    }
}