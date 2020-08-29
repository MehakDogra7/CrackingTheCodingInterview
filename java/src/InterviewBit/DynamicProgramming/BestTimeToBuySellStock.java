package InterviewBit.DynamicProgramming;

public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        int[] A = {2, 5, 7, 1, 4, 3, 1, 3};
        int B = 100000089;
        System.out.println(new BestTimeToBuySellStock().solve(A, B));
    }

    private int solve(int[] A, int B) {
        
        int[][] dp = new int[B + 1][A.length + 1];

        for (int i = 1; i < B + 1; i++) {
            int maxDiff = dp[i - 1][0] - A[0];
            for (int j = 1; j < A.length + 1; j++) {
                dp[i][j] = Integer.max(dp[i][j - 1], A[j - 1] + maxDiff);
                maxDiff = Integer.max(maxDiff, dp[i - 1][j] - A[j - 1]);
            }
        }
        return dp[B][A.length];
    }
}
