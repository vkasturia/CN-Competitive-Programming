import java.util.*;

public class Bipartite {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n != 0) {
            Map<Integer, List<Integer>> edgesMap = new HashMap<>();
            int E = in.nextInt();
            for (int i = 0; i < E; i++) {
                int startNode = in.nextInt();
                int endNode = in.nextInt();
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
            boolean ans = isBipartite(edgesMap, n);
            if (ans){
                System.out.println("BICOLORABLE");
            }
            else{
                System.out.println("NOT BICOLORABLE");
            }
            n = in.nextInt();
        }
    }

    public static boolean isBipartite(Map<Integer, List<Integer>> edgesMap, int n){
        if (n == 0){
            return true;
        }
        List<Set<Integer>> sets = new ArrayList<>();
        List<Integer> pending = new ArrayList<>();
        sets.add(0, new HashSet<>());
        sets.add(1, new HashSet<>());
        sets.get(0).add(0);
        pending.add(0);
        while (pending.size() > 0) {
            int size = pending.size();
            int current = pending.remove(size-1);
            int currentSet = sets.get(0).contains(current) ? 0 : 1;
            for (Integer neighbor : edgesMap.get(current)){
                if (!sets.get(0).contains(neighbor) && !sets.get(1).contains(neighbor)) {
                    sets.get(1 - currentSet).add(neighbor);
                    pending.add(neighbor);
                } else if (sets.get(currentSet).contains(neighbor)) {
                    return false;
                }
            }
        }
        return true;
    }
}
