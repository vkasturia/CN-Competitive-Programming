import java.util.*;

public class GetPathDFS {
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
        DFS(edges, n, start, end, pathMap);
    }

    public static boolean printDFS(int[][] edges, int n, boolean[] visited, int start, int end, boolean flag, Map<Integer, Integer> pathMap){
        if (!flag) {
            if (start == end) {
                flag = true;
                return flag;
            }
            visited[start] = true;
            for (int i = 0; i < n && !flag; i++) {
                if (i == start) {
                    continue;
                }
                if (edges[start][i] == 1) {
                    if (visited[i])
                        continue;
                    if (i == end) {
                        pathMap.put(i, start);
                        flag = true;
                        return flag;
                    } else {
                        pathMap.put(i, start);
                        flag = printDFS(edges, n, visited, i, end, flag, pathMap);
                    }
                }
            }
        }
        return flag;
    }

    public static void DFS(int[][] edges, int n, int start, int end, Map<Integer, Integer> pathMap){
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            visited[i] = false;
        }
        boolean hasPath = printDFS(edges, n, visited, start, end, false, pathMap);
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
