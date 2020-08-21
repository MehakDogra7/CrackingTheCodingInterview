package InterviewBit.DynamicProgramming;

import java.util.Arrays;

public class LengthOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] A = {3, 4, -1, 0, 6, 2, 3};
        System.out.println(new LengthOfLongestIncreasingSubsequence().solve(A));
    }

    private int solve(int[] A) {
        if (A.length == 0) return 0;

        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (A[i] > A[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;

        for (int i = 0; i < n; i++)
            max = Integer.max(max, dp[i]);

        return max;
    }
}
