import java.util.*;

public class Islands {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] u = new int[m];
        int[] v = new int[m];
        for (int i = 0; i < m; i++){
            u[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++){
            v[i] = in.nextInt();
        }

        int[][] edges = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                edges[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++){
            int firstVertex = u[i]-1;
            int secondVertex = v[i]-1;
            edges[firstVertex][secondVertex] = 1;
            edges[secondVertex][firstVertex] = 1;
        }

        int ans = getComponentsCountBFS(edges, n);
        System.out.println(ans);
    }

    public static void findComponentBFS(int[][] edges, int n, int startVertex, boolean[] visited, List<List<Integer>> components){
        List<Integer> component = new ArrayList<>();
        LinkedList<Integer> pendingVertices = new LinkedList<>();
        pendingVertices.add(startVertex);
        visited[startVertex] = true;
        component.add(startVertex);
        while(pendingVertices.size() != 0){
            int currentVertex = pendingVertices.poll();
            for (int i = 0; i < n; i++){
                if (i == currentVertex){
                    continue;
                }
                if (edges[currentVertex][i] == 1 && !visited[i]){
                    component.add(i);
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
        components.add(component);
    }

    public static int getComponentsCountBFS(int[][] edges, int n){
        List<List<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            visited[i] = false;
        }
        for (int i = 0; i < n; i++){
            if (visited[i] == false){
                findComponentBFS(edges, n, i, visited, components);
            }
        }
        return components.size();
    }
}
