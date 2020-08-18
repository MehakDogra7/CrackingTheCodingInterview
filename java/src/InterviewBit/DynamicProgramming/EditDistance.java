package InterviewBit.DynamicProgramming;

public class EditDistance {

    int[][] dp;

    public static void main(String[] args) {
        String A = "abcd";
        String B = "abed";

        System.out.println(new EditDistance().solveTopDown(A, B));
        System.out.println(new EditDistance().solveBottomUp(A, B));
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

    private int solveBottomUp(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Integer.min(Integer.min(insert, delete), replace);
                }
            }
        }
        return dp[m][n];
    }

    private int solveTopDown(String A, String B, int i, int j) {
        if (i == A.length())
            dp[i][j] = B.length() - j;
        else if (j == B.length())
            dp[i][j] = A.length() - i;
        else if (A.charAt(i) == B.charAt(j)) {
            if (dp[i + 1][j + 1] == -1)
                solveTopDown(A, B, i + 1, j + 1);
            dp[i][j] = dp[i + 1][j + 1];
        } else {
            if (dp[i][j + 1] == -1)
                solveTopDown(A, B, i, j + 1);
            if (dp[i + 1][j] == -1)
                solveTopDown(A, B, i + 1, j);
            if (dp[i + 1][j + 1] == -1)
                solveTopDown(A, B, i + 1, j + 1);

            int insert = dp[i][j + 1];
            int delete = dp[i + 1][j];
            int replace = dp[i + 1][j + 1];
            dp[i][j] = 1 + Integer.min(Integer.min(insert, delete), replace);
        }
        return dp[i][j];
    }
}
