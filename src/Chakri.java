import java.util.*;

public class Chakri {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
		int[] arr = new int[n];
        
        int j = 0;        
        while (in.hasNext()) {
            if (in.hasNextInt()){
                arr[j] = in.nextInt();
                j += 1;
            }    
            else 
                in.next();
        }
        
        int lowest = arr[0];
        int lowest_index = 0;
        int highest = 0;
        
        for (int i = 1; i < arr.length; i++) {
        	if (arr[i] < lowest) {
        		lowest = arr[i];
        		lowest_index = i;
        		highest = arr[i];
        	}
        }
        
        for (int i = lowest_index; i < arr.length; i++) {
        	if (arr[i] > highest) {
        		highest = arr[i];
        	}
        }
        
        System.out.println(highest-lowest);
	}
}