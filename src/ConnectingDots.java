import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectingDots {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] board = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        in.nextLine();
        for(int i = 0; i < n; i++){
            String line = in.nextLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < m; j++){
                board[i][j] = charArray[j];
                visited[i][j] = false;
            }
        }
        List<Character> characterList = new ArrayList<>();
        int cycles = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!characterList.contains(board[i][j]) && !visited[i][j]){
                    visited[i][j] = true;
                    char x = board[i][j];
                    characterList.add(x);
                    int length = 1;
                    length = getLength (x, board, visited, i, j, n, m, length);
                    if(length >= 4) {
                        cycles++;
                    }
                }
            }
        }
        System.out.println(cycles);
    }

    public static int getLength(char x, char[][] graph, boolean[][] visited, int i, int j, int n, int m, int length){
        if (j-1 > 0 && graph[i][j-1] == x && !visited[i][j-1]){
            visited[i][j-1] = true;
            length = getLength(x, graph, visited, i, j-1, n, m, length) + 1;
        }
        if (i+1 < n && graph[i+1][j] == x && !visited[i+1][j]){
            visited[i+1][j] = true;
            length = getLength(x, graph, visited, i+1, j, n, m, length) + 1;
        }
        if (j+1 < m && graph[i][j+1] == x && !visited[i][j+1]){
            visited[i][j+1] = true;
            length = getLength(x, graph, visited, i, j+1, n, m, length) + 1;
        }
        if (i-1 > 0 && graph[i-1][j] == x && !visited[i-1][j]){
            visited[i-1][j] = true;
            length = getLength(x, graph, visited, i-1, j, n, m, length) + 1;
        }
        return length;
    }
}
