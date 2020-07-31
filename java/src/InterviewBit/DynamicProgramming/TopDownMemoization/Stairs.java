package InterviewBit.DynamicProgramming.TopDownMemoization;

import java.util.Arrays;

public class Stairs {

    public static void main(String[] args) {

        System.out.println(new Stairs().climbStairs(4));
    }

    public int climbStairs(int A) {
        if (A < 2)
            return A;

        int[] dp = new int[A + 2];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        return get(A + 1, dp);
    }

    private int get(int n, int[] dp) {
        if (dp[n - 1] == -1) {
            dp[n - 1] = get(n - 1, dp);
        }
        if (dp[n - 2] == -1) {
            dp[n - 2] = get(n - 2, dp);
        }

        return dp[n - 1] + dp[n - 2];
    }
}
