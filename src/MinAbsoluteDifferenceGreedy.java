import java.util.Arrays;
import java.util.Scanner;

public class MinAbsoluteDifferenceGreedy {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(minAbsoluteDiff(arr));
    }

    public static int minAbsoluteDiff(int[] arr){
        int minDiff = Integer.MAX_VALUE;
        mergeSort(arr);
        for (int i = 1; i < arr.length; i++){
            int diff = arr[i] - arr[i-1];
            if (minDiff > diff){
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public static void mergeSort(int[] input){
        int startIndex = 0;
        int endIndex = input.length - 1;
        mergeSortWithIndices(input, startIndex, endIndex);
    }

    public static void mergeSortWithIndices(int[] input, int startIndex, int endIndex){
        if (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            mergeSortWithIndices(input, startIndex, mid);
            mergeSortWithIndices(input, mid + 1, endIndex);
            merge(input, startIndex, mid, endIndex);
        }
    }

    public static void merge(int[] input, int startIndex, int mid, int endIndex){
        int n1 = mid - startIndex + 1;
        int n2 = endIndex - mid;

        int left[] = new int [n1];
        int right[] = new int [n2];

        for (int i=0; i<n1; ++i) {
            left[i] = input[startIndex + i];
        }

        for (int j=0; j<n2; ++j) {
            right[j] = input[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int[] temp = new int[endIndex-startIndex+1];
        int k = 0;
        while (i < n1 && j < n2){
            if (left[i] < right[j]){
                temp[k] = left[i];
                k++;
                i++;
            }
            else{
                temp[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < n1){
            temp[k] = left[i];
            k++;
            i++;
        }
        while(j < n2){
            temp[k] = right[j];
            k++;
            j++;
        }
        for (int z = startIndex, v = 0; z <= endIndex; z++, v++) {
            input[z] = temp[v];
        }
    }

}
