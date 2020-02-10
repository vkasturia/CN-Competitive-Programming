public class InversionCount {
    public static void main(String[] args){
        int[] arr = new int[]{5 , 4, 3, 2, 1};
        long invCount = solve (arr, arr.length);
        System.out.println(invCount);
    }

    public static long solve (int[] A, int n){
        long answer = merge_sort(A, 0, n-1);
        return answer;
    }

    static long merge_sort(int[] A, int left, int right){
        long count = 0;
        if (right > left){
            int mid = (left + right) / 2;
            long countLeft = merge_sort(A, left, mid);
            long countRight = merge_sort(A, mid+1, right);
            long countBoth = merge(A, left, mid+1, right);
            return countBoth + countLeft + countRight;
        }
        return count;
    }

    static long merge(int[] A, int left, int mid, int right){
        int i = left;
        int j = mid;
        int k = 0;
        int[] temp = new int[right - left + 1];
        long count = 0;
        while (i < mid && j <= right){
                if (A[i] <= A[j]){
                    temp[k] = A[i];
                    k++;
                    i++;
                }
                else{
                    temp[k] = A[j];
                    k++;
                    j++;
                    count += mid - i;
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
        return count;
    }

}
