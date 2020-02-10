import java.util.Scanner;

public class CharliePilots {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] captain = new int[n];
        int[] assistant = new int[n];
        for (int i = 0; i < n; i++){
            captain[i] = in.nextInt();
            assistant[i] = in.nextInt();
        }
        int difference = 0;
        System.out.println(cost(assistant, n, difference, captain, 0, 0));
    }

    public static int cost (int[] assistant, int n, int difference, int[] captain, int i, int j){
        if (difference == 0){
            return assistant[i] + cost(assistant, n-1, 1, captain, i+ 1, j + 1);
        }
        if (difference == n){
            return captain[j] + cost(assistant, n-1, difference -  1, captain, i+1, j+1);
        }
        else{
            return Math.min(assistant[i] + cost(assistant, n-1, difference - 1, captain, i+ 1, j + 1), captain[j] + cost(assistant, n-1, difference +  1, captain, i+1, j+1));
        }
    }
}
