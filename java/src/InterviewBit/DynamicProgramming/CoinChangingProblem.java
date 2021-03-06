package InterviewBit.DynamicProgramming;

/**
 * Available coins: a, b, c, d : Infinite supply
 * Target total: 11
 * You need to find how many above given coins are required to make a total of target value.
 * The total selected coins must be minimum.
 */
public class CoinChangingProblem {

    public static void main(String[] args) {
        int[] coins = {1, 5, 6, 8};
        int total = 11;
        //System.out.println(new CoinChangingProblem().minimumCoinBottomUp(coins, total));
        System.out.println(new CoinChangingProblem().solve(coins, total));
    }

    private int solve(int[] coins, int total) {
        int[] dp = new int[total + 1];

        for (int i = 1; i < total + 1; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }

        for (int row = 0; row < coins.length; row++) {
            for (int column = 1; column < total + 1; column++) {
                if (column >= coins[row]) {
                    if (dp[column] > dp[column - coins[row]] + 1) {
                        dp[column] = dp[column - coins[row]] + 1;
                    }
                }
            }
        }
        return dp[total];
    }
}
