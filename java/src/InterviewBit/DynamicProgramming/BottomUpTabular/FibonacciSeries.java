package InterviewBit.DynamicProgramming.BottomUpTabular;

import java.util.Arrays;

public class FibonacciSeries {

    public static void main(String[] args) {
        int n = 7;

        System.out.println(new FibonacciSeries().get(n));
    }

    private int get(int n) {

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
