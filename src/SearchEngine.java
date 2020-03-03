import java.util.Scanner;

public class SearchEngine {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        in.nextLine();
        trieKnode root = new trieKnode();
        for (int i = 0; i < n; i++){
            String s = in.nextLine();
            String[] split = s.split("\\s+");
            int weight = Integer.parseInt(split[1]);
            insert(split[0], weight, root);
        }
        for (int i = 0; i < q; i++){
            String pre = in.nextLine();
            System.out.println(searchBest(pre, root));
        }
    }
    public static void insert(String s, int weight, trieKnode root){
        if (s.isEmpty()) {
            return;
        }
        trieKnode child;
        int index = s.charAt(0) - 'a';
        if (root.children[index]!= null){
            child = root.children[index];
        }
        else{
            child = new trieKnode();
            root.children[index] = child;
        }
        if (root.weight < weight){
            root.weight = weight;
        }
        insert(s.substring(1), weight, child);
    }
    public static int searchBest(String s, trieKnode root){
        trieKnode current = root;
        int bestWeight = -1;
        for (int i = 0; i < s.length(); i++){
            int index = s.charAt(i)-'a';
            trieKnode child = current.children[index];
            if(child != null){
                current = child;
                bestWeight = child.weight;
            }else{
                return -1;
            }
        }
        return bestWeight;
    }
}

class trieKnode{
    trieKnode[] children;
    int weight;

    trieKnode(){
        children = new trieKnode[26];
        for (int i = 0; i < 26; i++){
            children[i] = null;
        }
        weight = 0;
    }
}