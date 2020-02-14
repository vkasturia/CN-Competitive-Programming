import java.util.Scanner;

public class ThreeCycles {
    static int count = 0;
    public static void main(String[] args) {
        int cycleLength = 3;
        int count = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] graph = new int[n][n];
        int m = in.nextInt();
        int[] u = new int[m];
        int[] v = new int[m];
        for (int i = 0; i < m; i++){
            u[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++){
            v[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++){
            int x = u[i] -1;
            int y = v[i] - 1;
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        int ans = countCycles(graph, cycleLength, n);
        System.out.println(ans);
    }

    static void DFS(int graph[][], boolean marked[], int cycleLength, int vert, int start, int V) {

        marked[vert] = true;
        if (cycleLength == 0) {
            marked[vert] = false;
            if (graph[vert][start] == 1) {
                count++;
                return;
            } else
                return;
        }

        for (int i = 0; i < V; i++)
            if (!marked[i] && graph[vert][i] == 1)
                DFS(graph, marked, cycleLength - 1, i, start, V);
        marked[vert] = false;
    }

    static int countCycles(int graph[][], int cycleLength, int V) {

        boolean marked[] = new boolean[V];

        for (int i = 0; i < V - (cycleLength - 1); i++) {
            DFS(graph, marked, cycleLength - 1, i, i, V);
            marked[i] = true;
        }

        return count / 2;
    }
}
