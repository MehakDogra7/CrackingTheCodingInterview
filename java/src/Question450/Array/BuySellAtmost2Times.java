package Question450.Array;

public class BuySellAtmost2Times {

    public static void main(String[] args) {
        int[] A = {1, 2};
        System.out.println(new BuySellAtmost2Times().solve(A));
        System.out.println(new BuySellAtmost2Times().solveOptimal(A));
    }

    private int solve(int[] price) {
        int n = price.length;
        int[][] dp = new int[3][n + 1];

        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < n + 1; j++) {
                int DontconsiderJthDay = dp[i][j - 1];
                int considerJthDay = Integer.MIN_VALUE;
                for (int m = 1; m <= j - 1; m++) {
                    considerJthDay = Math.max(considerJthDay, price[j - 1] - price[m - 1] + dp[i - 1][m]);
                }
                dp[i][j] = Math.max(DontconsiderJthDay, considerJthDay);
            }
        }

        return dp[2][n];
    }

    private int solveOptimal(int[] price) {
        if (price.length < 2) return 0;
        int n = price.length;
        int[][] dp = new int[3][n + 1];

        for (int i = 1; i < 3; i++) {
            int maxDiff = -price[0];
            for (int j = 1; j < n + 1; j++) {
                int DontconsiderJthDay = dp[i][j - 1];
                int considerJthDay = maxDiff + price[j - 1];
                dp[i][j] = Math.max(DontconsiderJthDay, considerJthDay);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - price[j - 1]);
            }
        }

        return dp[2][n];
    }
}
