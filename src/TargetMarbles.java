import java.util.*;

public class TargetMarbles {
	public static void main(String[] args) {
		boolean flag = true;        
		int n = 0; 
		int z = 0;
		int target = 0;
		
		Scanner in = new Scanner(System.in);
        String line;
        line = in.nextLine(); 
        String[] numbers = line.split(" ");
        n = Integer.parseInt(numbers[0]);
        target = Integer.parseInt(numbers[1]);
        
        int[] arr = new int[n];
		int j = 0;
		line = in.nextLine();
		String[] sequence = line.split(" ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(sequence[i]);
		}

        int sum = 0;
        boolean found = false;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n ; i++) {
        	int k = i;
            start = i;
            sum = 0;
        	while (k < n && sum < target) {
        		sum += arr[k];
        		if (sum == target) {
        			found = true;
                    end = k;
        			break;
        		}
        		k+=1;
        	}
        	if (found) {
        		break;
        	}
        }
        if (found) {
        	System.out.println(found);
        	for (int x = start; x <= end; x++) {
        		System.out.print(arr[x]+" ");       		
        	}
        }
        else{
            System.out.println(found);
        }
	}
}


	