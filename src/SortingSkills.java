import java.util.Scanner;

public class SortingSkills {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        while (testcases > 0){
            int arraysize = in.nextInt();
            int[] arr = new int[arraysize];
            for (int i = 0; i < arraysize; i++){
                arr[i] = in.nextInt();
            }
            for(int i = 0; i < arraysize-1; i++){
                if (arr[i+1] == arr[i] - 1){
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
            boolean sorted = true;
            for(int i = 0; i < arraysize-1; i++) {
                if (arr[i+1] < arr[i])
                    sorted = false;
            }
            if (!sorted){
                System.out.println("No");
            }
            else{
                System.out.println("Yes");
            }
            testcases--;
        }

    }
}
