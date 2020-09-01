package InterviewBit.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class IntersectionChordsINaCircle {
    Map<Integer, Integer> dp = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new IntersectionChordsINaCircle().solveBottomUp(22));
    }

    private int solveBottomUp(int A) {
        int n = 2 * A;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 4; i <= n; i += 2) {
            for (int j = 0; j < i - 1; j += 2) {
                dp[i] += ((dp[j] * dp[i - 2 - j]));
                dp[i] = dp[i] % 1000000007;
            }
        }

        return (int) dp[n] % 1000000007;

    }
}
