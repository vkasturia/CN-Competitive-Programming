import java.util.*;

public class GetPathBFS {
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
        Map<Integer, Integer> pathMap = new HashMap<>();
        BFS(edges, n, start, end, pathMap);
    }

    public static boolean printBFS(int[][] edges, int n, boolean[] visited, int start, int end, Map<Integer, Integer> pathMap){
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
                    pathMap.put(i, currentVertex);
                    if (i == end){
                        return true;
                    }
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    public static void BFS(int[][] edges, int n, int start, int end, Map<Integer, Integer> pathMap){
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            visited[i] = false;
        }
        boolean hasPath = printBFS(edges, n, visited, start, end, pathMap);
        if(hasPath){
            traverseMap(end, start, pathMap);
        }
    }

    public static void traverseMap(int i, int start, Map<Integer, Integer> pathMap){
        System.out.print(i + " ");
        if (i == start)
            return;
        int node = pathMap.get(i);
        traverseMap(node, start, pathMap);
    }
}
