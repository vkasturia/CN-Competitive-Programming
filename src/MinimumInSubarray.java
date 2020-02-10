import java.util.Scanner;

public class MinimumInSubarray {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int queries = in.nextInt();
        int[] arr = new int[n];
        int treeSize = 4*n;
        int[] tree = new int[treeSize];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        buildTree(arr, tree, 0, n-1, 1);

//        for (int i = 1; i < 4*n; i++){
//            System.out.println(tree[i]);
//        }

        while (queries > 0){
            char x = in.next().charAt(0);
            if (x == 'q'){
                int left = in.nextInt()-1;
                int right = in.nextInt()-1;
                int ans = query(tree, 0, n-1, 1, left, right);
                System.out.println(ans);
            }
            else{
                int arrayPosition = in.nextInt()-1;
                int value = in.nextInt();
                updateTree(arr, tree, 0, n-1, 1, arrayPosition, value);
            }
            queries--;
        }
    }

    public static void buildTree(int[] arr, int[] tree, int start, int end, int treeNode){
        if (start == end){
            tree[treeNode] = arr[start];
            return;
        }
        int mid = (start + end) / 2;

        buildTree(arr, tree, start, mid, 2 * treeNode);
        buildTree(arr, tree, mid+1, end, 2 * treeNode + 1);

        tree[treeNode] = Math.min(tree[2 * treeNode], tree[2 * treeNode + 1]);
    }

    public static void updateTree(int[] arr, int[] tree, int start, int end, int treeNode, int index, int value){
        if (start == end){
            arr[index] = value;
            tree[treeNode] = value;
            return;
        }

        int mid = (start + end)/2;
        if (index > mid){
            updateTree(arr, tree, mid + 1, end, 2*treeNode+1, index, value);
        }
        else{
            updateTree(arr, tree, start, mid, 2*treeNode, index, value);
        }
        tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode + 1]);
    }

    public static int query(int[] tree, int start, int end, int treeNode, int left, int right){
        if (start > right || end < left){
            return Integer.MAX_VALUE;
        }
        if (start >= left && end <= right){
            return tree[treeNode];
        }
        int mid = (start + end)/2;
        int ans1 = query(tree, start, mid, 2*treeNode, left, right);
        int ans2 = query(tree, mid+1, end, 2*treeNode+1, left, right);
        return Math.min(ans1, ans2);
    }
}
