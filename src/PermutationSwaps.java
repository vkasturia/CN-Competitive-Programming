import java.util.*;

public class PermutationSwaps {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        while(testCases > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[] P = new int[n];
            int[] Q = new int[n];
            for (int i = 0; i < n; i++){
                P[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++){
                Q[i] = in.nextInt();
            }

            Map<Integer, List<Integer>> edgesMap = new HashMap<>();
            for (int i = 0; i < m; i++) {
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
            Set<Set<Integer>> components = getComponents(edgesMap, n);
            Set<Set<Integer>> componentsP = new HashSet<>();
            Set<Set<Integer>> componentsQ = new HashSet<>();
            for (Set<Integer> component : components) {
                Set<Integer> componentP = new HashSet<>();
                Set<Integer> componentQ = new HashSet<>();
                for (Integer node : component) {
                    componentP.add(P[node]);
                    componentQ.add(Q[node]);
                }
                componentsP.add(componentP);
                componentsQ.add(componentQ);
            }
            if(componentsP.equals(componentsQ))
                System.out.println("YES");
            else
                System.out.println("NO");
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
