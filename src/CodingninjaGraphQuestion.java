import java.util.Scanner;

public class CodingninjaGraphQuestion {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String desired = "CODINGNINJA";
        char[][] matrix = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        in.nextLine();
        for(int i = 0; i < n; i++){
                String line = in.nextLine();
                char[] charArray = line.toCharArray();
                for (int j = 0; j < m; j++){
                    matrix[i][j] = charArray[j];
                    visited[i][j] = false;
                }
        }
        boolean found = false;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix[i][j] == 'C'){
                    found = search (1, 'A', desired, matrix, visited, i, j, n, m);
                    if(found) {
                        System.out.println(1);
                        return;
                    }
                    for(int x = 0; x < n; x++){
                        for (int y = 0; y < m; y++){
                            visited[x][y] = false;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    public static boolean search(int secondIndex, char end, String desired, char[][] matrix, boolean[][] visited, int i, int j, int n, int m){
        if (matrix[i][j] == end){
            return true;
        }
        boolean found = false;

        if(i-1>=0 && j-1>=0 && matrix[i-1][j-1]==desired.charAt(secondIndex) && !visited[i-1][j-1])
            found = found || search(secondIndex+1,end, desired, matrix, visited, i-1,j-1,n,m);

        if(i-1>=0 && matrix[i-1][j]==desired.charAt(secondIndex) && !visited[i-1][j])
            found = found || search(secondIndex+1,end, desired, matrix, visited,i-1,j,n,m);

        if(i-1>=0 && j+1<m && matrix[i-1][j+1]== desired.charAt(secondIndex) && !visited[i-1][j+1])
            found = found || search(secondIndex+1,end, desired, matrix, visited,i-1,j+1,n,m);

        if(j+1<m && matrix[i][j+1]==desired.charAt(secondIndex) && !visited[i][j+1])
            found = found || search(secondIndex+1,end, desired, matrix, visited, i,j+1,n,m);

        if(i+1<n && j+1<m && matrix[i+1][j+1]==desired.charAt(secondIndex) && !visited[i+1][j+1])
            found = found || search(secondIndex+1,end, desired, matrix, visited,i+1,j+1,n,m);

        if(i+1<n && matrix[i+1][j]==desired.charAt(secondIndex) && !visited[i+1][j])
            found = found || search(secondIndex+1,end, desired, matrix, visited,i+1,j,n,m);

        if(i+1<n && j-1>=0 && matrix[i+1][j-1]==desired.charAt(secondIndex) && !visited[i+1][j-1])
            found = found || search(secondIndex+1,end, desired, matrix, visited,i+1,j-1,n,m);

        if(j-1>=0 && matrix[i][j-1]==desired.charAt(secondIndex) && !visited[i][j-1])
            found = found || search(secondIndex+1,end, desired, matrix, visited, i,j-1,n,m);

        return found;
    }
}
