public class MergeSort {
    public static void main(String[] args){
        int[] arr = new int[]{2, 6, 8, 5, 4, 3};
        mergeSort(arr);
        for (int i  = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
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
