package InterviewBit.DynamicProgramming;

public class InterleavingStrings {

    int[][] dp;

    public static void main(String[] args) {
        String A = "aabcc";
        String B = "dbbca";
        String C = "aadbbcbcac";

        System.out.println(new InterleavingStrings().solve(A, B, C));
    }

    private int solve(String A, String B, String C) {
        int m = A.length();
        int n = B.length();
        dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            for (int j = 0; j < n + 1; j++)
                dp[i][j] = -1;
        return solveTopDown(A, B, C, 0, 0, 0);
    }

    private int solveTopDown(String A, String B, String C, int i, int j, int k) {
        if (k == C.length())
            dp[i][j] = 1;
        else if (i == A.length() && j == B.length())
            dp[i][j] = 0;
        else if (i == A.length()) {
            if (B.charAt(j) != C.charAt(k)) {
                dp[i][j] = 0;
            } else {
                if (dp[i][j + 1] == -1) {
                    solveTopDown(A, B, C, i, j + 1, k + 1);
                }
                dp[i][j] = dp[i][j + 1];
            }
        } else if (j == B.length()) {
            if (A.charAt(i) != C.charAt(k)) {
                dp[i][j] = 0;
            } else {
                if (dp[i + 1][j] == -1) {
                    solveTopDown(A, B, C, i + 1, j, k + 1);
                }
                dp[i][j] = dp[i + 1][j];
            }
        } else if (A.charAt(i) != C.charAt(k) && B.charAt(j) != C.charAt(k)) {
            dp[i][j] = 0;
        } else if (A.charAt(i) == C.charAt(k) && B.charAt(j) == C.charAt(k)) {
            if (dp[i + 1][j] == -1) {
                solveTopDown(A, B, C, i + 1, j, k + 1);
            }
            if (dp[i][j + 1] == -1) {
                solveTopDown(A, B, C, i, j + 1, k + 1);
            }
            dp[i][j] = dp[i + 1][j] | dp[i][j + 1];
        } else if (A.charAt(i) == C.charAt(k)) {
            if (dp[i + 1][j] == -1) {
                solveTopDown(A, B, C, i + 1, j, k + 1);
            }
            dp[i][j] = dp[i + 1][j];
        } else {
            if (dp[i][j + 1] == -1) {
                solveTopDown(A, B, C, i, j + 1, k + 1);
            }
            dp[i][j] = dp[i][j + 1];
        }
        return dp[i][j];
    }
}
