import java.util.*;

public class PRE4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int[] updated_arr = new int[n/2];
		int j = 0;        
        while (in.hasNext()) {
            if (in.hasNextInt()){
                arr[j] = in.nextInt();
                j += 1;
            }    
            else 
                in.next();
        }
        
        for (int i = 0; i < arr.length/2; i++){
            updated_arr[i] = arr[i] + arr[n-i-1];
        }
        
        for (int i = 0; i < updated_arr.length; i++){
            System.out.println(updated_arr[i]/10 + " " + updated_arr[i]%10);
        }
	}
}