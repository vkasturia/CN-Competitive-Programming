import java.util.*;

public class MonkIslands {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        while(testCases > 0) {
            int n = in.nextInt();
            int edgeCount = in.nextInt();
            int[][] edges = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    edges[i][j] = 0;
                }
            }
            for (int i = 0; i < edgeCount; i++) {
                int firstVertex = in.nextInt()-1;
                int secondVertex = in.nextInt()-1;
                edges[firstVertex][secondVertex] = 1;
                edges[secondVertex][firstVertex] = 1;
            }

            int start = 0;
            int end = n-1;
            int[] level = new int[n];
            Map<Integer, Integer> pathMap = new HashMap<>();
            BFS(edges, n, start, end, pathMap, level);
            testCases--;
        }
    }

    public static boolean printBFS(int[][] edges, int n, boolean[] visited, int start, int end, Map<Integer, Integer> pathMap, int[] level){
        if (start == end) {
            System.out.println(0);
            return true;
        }
        LinkedList<Integer> pendingVertices = new LinkedList<>();
        pendingVertices.add(start);
        level[start] = 0;
        visited[start] = true;
        while(pendingVertices.size() != 0){
            int currentVertex = pendingVertices.poll();
            for (int i = 0; i < n; i++){
                if (i == currentVertex){
                    continue;
                }
                if (edges[currentVertex][i] == 1 && !visited[i]){
                    pendingVertices.add(i);
                    level[i] = level[currentVertex] + 1;
                    pathMap.put(i, currentVertex);
                    if (i == end){
                        System.out.println(level[i]);
                        return true;
                    }
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    public static void BFS(int[][] edges, int n, int start, int end, Map<Integer, Integer> pathMap, int[] level){
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            visited[i] = false;
        }
        printBFS(edges, n, visited, start, end, pathMap, level);
    }
}
