package InterviewBit.DynamicProgramming.TopDownMemoization;

import java.util.Arrays;

public class BitStrings {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new BitStrings().solve(n));
        System.out.println(new BitStrings().solveReverse(n));
    }

    private int solveReverse(int A) {

        if (A == 0)
            return 0;
        if (A == 1)
            return 2;
        if (A == 2)
            return 3;


        int[] dp = new int[A];
        Arrays.fill(dp, -1);
        dp[A - 1] = 2;
        dp[A - 2] = 3;

        return recursiveReverse(0, dp);
    }

    private int recursiveReverse(int i, int[] dp) {

        if (dp[i + 1] == -1) {
            dp[i + 1] = recursiveReverse(i + 1, dp);
        }
        if (dp[i + 2] == -1) {
            dp[i + 2] = recursiveReverse(i + 1, dp);
        }
        return dp[i + 1] + dp[i + 2];
    }

    private int solve(int A) {

        if (A == 0)
            return 0;
        if (A == 1)
            return 2;
        if (A == 2)
            return 3;

        int[] dp = new int[A + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 2;
        dp[2] = 3;

        return recursive(A, dp);
    }

    private int recursive(int A, int[] dp) {

        if (dp[A - 1] == -1) {
            dp[A - 1] = recursive(A - 1, dp);
        }
        if (dp[A - 2] == -1) {
            dp[A - 2] = recursive(A - 2, dp);
        }

        return dp[A - 1] + dp[A - 2];
    }
}
