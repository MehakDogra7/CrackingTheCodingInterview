package InterviewBit.DynamicProgramming;

public class MinSumPathInMatrix {
    int[][] dp;

    public static void main(String[] args) {
        int[][] A = {
                {1, 3, 2},
                {4, 3, 1},
                {5, 6, 1}
        };
        System.out.println(new MinSumPathInMatrix().minPathSum(A));
    }

    public int minPathSum(int[][] A) {
        int m = A.length, n = A[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = Integer.MAX_VALUE;
        return solve(A, 0, 0);
    }

    private int solve(int[][] A, int i, int j) {
        if (i == A.length - 1 && j == A[0].length - 1) return A[i][j];

        if (i == A.length - 1) return A[i][j] + solve(A, i, j + 1);
        if (j == A[0].length - 1) return A[i][j] + solve(A, i + 1, j);

        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        dp[i][j] = A[i][j] + Integer.min(solve(A, i, j + 1), solve(A, i + 1, j));

        return dp[i][j];
    }
}
