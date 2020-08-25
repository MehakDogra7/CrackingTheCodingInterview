package InterviewBit.DynamicProgramming;

import java.util.Arrays;

public class MinJumpsArray {

    public static void main(String[] args) {
        int[] A = {35, 25, 0, 9, 43, 39, 46, 20, 31, 22, 0, 42, 27, 27, 13, 0, 0, 38, 0, 48, 32, 46, 0, 46, 0, 0, 45, 42, 0, 10, 36, 15, 50};
        System.out.println(new MinJumpsArray().solveDP(A));
        System.out.println(new MinJumpsArray().solveGreedy(A));
    }

    private int solveGreedy(int[] A) {
        if (A.length == 0 || (A[0] == 0 && A.length != 1)) return -1;
        if (A.length == 1) return 0;

        int n = A.length, maxReach = A[0], steps = A[0], jumpResult = 1;

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumpResult;
            maxReach = Integer.max(maxReach, i + A[i]);
            steps--;
            if (steps == 0) {
                jumpResult++;
                if (i >= maxReach) return -1;
                steps = maxReach - i;
            }
        }
        return -1;
    }

    private int solveDP(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int currMaxJump = A[i];
            for (int j = Integer.min(currMaxJump, n - 1); j > 0; j--) {
                if ((i + j) < n && dp[i + j] != Integer.MAX_VALUE) {
                    dp[i] = Integer.min(dp[i], dp[i + j] + 1);
                }
            }
        }
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }
}
