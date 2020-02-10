import java.util.Arrays;

public class ArrayRotate {

    public static int[] rotate(int[] arr, int d) {
        int length = arr.length;
        int[] b = new int[length];
        for (int i = 0; i < length; i++) {
            b[i] = arr[i];
        }
        for (int i = 0; i < length; i++) {
            if (i - d < 0) {
                arr[length - d + i] = b[i];
            } else {
                arr[i - d] = b[i];
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        int[] b = rotate(arr, d);
        System.out.println(Arrays.toString(b));
    }

}

