import java.util.Scanner;

public class EvenOddSegmentTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        TreeKnode[] tree = new TreeKnode[3 * n];
        buildTree(arr, tree, 1, 0, n - 1);
        //printTree(tree);

        int queries = in.nextInt();
        while (queries > 0) {
            int x = in.nextInt();
            if (x == 1 || x == 2) {
                int left = in.nextInt() -1;
                int right = in.nextInt() -1;
                TreeKnode ans = query(tree, 0, n - 1, 1, left, right);
                if (x == 1)
                    System.out.println(ans.evenCount);
                else
                    System.out.println(ans.oddCount);
                //printTree(tree);
            } else if (x==0) {
                int arrayPosition = in.nextInt() - 1;
                long value = in.nextLong();
                updateTree(arr, tree, 0, n - 1, 1, arrayPosition, value);
                //printTree(tree);
            }
            queries--;
        }
    }

    public static void buildTree(long[] arr, TreeKnode[] tree, int treeNode, int start, int end) {
        if (start == end) {
            tree[treeNode] = new TreeKnode();
            if (arr[start] % 2 == 0) {
                tree[treeNode].evenCount = 1;
                tree[treeNode].oddCount = 0;
            }
            else {
                tree[treeNode].evenCount = 0;
                tree[treeNode].oddCount = 1;
            }
            return;
        }
        int mid = (start + end) / 2;

        buildTree(arr, tree, 2 * treeNode, start, mid);
        buildTree(arr, tree, 2 * treeNode + 1, mid + 1, end);
        TreeKnode left = tree[2 * treeNode];
        TreeKnode right = tree[2 * treeNode + 1];
        tree[treeNode] = new TreeKnode();
        tree[treeNode].evenCount = left.evenCount + right.evenCount;
        tree[treeNode].oddCount = left.oddCount + right.oddCount;
    }

    public static void updateTree(long[] arr, TreeKnode[] tree, int start, int end, int treeNode, int index, long value) {
        if (start == end) {
            arr[index] = value;
            if (arr[start] % 2 == 0) {
                tree[treeNode].evenCount = 1;
                tree[treeNode].oddCount = 0;
            }
            else {
                tree[treeNode].evenCount = 0;
                tree[treeNode].oddCount = 1;
            }
            return;
        }

        int mid = (start + end) / 2;
        if (index > mid) {
            updateTree(arr, tree, mid + 1, end, 2 * treeNode + 1, index, value);
        } else {
            updateTree(arr, tree, start, mid, 2 * treeNode, index, value);
        }
        TreeKnode left = tree[2 * treeNode];
        TreeKnode right = tree[2 * treeNode + 1];
        tree[treeNode].evenCount = left.evenCount + right.evenCount;
        tree[treeNode].oddCount = left.oddCount + right.oddCount;
    }

    public static TreeKnode query(TreeKnode[] tree, int start, int end, int treeNode, int left, int right) {
        if (start > right || end < left) {
            TreeKnode ans = new TreeKnode();
            ans.oddCount = 0;
            ans.evenCount = 0;
            return ans;
        }

        if (start >= left && end <= right)
            return tree[treeNode];

        int mid = (start + end) / 2;
        TreeKnode ans1 = query(tree, start, mid, 2 * treeNode, left, right);
        TreeKnode ans2 = query(tree, mid + 1, end, 2 * treeNode + 1, left, right);
        TreeKnode ans = new TreeKnode();
        ans.evenCount = ans1.evenCount + ans2.evenCount;
        ans.oddCount = ans1.oddCount + ans2.oddCount;
        return ans;
    }

    public static void printTree(TreeKnode[] tree) {
        for (int i = 1; i < tree.length; i++) {
            if (tree[i] != null) {
                System.out.println("odd: " + tree[i].oddCount + "; even: " + tree[i].evenCount);
            } else {
                System.out.println("odd: " + null + "; even: " + null);
            }
        }
    }
}

class TreeKnode {
    int oddCount = 0;
    int evenCount = 0;
}
