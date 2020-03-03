import java.util.Scanner;

public class HelpPradyumana {
    static class Trie {
        Trie children[];
        boolean isLeaf;

        public Trie() {
            this.children = new Trie[26];
            this.isLeaf = false;
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Trie root = new Trie();
        while (n > 0) {
            add(root, sc.nextLine());
            n--;
        }
        int query = sc.nextInt();
        sc.nextLine();
        while (query-- != 0) {
            printSuccessor(root, sc.nextLine());
        }
    }

    private static void printSuccessor(Trie root, String data) {
        Trie crawl = root;
        for (int i = 0; i < data.length(); i++) {
            int index = data.charAt(i) - 'a';
            if (crawl.children[index] != null) {
                crawl = crawl.children[index];
            } else {
                System.out.println("No suggestions");
                add(root, data);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        searchMore(crawl, data, sb);
        System.out.print(sb);

    }

    private static void searchMore(Trie crawl, String data, StringBuilder sb) {
        if (crawl == null) {
            return;
        }
        if (crawl.isLeaf) {
            sb.append(data + "\n");
        }
        for (int i = 0; i < 26; i++) {
            if (crawl.children[i] != null) {
                searchMore(crawl.children[i], data + (char) ('a' + i), sb);
            }
        }
    }

    private static void add(Trie root, String data) {
        Trie crawl = root;
        data = data.toLowerCase();
        for (int i = 0; i < data.length(); i++) {
            int index = data.charAt(i) - 'a';
            if (crawl.children[index] == null) {
                crawl.children[index] = new Trie();
            }
            crawl = crawl.children[index];
        }
        crawl.isLeaf = true;
    }

}