package InterviewBit.DynamicProgramming;

public class DistinctSubsequences {

    int[][] dp;

    public static void main(String[] args) {
        String A = "babgbag";
        String B = "bag";
        System.out.println(new DistinctSubsequences().solveTopDown(A, B));
        System.out.println(new DistinctSubsequences().solveBottomUp(A, B));
    }

    private int solveBottomUp(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < n + 1; i++)
            dp[0][i] = 0;
        for (int i = 0; i < m + 1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[m][n];
    }

    private int solveTopDown(String A, String B) {
        int m = A.length();
        int n = B.length();
        dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            for (int j = 0; j < n + 1; j++)
                dp[i][j] = -1;

        return solveTopDown(A, B, 0, 0);
    }

    private int solveTopDown(String A, String B, int i, int j) {
        if (j == B.length())
            dp[i][j] = 1;
        else if (i == A.length())
            dp[i][j] = 0;
        else if (A.charAt(i) == B.charAt(j)) {
            if (dp[i + 1][j + 1] == -1) {
                solveTopDown(A, B, i + 1, j + 1);
            }
            if (dp[i + 1][j] == -1) {
                solveTopDown(A, B, i + 1, j);
            }
            dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
        } else {
            if (dp[i + 1][j] == -1) {
                solveTopDown(A, B, i + 1, j);
            }
            dp[i][j] = dp[i + 1][j];
        }
        return dp[i][j];
    }
}
