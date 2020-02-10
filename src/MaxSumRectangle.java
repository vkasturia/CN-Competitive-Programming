import java.util.Scanner;

public class MaxSumRectangle {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                grid[i][j] = in.nextInt();
            }
        }
        int maxSumRectangle = maxRectangle(grid, rows, cols);
        System.out.println(maxSumRectangle);
    }

    public static int maxRectangle(int[][] grid, int rows, int cols){
        int maxRectangleSum = -1000;

        int[] arr = new int[cols];

        for (int l = 0; l < rows; l++){
            for (int j = 0; j < cols; j++){
                arr[j] = grid[l][j];
            }
            int sum = maxSubArraySum(arr);
            if (sum > maxRectangleSum){
                maxRectangleSum = sum;
            }

            for (int r = l+1; r < rows; r++) {
                for (int j = 0; j < cols; j++) {
                    arr[j] += grid[r][j];
                }
                sum = maxSubArraySum(arr);
                if (sum > maxRectangleSum){
                    maxRectangleSum = sum;
                }
            }
        }
        return maxRectangleSum;
    }

    public static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}
