import java.util.Scanner;

public class LargestBitonicSubarray {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }
        int[] longest_increasing_subsequence = longestIncreasingSubsequence(input, n);
        int[] longest_decreasing_subsequence = longestDecreasingSubsequence(input, n);

        int best = 0;
        for (int i = 0; i < n; i++) {
            int possibleAnswer = longest_increasing_subsequence[i] + longest_decreasing_subsequence[i] - 1;
            if (best < possibleAnswer) {
                best = possibleAnswer;
            }
        }
        int largestBitonicSubarray = best;
        System.out.println(largestBitonicSubarray);
    }

    public static int[] longestIncreasingSubsequence(int[] input, int n) {
        int[] longest_increasing_subsequence = new int[n];
        longest_increasing_subsequence[0] = 1;

        for (int i = 1; i < n; i++) {
            longest_increasing_subsequence[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (input[j] > input[i]) {
                    continue;
                }
                int possibleAns = longest_increasing_subsequence[j] + 1;
                if (possibleAns > longest_increasing_subsequence[i]) {
                    longest_increasing_subsequence[i] = possibleAns;
                }
            }
        }

        return longest_increasing_subsequence;
    }

    public static int[] longestDecreasingSubsequence(int[] input, int n) {
        int[] longest_decreasing_subsequence = new int[n];

        for (int i = 0; i < n; i++) {
            longest_decreasing_subsequence[i] = 1;
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (input[i] > input[j] && longest_decreasing_subsequence[i] < longest_decreasing_subsequence[j] + 1) {
                    longest_decreasing_subsequence[i] = longest_decreasing_subsequence[j] + 1;
                }
            }
        }

        return longest_decreasing_subsequence;
    }
}
