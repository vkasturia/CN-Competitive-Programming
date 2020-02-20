import java.util.Scanner;

public class PrimsAlgorithm {
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

        primsAlgorithm(edges, n);
    }

    public static void primsAlgorithm(int[][] edges, int n){
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = -1;
            weight[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        weight[0] = 1;

        for (int i = 0; i < n-1; i++){
            int minVertex = getMinVertex(visited, weight, n);
            visited[minVertex] = true;
            for (int j = 0; j < n; j++){
                if (edges[minVertex][j] != 0 && !visited[j]){
                    if (weight[j] > edges[minVertex][j]){
                        weight[j] = edges[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }

        for(int i = 1; i < n; i++){
            if (parent[i] < i){
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            }
            else{
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
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
