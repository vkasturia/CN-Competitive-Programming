
public class MinimumInSubarrayLazy {
    public static void main(String[] args){
        int[] arr = new int[]{1,3,-2,4};
        int[] tree = new int[12];
        buildTree(arr, tree, 0, 3, 1);
        int [] lazy = new int[12];
        updateSegmentTreeLazy(tree, lazy, 0, 3, 0, 3, 1, 3);
        updateSegmentTreeLazy(tree, lazy, 0, 3, 0, 1, 1, 2);

        System.out.println("Segment Tree: ");
        for (int i = 1; i < 12; i++){
            System.out.println(tree[i]);
        }

        System.out.println("Lazy Tree: ");
        for (int i = 1; i < 12; i++){
            System.out.println(lazy[i]);
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

    public static void updateSegmentTreeLazy(int[] tree, int[] lazy, int low, int high, int startR, int endR, int currPos, int increment){
        if (low > high){
            return;
        }

        if (lazy[currPos] != 0){
            tree[currPos] += lazy[currPos];
            if (low != high){
                lazy[2*currPos] += lazy[currPos];
                lazy[2*currPos + 1] += lazy[currPos];
            }
            lazy[currPos] = 0;
        }

        //Non overlapping range
        if (startR > high || endR < low){
            return;
        }

        //Complete overlap
        if (startR<= low && high <= endR){
            tree[currPos] += increment;
            if (low != high){
                lazy[2*currPos] += increment;
                lazy[2*currPos+1] += increment;
            }
            return;
        }

        //Partial Overlap
        int mid = (high + low)/2;
        updateSegmentTreeLazy(tree, lazy, low, mid, startR, endR, 2*currPos, increment);
        updateSegmentTreeLazy(tree, lazy, mid+1, high, startR, endR, 2*currPos+1, increment);
        tree[currPos] = Math.min(tree[2*currPos], tree[2*currPos+1]);
    }
}
