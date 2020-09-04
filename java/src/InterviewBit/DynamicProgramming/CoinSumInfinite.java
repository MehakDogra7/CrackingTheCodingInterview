package InterviewBit.DynamicProgramming;

/**
 * Print number of ways in O(n) space / Use DP
 */
public class CoinSumInfinite {

    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        int N = 5;
        //System.out.println(new CoinSumInfinite().solve(S, N));
        System.out.println(new CoinSumInfinite().solveBottomUp(S, N));
    }

    private int solveBottomUp(int[] A, int B) {
        int[] dp = new int[B + 1];
        dp[0] = 1;
        int mod = 1000007;

        for (int row = 0; row < A.length; row++) {
            for (int column = 1; column < B + 1; column++) {
                if (column >= A[row]) {
                    dp[column] = (dp[column] % mod + dp[column - A[row]] % mod) % mod;
                }
            }
        }
        return dp[B];
    }

   /* private int solve(int[] S, int N) {
        return solveTopDown(S, N, 0);
    }

    //TODO check topDown
    private int solveTopDown(int[] S, int N, int index) {
        if (N == 0) return 1;
        if (index == S.length || N < 0) return 0;

        if (S[index] > N) return solveTopDown(S, N, index + 1);
        return solveTopDown(S, N - S[index], index) + solveTopDown(S, N - S[index], index + 1);

    }*/
}
