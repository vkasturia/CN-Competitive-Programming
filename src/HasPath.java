import java.util.LinkedList;
import java.util.Scanner;

public class HasPath {
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
        BFS(edges, n, start, end);
    }

    public static boolean printBFS(int[][] edges, int n, boolean[] visited, int start, int end){
        if (start == end) {
            return true;
        }

        LinkedList<Integer> pendingVertices = new LinkedList<Integer>();
        pendingVertices.add(start);
        visited[start] = true;
        while(pendingVertices.size() != 0){
            int currentVertex = pendingVertices.poll();
            for (int i = 0; i < n; i++){
                if (i == currentVertex){
                    continue;
                }
                if (edges[currentVertex][i] == 1 && !visited[i]){
                    pendingVertices.add(i);
                    if (i == end){
                        return true;
                    }
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    public static void BFS(int[][] edges, int n, int start, int end){
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            visited[i] = false;
        }
        boolean hasPath = printBFS(edges, n, visited, start, end);
        System.out.println(hasPath);
    }
}
