package InterviewBit.DynamicProgramming;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String A = "xabyaz";
        System.out.println(new LongestPalindromicSubsequence().solve(A));
    }

    private int solve(String A) {
        int n = A.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[i][n] = 0;
        }

        for (int i = 1; i <= n; i++)
            for (int j = n - 1; j >= 0; j--)
                if (A.charAt(i - 1) == A.charAt(j))
                    dp[i][j] = 1 + dp[i - 1][j + 1];
                else
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j + 1]);

        return dp[n][0];
    }
}
