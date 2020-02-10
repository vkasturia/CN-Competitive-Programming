public class QuickSort {
    public static void main(String[] args){
        int[] arr = new int[]{2, 6, 8, 5, 4, 3};
        quickSort(arr);
        for (int i  = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] input){
        int startIndex = 0;
        int endIndex = input.length - 1;
        quickSortWithIndices(input, startIndex, endIndex);
    }

    public static void quickSortWithIndices(int[] input, int startIndex, int endIndex){
        if (startIndex >= endIndex) {
            return;
        }
        int c = partition(input, startIndex, endIndex);
        quickSortWithIndices(input, startIndex, c - 1);
        quickSortWithIndices(input, c + 1, endIndex);
    }

    public static int partition(int[] input, int startIndex, int endIndex){
        int checkLower = 0;
        for (int j = startIndex + 1; j <= endIndex; j++){
            if (input[startIndex] > input[j]){
                checkLower++;
            }
        }
        int temp = input[startIndex + checkLower];
        input[startIndex + checkLower] = input[startIndex];
        input[startIndex] = temp;

        int i = startIndex;
        int j = endIndex;
        int x = startIndex + checkLower;
        while (i < x && j > x){
            if (input[i] > input[x] && input[j] < input[x]){
                temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
            else {
                if (input[j] > input[x]) {
                    j--;
                }

                if (input[i] < input[x]) {
                    i++;
                }
            }
        }
        return x;
    }
}
