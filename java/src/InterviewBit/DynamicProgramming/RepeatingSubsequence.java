package InterviewBit.DynamicProgramming;

public class RepeatingSubsequence {

    int[][] dp;

    public static void main(String[] args) {
        String A = "AABBC";
        System.out.println(new RepeatingSubsequence().solveBottomUp(A));
        System.out.println(new RepeatingSubsequence().solveTopDown(A));
    }

    public int solveBottomUp(String A) {
        int n = A.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (A.charAt(i - 1) == A.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int res = Integer.max(dp[n - 1][n], dp[n][n - 1]);
        return res < 2 ? 0 : 1;
    }

    public int solveTopDown(String A) {
        int n = A.length();
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = -1;

        if (A.length() < 2) return 0;
        int result = solveTopDown(A, 0, 1);
        return result < 2 ? 0 : 1;
    }

    private int solveTopDown(String A, int i, int j) {
        if (i == A.length() || j == A.length()) {
            dp[i][j] = 0;
        } else if (i == j) {
            if (dp[i][j + 1] == -1) {
                solveTopDown(A, i, j + 1);
            }
            dp[i][j] = dp[i][j + 1];
        } else if (A.charAt(i) == A.charAt(j)) {
            if (dp[i + 1][j + 1] == -1) {
                solveTopDown(A, i + 1, j + 1);
            }
            dp[i][j] = 1 + dp[i + 1][j + 1];
        } else {
            if (dp[i + 1][j] == -1) {
                solveTopDown(A, i + 1, j);
            }
            if (dp[i][j + 1] == -1) {
                solveTopDown(A, i, j + 1);
            }
            dp[i][j] = Integer.max(dp[i + 1][j], dp[i][j + 1]);
        }
        return dp[i][j];
    }
}
