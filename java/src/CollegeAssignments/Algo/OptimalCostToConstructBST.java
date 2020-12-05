package CollegeAssignments.Algo;

public class OptimalCostToConstructBST {

    public static void main(String[] args) {
        int[] freq = {25, 10, 20};

        System.out.println("The optimal cost of constructing BST is " + findOptimalCost(freq));
    }

    private static int findOptimalCost(int[] freq) {

        int n = freq.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = freq[i];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int currCost = 0;
                for (int k = i; k <= j; k++) currCost += freq[k];
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = (i == k) ? 0 : dp[i][k - 1];
                    int right = (j == k) ? 0 : dp[k + 1][j];
                    min = Math.min(min, left + right);
                }
                dp[i][j] = currCost + min;
            }
        }

        return dp[0][n - 1];
    }
}
