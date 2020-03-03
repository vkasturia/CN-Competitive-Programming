import java.util.Scanner;

class MaxXORSubarrayTrie {
    static final int INT_SIZE = 32;

    static class TrieNode {
        int value;  // Only used in leaf nodes 
        TrieNode[] arr =  new TrieNode[2];
        public TrieNode() {
            value = 0;
            arr[0] = null;
            arr[1] = null;
        }
    }
    static TrieNode root;

    static void insert(int pre_xor) {
        TrieNode temp = root;
        for (int i=INT_SIZE-1; i>=0; i--)
        {
            int val = (pre_xor & (1<<i)) >=1 ? 1 : 0;
            if (temp.arr[val] == null)
                temp.arr[val] = new TrieNode();
            temp = temp.arr[val];
        }
        temp.value = pre_xor;
    }

    static int query(int pre_xor) {
        TrieNode temp = root;
        for (int i=INT_SIZE-1; i>=0; i--) {
            int val = (pre_xor & (1<<i)) >= 1 ? 1 : 0;
            // Traverse Trie, first look for a 
            // prefix that has opposite bit 
            if (temp.arr[1-val] != null)
                temp = temp.arr[1-val];
                // If there is no prefix with opposite
                // bit, then look for same bit.
            else if (temp.arr[val] != null)
                temp = temp.arr[val];
        }
        return pre_xor^(temp.value);
    }

    // Returns maximum XOR value of a subarray in  
    // arr[0..n-1]
    static int maxSubarrayXOR(int arr[], int n)
    {
        // Create a Trie and insert 0 into it 
        root = new TrieNode();
        insert(0);

        // Initialize answer and xor of current prefix 
        int result = Integer.MIN_VALUE;
        int pre_xor =0;

        // Traverse all input array element 
        for (int i=0; i<n; i++) {
            // update current prefix xor and insert it  
            // into Trie
            pre_xor = pre_xor^arr[i];
            insert(pre_xor);

            // Query for current prefix xor in Trie and  
            // update result if required 
            result = Math.max(result, query(pre_xor));
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(maxSubarrayXOR(arr, n));
    }
} 