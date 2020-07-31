package InterviewBit.DynamicProgramming.TopDownMemoization;

import java.util.Arrays;

public class FibonacciSeries {

    public static void main(String[] args) {
        int n = 7;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(new FibonacciSeries().get(n, dp));
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
