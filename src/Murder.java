import java.util.Scanner;

public class Murder {
    public static void main(String[] args){
        //int[] arr = new int[]{1, 3, 3, 6, 4};
        //long totalSum = solve (arr, arr.length);
        //System.out.println(totalSum);
        Scanner in = new Scanner(System.in);
        int iterations = in.nextInt();
        while (iterations > 0){
            int stairs = in.nextInt();
            int[] arr = new int[stairs];
            in.nextLine();
            String line = in.nextLine();
            String[] stringArr = line.split("\\s");
            for (int j = 0; j < stairs; j++){
                arr[j] = Integer.parseInt(stringArr[j]);
            }
            long totalSum = solve (arr, stairs);
            System.out.println(totalSum);
            iterations--;
        }
    }

    public static long solve (int[] A, int n){
        long answer = merge_sort(A, 0, n-1);
        return answer;
    }

    static long merge_sort(int[] A, int left, int right){
        long sum = 0;
        if (right > left){
            int mid = (left + right) / 2;
            long sumLeft = merge_sort(A, left, mid);
            long sumRight = merge_sort(A, mid+1, right);
            long sumBoth = merge(A, left, mid+1, right);
            return sumBoth + sumLeft + sumRight;
        }
        return sum;
    }

    static long merge(int[] A, int left, int mid, int right){
        int i = left;
        int j = mid;
        int k = 0;
        int[] temp = new int[right - left + 1];
        long sum = 0;
        while (i < mid && j <= right){
            if (A[i] < A[j]){
                temp[k] = A[i];
                sum += (right - j + 1) * A[i];
                k++;
                i++;
            }
            else{
                temp[k] = A[j];
                k++;
                j++;
            }
        }
        while (i < mid){
            temp[k] = A[i];
            k++;
            i++;
        }
        while (j <= right){
            temp[k] = A[j];
            j++;
            k++;
        }
        for (int z = left, v = 0; z <= right; z++, v++){
            A[z] = temp[v];
        }
        return sum;
    }
}
