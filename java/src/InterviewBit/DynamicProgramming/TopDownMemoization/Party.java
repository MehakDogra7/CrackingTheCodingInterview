package InterviewBit.DynamicProgramming.TopDownMemoization;

import java.util.Arrays;

public class Party {

    static int count = 0;
    static int dpCount = 0;
    static int dpCount2 = 0;

    public static void main(String[] args) {
        new Party().solve(8);
        System.out.println("Non DP: " + count);
        System.out.println("DP: " + dpCount);
        System.out.println("DP2: " + dpCount2);
    }

    private void solve(int A) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;   //1 person can enjoy in 1 way
        dp[2] = 2;   //2 persons can enjoy in 2 ways

        System.out.println(recursive(A));
        System.out.println(recursiveDp(A, dp));

        Arrays.fill(dp, -1);
        dp[1] = 1;   //1 person can enjoy in 1 way
        dp[2] = 2;   //2 persons can enjoy in 2 ways
        System.out.println(recursiveDp2(A, dp));

    }

    //41 iterations for n = 8
    private int recursive(int A) {
        count++;
        if (A < 3)
            return A;
        return recursive(A - 1) + (A - 1) * recursive(A - 2);

    }

    //13 iterations for n = 8 -- because it will call the method then if dp array contains !-1 it will give the value
    private int recursiveDp(int A, int[] dp) {
        dpCount++;
        if (dp[A] == -1) {
            dp[A] = recursiveDp(A - 1, dp) + (A - 1) * recursiveDp(A - 2, dp);
        }

        return dp[A];
    }

    //Best Way only 6 iterations for n = 8 -- because first check the dp array if -1 then only call the method
    private int recursiveDp2(int A, int[] dp) {
        dpCount2++;

        if (dp[A - 1] == -1) {
            dp[A - 1] = recursiveDp2(A - 1, dp);
        }

        if (dp[A - 2] == -1) {
            dp[A - 2] = recursiveDp2(A - 2, dp);
        }

        return dp[A - 1] + (A - 1) * dp[A - 2];
    }
}
