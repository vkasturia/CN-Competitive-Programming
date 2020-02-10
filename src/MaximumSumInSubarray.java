import java.util.Scanner;

public class MaximumSumInSubarray {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        Node[] tree = new Node[4*n];
        buildTree(arr, tree, 1, 0, n-1);

        int queries = in.nextInt();
        while (queries > 0){
            int left = in.nextInt()-1;
            int right = in.nextInt()-1;
            Node ans = query(tree, 0, n-1, 1, left, right);
            System.out.println(ans.maxSubarraySum);
            queries--;
        }
    }

    public static void buildTree(int[] arr, Node[] tree, int treeNode, int start, int end){
        if (start == end){
            tree[treeNode] = new Node();
            tree[treeNode].totalSum = arr[start];
            tree[treeNode].maxSuffixSum = arr[start];
            tree[treeNode].maxPrefixSum = arr[start];
            tree[treeNode].maxSubarraySum = arr[start];
            return;
        }
        int mid = (start + end) / 2;

        buildTree(arr, tree, 2 * treeNode, start, mid);
        buildTree(arr, tree, 2 * treeNode + 1, mid+1, end);
        Node leftChild = tree[2 * treeNode];
        Node rightChild = tree[2 * treeNode + 1];
        tree[treeNode] = new Node();
        tree[treeNode].maxPrefixSum = Math.max(leftChild.maxPrefixSum, leftChild.totalSum + rightChild.maxPrefixSum);
        tree[treeNode].maxSuffixSum = Math.max(rightChild.maxSuffixSum, rightChild.totalSum + leftChild.maxSuffixSum);
        tree[treeNode].totalSum = leftChild.totalSum + rightChild.totalSum;
        tree[treeNode].maxSubarraySum = Math.max(leftChild.maxSubarraySum, Math.max(rightChild.maxSubarraySum, leftChild.maxSuffixSum + rightChild.maxPrefixSum));
        return;
    }

    public static Node query(Node[] tree, int start, int end, int treeNode, int left, int right){
        if(start>right || end<left){
            Node ans = new Node();
            ans.maxPrefixSum = -15100;
            ans.maxSuffixSum = -15100;
            ans.totalSum = 0;
            ans.maxSubarraySum = -15100;
            return ans;
        }

        if (start >= left && end <= right)
            return tree[treeNode];

        int mid = (start+end)/2;
        Node ans1 = query(tree, start, mid, 2*treeNode, left, right);
        Node ans2 = query(tree, mid+1, end, 2*treeNode+1, left, right);
        Node ans = new Node();
        ans.maxPrefixSum = Math.max(ans1.maxPrefixSum, ans1.totalSum + ans2.maxPrefixSum);
        ans.maxSuffixSum = Math.max(ans2.maxSuffixSum, ans2.totalSum + ans1.maxSuffixSum);
        ans.totalSum = ans1.totalSum + ans2.totalSum;
        ans.maxSubarraySum = Math.max(ans1.maxSubarraySum, Math.max(ans2.maxSubarraySum, ans1.maxSuffixSum + ans2.maxPrefixSum));
        return ans;
    }
}

class Node{
    public int maxPrefixSum;
    public int maxSuffixSum;
    public int totalSum;
    public int maxSubarraySum;
    public Node(){
        maxPrefixSum = -15100;
        maxSuffixSum = -15100;
        totalSum = 0;
        maxSubarraySum = -15100;
    }
}