import java.util.Scanner;

public class LargestPiece {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] graph = new int [n][n];
        boolean[][] visited = new boolean [n][n];
        in.nextLine();
        for (int i = 0; i < n; i++){
            String line = in.nextLine();
            String[] digits = line.split("");
            for (int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(digits[j]);
                visited[i][j] = false;
            }
        }
        int ans = largestPieceSize(graph, visited, n);
        System.out.println(ans);
    }

    public static int largestPieceSize(int[][] graph, boolean[][] visited, int n){
        int maxSize = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (!visited[i][j]){
                    int count = 0;
                    visited[i][j] = true;
                    int size = getSize(graph, visited, i, j, n, count) + 1;
                    if (maxSize < size){
                        maxSize = size;
                    }
                }
            }
        }
        return maxSize;
    }

    public static int getSize(int[][] graph, boolean[][] visited, int i, int j, int n, int count){
        if (j-1 > 0 && graph[i][j-1] == 1 && !visited[i][j-1]){
            visited[i][j-1] = true;
            count = getSize(graph, visited, i, j-1, n, count) + 1;
        }
        if (i+1 < n && graph[i+1][j] == 1 && !visited[i+1][j]){
            visited[i+1][j] = true;
            count = getSize(graph, visited, i+1, j, n, count) + 1;
        }
        if (j+1 < n && graph[i][j+1] == 1 && !visited[i][j+1]){
            visited[i][j+1] = true;
            count = getSize(graph, visited, i, j+1, n, count) + 1;
        }
        if (i-1 > 0 && graph[i-1][j] == 1 && !visited[i-1][j]){
            visited[i-1][j] = true;
            count = getSize(graph, visited, i-1, j, n, count) + 1;
        }
        return count;
    }
}
