package InterviewBit.DynamicProgramming;

public class UniquePathsInAGrid {
    int[][] dp;

    public static void main(String[] args) {
        int[][] A = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(new UniquePathsInAGrid().uniquePathsWithObstacles(A));
    }

    public int uniquePathsWithObstacles(int[][] A) {
        int m = A.length, n = A[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        return solveRecursive(A, 0, 0);
    }

    private int solveRecursive(int[][] A, int i, int j) {
        if (dp[i][j] != -1) return dp[i][j];
        if (A[i][j] == 1) return 0;
        if (i == A.length - 1 && j == A[0].length - 1) return 1;

        if (i == A.length - 1) dp[i][j] = solveRecursive(A, i, j + 1);
        else if (j == A[0].length - 1) dp[i][j] = solveRecursive(A, i + 1, j);
        else dp[i][j] = solveRecursive(A, i, j + 1) + solveRecursive(A, i + 1, j);

        return dp[i][j];
    }
}
