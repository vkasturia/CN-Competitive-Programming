import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int source;
    int destination;
    int weight;

    Edge(int source,int destination,int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        int x=weight-o.weight;
        return x;
    }
};

public class KruksalsAlgorithm {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int E = in.nextInt();
        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++){
            int source = in.nextInt();
            int destination = in.nextInt();
            int weight = in.nextInt();
            Edge edge = new Edge(source, destination, weight);
            edges[i] = edge;
        }

        Arrays.sort(edges);
        Edge[] output = kruskalsAlgorithm(edges, n, E);
        for (int i = 0; i < n-1; i++){
            Edge ans = output[i];
            if (ans.source > ans.destination){
                System.out.println(ans.destination + " " + ans.source + " " + ans.weight);
            }
            else{
                System.out.println(ans.source + " " + ans.destination + " " + ans.weight);
            }
        }

    }

    public static Edge[] kruskalsAlgorithm(Edge[] edges, int n, int E){
        Edge[] output = new Edge[n-1];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }

        int count = 0;
        int i = 0;
        while (count < n-1){
            Edge currentEdge = edges[i];
            int sourceParent = getParent(currentEdge.source, parent);
            int destinationParent = getParent(currentEdge.destination, parent);
            if (sourceParent != destinationParent){
                output[count] = currentEdge;
                parent[sourceParent] = destinationParent;
                count++;
            }
            i++;
        }
        return output;
    }

    public static int getParent(int node, int[] parent){
        if(parent[node] == node){
            return node;
        }
        return getParent(parent[node], parent);
    }
}
