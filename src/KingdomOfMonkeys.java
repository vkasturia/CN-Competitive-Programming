import java.util.*;

public class KingdomOfMonkeys {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        while (testCases > 0) {
            int n = in.nextInt();
            Map<Integer, List<Integer>> edgesMap = new HashMap<>();
            int E = in.nextInt();
            for (int i = 0; i < E; i++) {
                int startNode = in.nextInt() - 1;
                int endNode = in.nextInt() - 1;
                if (edgesMap.containsKey(startNode)) {
                    edgesMap.get(startNode).add(endNode);
                } else {
                    edgesMap.put(startNode, new ArrayList<>(Arrays.asList(endNode)));
                }
                if (edgesMap.containsKey(endNode)) {
                    edgesMap.get(endNode).add(startNode);
                } else {
                    edgesMap.put(endNode, new ArrayList<>(Arrays.asList(startNode)));
                }
            }
            long[] gatheredBananas = new long[n];
            for (int i = 0; i < n; i++){
                gatheredBananas[i] = in.nextLong();
            }
            long maxBananas = -1;
            Set<Set<Integer>> components = getComponents(edgesMap, n);
            for (Set<Integer> component : components) {
                long gatheredBananasInComponent = 0;
                for (Integer node : component) {
                    gatheredBananasInComponent += gatheredBananas[node];
                }
                if (gatheredBananasInComponent > maxBananas){
                    maxBananas = gatheredBananasInComponent;
                }
            }
            System.out.println(maxBananas);
            testCases--;
        }
    }

    public static Set<Set<Integer>> getComponents(Map<Integer, List<Integer>> edgesMap, int n){
        Set<Set<Integer>> components = new HashSet<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            visited[i] = false;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                Set<Integer> component = new HashSet<>();
                DFS(edgesMap, n, i, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    public static void DFS(Map<Integer, List<Integer>> edgesMap, int n, int startVertex, boolean[] visited, Set<Integer> component){
        visited[startVertex] = true;
        component.add(startVertex);
        if (edgesMap.containsKey(startVertex)){
            List<Integer> neighbours = edgesMap.get(startVertex);
            for (Integer neighbour : neighbours) {
                if (visited[neighbour])
                    continue;
                DFS(edgesMap, n, neighbour, visited, component);
            }
        }
    }

}
