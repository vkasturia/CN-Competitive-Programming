import java.util.*;

public class KosarajuAlgorithm {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, List<Integer>> edgesMap = new HashMap<>();
        Map<Integer, List<Integer>> edgesMapTranspose = new HashMap<>();
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
            if (edgesMapTranspose.containsKey(endNode)){
                edgesMapTranspose.get(endNode).add(startNode);
            }
            else{
                edgesMapTranspose.put(endNode, new ArrayList<>(Arrays.asList(startNode)));
            }
        }
        Set<Set<Integer>> components = getStronglyConnectedComponents(edgesMap, edgesMapTranspose, n);
        for (Set<Integer> component : components){
            for(Integer node : component){
                System.out.print(node+1 + " ");
            }
            System.out.println();
        }
    }

    public static Set<Set<Integer>> getStronglyConnectedComponents(Map<Integer, List<Integer>> edgesMap, Map<Integer, List<Integer>> edgesMapTranspose, int n){
        Set<Set<Integer>> components = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> finishedVertices = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)){
                dfs(edgesMap, n, i, visited, finishedVertices);
            }
        }

        visited.clear();
        while(finishedVertices.size() != 0){
            int element = finishedVertices.pop();
            if (!visited.contains(element)) {
                Set<Integer> component = new HashSet<>();
                dfs2(edgesMapTranspose, n, element, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    public static void dfs(Map<Integer, List<Integer>> edgesMap, int n, int startVertex, Set<Integer> visited, Stack<Integer> finishedVertices){
        visited.add(startVertex);
        if (edgesMap.containsKey(startVertex)){
            List<Integer> neighbours = edgesMap.get(startVertex);
            for (Integer neighbour : neighbours) {
                if (visited.contains(neighbour))
                    continue;
                dfs(edgesMap, n, neighbour, visited, finishedVertices);
            }
        }
        finishedVertices.push(startVertex);
    }

    public static void dfs2(Map<Integer, List<Integer>> edgesMapTranspose, int n, int startVertex, Set<Integer> visited, Set<Integer> component){
        visited.add(startVertex);
        component.add(startVertex);
        if (edgesMapTranspose.containsKey(startVertex)){
            List<Integer> neighbours = edgesMapTranspose.get(startVertex);
            for (Integer neighbour : neighbours) {
                if (visited.contains(neighbour))
                    continue;
                dfs2(edgesMapTranspose, n, neighbour, visited, component);
            }
        }
    }
}
