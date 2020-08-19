package InterviewBit.DynamicProgramming;

public class RegularExpressionMatch {

    Boolean[][] dp;

    public static void main(String[] args) {
        String A = "bacb";
        String B = "b**c*?*";
        System.out.println(new RegularExpressionMatch().solveTopDown(A, B));
        System.out.println(new RegularExpressionMatch().solveBottomUp(A, B));
    }

    private int solveBottomUp(String A, String B) {
        int m = A.length();
        int n = B.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int row = 0; row < m + 1; row++)
            dp[row][0] = false;

        dp[0][0] = true;
        for (int column = 1; column < n + 1; column++) {
            if (B.charAt(column - 1) == '*')
                dp[0][column] = dp[0][column - 1];
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (B.charAt(j - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
                else dp[i][j] = false;
            }
        }
        return dp[m][n] ? 1 : 0;
    }

    private int solveTopDown(String A, String B) {
        int m = A.length();
        int n = B.length();
        dp = new Boolean[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            for (int j = 0; j < n + 1; j++)
                dp[i][j] = null;
        return solveTopDown(A, B, 0, 0) ? 1 : 0;
    }

    private Boolean solveTopDown(String A, String B, int i, int j) {
        if (i == A.length() && j == B.length())
            dp[i][j] = true;
        else if (i == A.length()) {
            if (B.charAt(j) == '*') {
                if (dp[i][j + 1] == null)
                    solveTopDown(A, B, i, j + 1);
                dp[i][j] = dp[i][j + 1];
            } else dp[i][j] = false;
        } else if (j == B.length())
            dp[i][j] = false;
        else if (A.charAt(i) == B.charAt(j) || B.charAt(j) == '?') {
            if (dp[i + 1][j + 1] == null)
                solveTopDown(A, B, i + 1, j + 1);
            dp[i][j] = dp[i + 1][j + 1];
        } else if (B.charAt(j) == '*') {
            if (dp[i + 1][j] == null)
                solveTopDown(A, B, i + 1, j);
            if (dp[i + 1][j + 1] == null)
                solveTopDown(A, B, i + 1, j + 1);
            if (dp[i][j + 1] == null)
                solveTopDown(A, B, i, j + 1);
            dp[i][j] = dp[i + 1][j] || dp[i + 1][j + 1] || dp[i][j + 1];
        } else
            dp[i][j] = false;

        return dp[i][j];
    }
}
