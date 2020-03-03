import java.util.Scanner;

public class FenwickTree {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n+1];
        int[] BIT = new int[n+1];
        for (int i = 1; i <= n; i++){
            arr[i] = in.nextInt();
            update(i, arr[i], BIT, n);
        }
        System.out.println("Sum of first five elements " + query(5, BIT));
        System.out.println("Sum of first elements from 2 index to 6 index" + (query(6, BIT) - query(1, BIT)));
    }

    public static void update(int index, int value, int[] BIT, int n){
        for(; index <= n; index += index & (-index)){
            BIT[index] += value;
        }
    }

    public static int query(int index, int[] BIT){
        int sum = 0;
        for(; index > 0; index -= index & (-index)){
            sum += BIT[index];
        }
        return sum;
    }
}
