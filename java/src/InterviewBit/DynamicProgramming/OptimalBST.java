package InterviewBit.DynamicProgramming;

public class OptimalBST {

    public static void main(String[] args) {
        int[] key = {10, 12, 16, 21};
        int[] cost = {4, 2, 6, 3};

        System.out.println(new OptimalBST().getMinimumCost(key, cost));
    }

    private int getMinimumCost(int[] key, int[] cost) {
        int n = key.length;
        Node[][] dp = new Node[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Node();
            }
        }

        for (int len = 1; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int currCost = 0;
                for (int k = i; k <= j; k++) currCost += cost[k];
                int min = Integer.MAX_VALUE, root = -1;
                for (int k = i; k <= j; k++) {
                    int temp = (k == i ? 0 : dp[i][k - 1].cost) + (k == j ? 0 : dp[k + 1][j].cost);
                    if (min > temp) {
                        min = temp;
                        root = k;
                    }
                }
                dp[i][j].cost = currCost + min;
                dp[i][j].root = root;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j].cost + ", " + dp[i][j].root + "   ");
            }
            System.out.println();
        }
        System.out.println();

        return dp[0][n - 1].cost;
    }

    static class Node {
        int root, cost;
    }
}
