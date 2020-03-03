public class XORMaximumPair {
    public static void main(String[] args){
        int[] arr = {8, 1, 2, 15, 10, 5};
        trieNode head = new trieNode();
        for (int i = 0; i < 6; i++){
            insert(arr[i], head);
        }
        System.out.println(findMaxXorPair(head, arr, arr.length));
    }

    public static void insert(int n, trieNode head){
        trieNode current = head;
        for (int i = 31; i >=0; i--){
            int b = (n>>i)&1;
            if (b == 0){
                if (current.left == null){
                    current.left = new trieNode();
                }
                current = current.left;
            } else{
                if (current.right == null){
                    current.right = new trieNode();
                }
                current = current.right;
            }
        }
    }

    public static int findMaxXorPair(trieNode head, int[] arr, int n){
        int max_xor = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            trieNode current = head;
            int value = arr[i];
            int curr_xor = 0;
            for (int j = 31; j >=0; j--){
                int b = (value>>j)&1;
                if (b==0){
                    if (current.right != null) {
                        curr_xor += Math.pow(2, j);
                        current = current.right;
                    }
                    else{
                        current = current.left;
                    }
                } else{
                    if (current.left != null) {
                        curr_xor += Math.pow(2, j);
                        current = current.left;
                    }
                    else{
                        current = current.right;
                    }
                }
            }
            if (curr_xor > max_xor){
                max_xor = curr_xor;
            }
        }
        return max_xor;
    }
}

class trieNode{
    trieNode left;
    trieNode right;
}
