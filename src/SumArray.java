/**
Sum Array

Given a 2-d square matrix of order ‘N’, find the sum of elements of both diagonals and all boundaries elements. Boundary elements refer to the elements present on all the four boundaries of matrix.

Input format:
First line will have a single integer ‘N' denoting the order of matrix. 
Next ‘N’ lines will have ‘N’ space separated integers each denoting the elements of matrix.

Output format:
Print a single integer denoting the sum.

Constraints:
0 <= N <= 10^4

Sample input 1:
3
1 2 3
4 5 6
7 8 9

Sample Output 1:
45

Sample input 2:
5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25

Sample Output 2:
273
**/

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