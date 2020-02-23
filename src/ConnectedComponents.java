import java.util.*;

public class ConnectedComponents {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, List<Integer>> edgesMap = new HashMap<>();
        int E = in.nextInt();
        for (int i = 0; i < E; i++){
            int startNode = in.nextInt()-1;
            int endNode = in.nextInt()-1;
            if (edgesMap.containsKey(startNode)){
                edgesMap.get(startNode).add(endNode);
            }
            else{
                edgesMap.put(startNode, new ArrayList<>(Arrays.asList(endNode)));
            }
            if (edgesMap.containsKey(endNode)){
                edgesMap.get(endNode).add(startNode);
            }
            else{
                edgesMap.put(endNode, new ArrayList<>(Arrays.asList(startNode)));
            }
        }
        Set<Set<Integer>> components = getComponents(edgesMap, n);
        for (Set<Integer> component : components){
            for(Integer node : component){
                System.out.print(node+1 + " ");

            }
            System.out.println();
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
