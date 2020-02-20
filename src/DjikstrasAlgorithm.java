import java.util.Scanner;

public class DjikstrasAlgorithm {
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
            int weight = in.nextInt();
            edges[firstVertex][secondVertex] = weight;
            edges[secondVertex][firstVertex] = weight;
        }

        djikstrasAlgorithm(edges, n);
    }

    public static void djikstrasAlgorithm(int[][] edges, int n){
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = -1;
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distance[0] = 0;

        for (int i = 0; i < n-1; i++){
            int minVertex = getMinVertex(visited, distance, n);
            visited[minVertex] = true;
            for (int j = 0; j < n; j++){
                if (edges[minVertex][j] != 0 && !visited[j]){
                    if (distance[j] > distance[minVertex] + edges[minVertex][j]){
                        distance[j] = distance[minVertex] + edges[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println(i + " " + distance[i]);
        }

    }

    public static int getMinVertex(boolean[] visited, int[] weight, int n){
        int minVertex = -1;
        for (int i = 0; i < n; i++){
            if (!visited[i] && ((minVertex == -1) || (weight[i] < weight[minVertex]))){
                minVertex = i;
            }
        }
        return minVertex;
    }
}
