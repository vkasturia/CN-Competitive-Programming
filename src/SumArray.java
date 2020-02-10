import java.util.*;

public class SumArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int[][] arr = new int[n][n];
        int sumDiagonal = 0;
        int sumBoundaries = 0;
        for (int i = 0; i < n; i++){
        	int j = 0;
        	while (in.hasNext()) {
                if (j != n) {
                	if (in.hasNextInt()) {
                		arr[i][j] = in.nextInt();
                		j += 1;
                	}
                	else 
                		in.next();
            	}
        		else {
        			break;
        		}
        	}
        }
        for (int i=0; i < n; i++) {
        	for (int j=0; j<n; j++) {
        		if (i==j) {
        			sumDiagonal += arr[i][j];
        		}
        		if ((n-1-i)==j) {
        			sumDiagonal += arr[i][j];
        		}
        	}
        }
        
        if (n%2 ==1){
            int[] list = new int[arr.length*arr[0].length];
            int listPos = 0;
            for(int i = 0 ; i < arr.length; i++) {
                for(int j = 0; j < arr[i].length; j++) {
                    list[listPos++] = arr[i][j];
                }
            }
        
            int middle = list.length/2;
            sumDiagonal -= list[middle];
        }
        
        for (int j=1; j<n-1; j++) {
        	sumBoundaries += arr[0][j] + arr[n-1][j];
        }
        
        for (int i=1; i<n-1; i++) {
        	sumBoundaries += arr[i][0] + arr[i][n-1];
        }
        
        System.out.println(sumDiagonal+sumBoundaries);
	}
}