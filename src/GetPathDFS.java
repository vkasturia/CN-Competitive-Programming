import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetPathDFS {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int edgeCount = in.nextInt();
        int[][] edges = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                edges[i][j] = 0;
            }
        }
        for (int i = 0; i < edgeCount; i++){
            int firstVertex = in.nextInt();
            int secondVertex = in.nextInt();
            edges[firstVertex][secondVertex] = 1;
            edges[secondVertex][firstVertex] = 1;
        }

        int start = in.nextInt();
        int end = in.nextInt();
        List<Integer> path = new ArrayList<>();
        DFS(edges, n, start, end, path);
        if (path.contains(end)){
            for (int i = path.size()-1; i >=0; i--){
                System.out.print(path.get(i) + " ");
            }
        }
    }

    public static boolean printDFS(int[][] edges, int n, boolean[] visited, int start, int end, boolean flag, List<Integer> path){
        if (!flag) {
            path.add(start);
            if (start == end) {
                flag = true;
                return flag;
            }
            visited[start] = true;
            for (int i = 0; i < n && !flag; i++) {
                if (i == start) {
                    continue;
                }
                if (edges[start][i] == 1) {
                    if (visited[i])
                        continue;
                    if (i == end) {
                        path.add(i);
                        flag = true;
                        return flag;
                    } else {
                        flag = printDFS(edges, n, visited, i, end, flag, path);
                    }
                }
            }
        }
        return true;
    }

    public static void DFS(int[][] edges, int n, int start, int end, List<Integer> path){
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            visited[i] = false;
        }
        printDFS(edges, n, visited, start, end, false, path);
    }
}
