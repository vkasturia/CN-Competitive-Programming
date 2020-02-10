import java.util.*;
import java.io.*;

public class EvenOddIndexes {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
		int[] arr = new int[n];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strs = line.split("\\s");

        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]%2==0 && i%2==0){
                evenSum += arr[i];
            }
            if (arr[i]%2==1 && i%2==1){
                oddSum += arr[i];
            }
        }
        System.out.println(evenSum + " " + oddSum);
	}
}