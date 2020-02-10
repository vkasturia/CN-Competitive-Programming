import java.util.Scanner;

public class MaximumPairSum {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextLong();
        }
        TreeNode[] tree = new TreeNode[3*n];
        buildTree(arr, tree, 1, 0, n-1);
        printTree(tree);

        int queries = in.nextInt();
        while (queries > 0){
            char x = in.next().charAt(0);
            if (x == 'Q'){
                int left = in.nextInt()-1;
                int right = in.nextInt()-1;
                TreeNode ans = query(tree, 0, n-1, 1, left, right);
                System.out.println(ans.maximum + ans.smaximum);
                printTree(tree);
            }
            else{
                int arrayPosition = in.nextInt()-1;
                long value = in.nextLong();
                updateTree(arr, tree, 0, n-1, 1, arrayPosition, value);
                printTree(tree);
            }
            queries--;
        }
    }
    public static void buildTree(long[] arr, TreeNode[] tree, int treeNode, int start, int end){
        if (start == end){
            tree[treeNode] = new TreeNode();
            tree[treeNode].maximum = arr[start];
            tree[treeNode].smaximum = Integer.MIN_VALUE;
            return;
        }
        int mid = (start + end) / 2;

        buildTree(arr, tree, 2 * treeNode, start, mid);
        buildTree(arr, tree, 2 * treeNode + 1, mid+1, end);
        TreeNode left = tree[2 * treeNode];
        TreeNode right = tree[2 * treeNode + 1];
        tree[treeNode] = new TreeNode();
        tree[treeNode].maximum = Math.max(left.maximum, right.maximum);
        tree[treeNode].smaximum = Math.min(Math.max(left.maximum, right.smaximum), Math.max(right.maximum, left.smaximum));
    }

    public static void updateTree(long[] arr, TreeNode[] tree, int start, int end, int treeNode, int index, long value){
        if (start == end){
            arr[index] = value;
            tree[treeNode].maximum = value;
            tree[treeNode].smaximum = Integer.MIN_VALUE;
            return;
        }

        int mid = (start + end)/2;
        if (index > mid){
            updateTree(arr, tree, mid + 1, end, 2*treeNode+1, index, value);
        }
        else{
            updateTree(arr, tree, start, mid, 2*treeNode, index, value);
        }
        TreeNode left = tree[2 * treeNode];
        TreeNode right = tree[2 * treeNode + 1];
        tree[treeNode].maximum = Math.max(left.maximum, right.maximum);
        tree[treeNode].smaximum = Math.min(Math.max(left.maximum, right.smaximum), Math.max(right.maximum, left.smaximum));
    }

    public static TreeNode query(TreeNode[] tree, int start, int end, int treeNode, int left, int right){
        if(start>right || end<left){
            TreeNode ans = new TreeNode();
            ans.maximum = Integer.MIN_VALUE;
            ans.smaximum = Integer.MIN_VALUE;
            return ans;
        }

        if (start >= left && end <= right)
            return tree[treeNode];

        int mid = (start+end)/2;
        TreeNode ans1 = query(tree, start, mid, 2*treeNode, left, right);
        TreeNode ans2 = query(tree, mid+1, end, 2*treeNode+1, left, right);
        TreeNode ans = new TreeNode();
        ans.maximum = Math.max(ans1.maximum, ans2.maximum);
        ans.smaximum = Math.min(Math.max(ans1.maximum, ans2.smaximum), Math.max(ans2.maximum, ans1.smaximum));
        return ans;
    }

    public static void printTree(TreeNode[] tree){
        for (int i = 1; i < tree.length; i++){
            if (tree[i] != null) {
                System.out.println("max: " + tree[i].maximum + "; smax: " + tree[i].smaximum);
            }
            else{
                System.out.println("max: " + null + "; smax: " + null);
            }
        }
    }
}

class TreeNode{
    long maximum;
    long smaximum;
}