package InterviewBit.DynamicProgramming;

public class BurstBalloonProblem {

    public static void main(String[] args) {
        int[] A = {3, 1, 5, 8};
        System.out.println(new BurstBalloonProblem().solve(A));
    }

    private int solve(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int left = i == 0 ? 1 : A[i - 1];
                    int right = j == n - 1 ? 1 : A[j + 1];

                    int before = i == k ? 0 : dp[i][k - 1];
                    int after = j == k ? 0 : dp[k + 1][j];
                    dp[i][j] = Integer.max(dp[i][j], before + after + left * A[k] * right);
                }
            }
        }
        return dp[0][n - 1];
    }
}
