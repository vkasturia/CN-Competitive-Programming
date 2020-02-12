import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
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

        System.out.println("BFS: ");
        BFS(edges, n);
        System.out.println("DFS: ");
        DFS(edges, n);
    }

    public static void printBFS(int[][] edges, int n, int startVertex, boolean[] visited){
        LinkedList<Integer> pendingVertices = new LinkedList<Integer>();
        pendingVertices.add(startVertex);
        visited[startVertex] = true;
        while(pendingVertices.size() != 0){
            int currentVertex = pendingVertices.poll();
            System.out.print(currentVertex + " ");
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
    }

    public static void printDFS(int[][] edges, int n, int startVertex, boolean[] visited){
        System.out.print(startVertex + " ");
        visited[startVertex] = true;
        for (int i = 0; i < n; i++){
            if ( i == startVertex){
                continue;
            }
            if (edges[startVertex][i] == 1){
                if (visited[i])
                    continue;
                printDFS(edges, n, i, visited);
            }
        }
    }

    public static void DFS(int[][] edges, int n){
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            visited[i] = false;
        }
        for (int i = 0; i < n; i++){
            if (visited[i] == false){
                printDFS(edges, n, i, visited);
            }
        }

    }

    public static void BFS(int[][] edges, int n){
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            visited[i] = false;
        }
        for (int i = 0; i < n; i++){
            if (visited[i] == false){
                printBFS(edges, n, i, visited);
            }
        }
    }
}
