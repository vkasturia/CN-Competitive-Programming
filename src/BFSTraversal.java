import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTraversal {
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
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        print(edges, n, queue, visited);
    }

    public static void print(int[][] edges, int n, Queue<Integer> queue, boolean[] visited) {
        while(!queue.isEmpty()){
            int vertex = queue.remove();
            System.out.print(vertex + " ");
            for (int i = 0; i < n; i++) {
                if (i == vertex) {
                    continue;
                }
                if (edges[vertex][i] == 1) {
                    if (visited[i])
                        continue;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
