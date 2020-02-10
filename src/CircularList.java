import java.util.Scanner;

public class CircularList {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] array = new int[12];
        for (int i = 0; i < 12; i++){
            array[i] = i;
        }
        long iterations = in.nextLong();
        while (iterations > 0){
            int start = in.nextInt();
            int position = in.nextInt();
            start = start % 12;
            int student = array[start];
            int end = (student + position) % 12;
            System.out.println(end);
            iterations--;
        }
    }
}
