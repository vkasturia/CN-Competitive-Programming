import java.util.LinkedList;
import java.util.Scanner;

public class IsConnectedGraph {
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
        isConnectedBFS(edges, n, 0);
    }

    public static void isConnectedBFS(int[][] edges, int n, int startVertex){
        LinkedList<Integer> pendingVertices = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            visited[i] = false;
        }
        pendingVertices.add(startVertex);
        visited[startVertex] = true;
        while(pendingVertices.size() != 0){
            int currentVertex = pendingVertices.poll();
            for (int i = 0; i < n; i++){
                if (i == currentVertex){
                    continue;
                }
                if (edges[currentVertex][i] == 1 && !visited[i]){
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                System.out.print(false);
                return;
            }
        }
        System.out.print(true);
    }
}
