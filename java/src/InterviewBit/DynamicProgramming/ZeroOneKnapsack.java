package InterviewBit.DynamicProgramming;

public class ZeroOneKnapsack {

    int[][] dp;

    public static void main(String[] args) {
        int capacity = 25;
        int[] weight = {24, 18, 18, 10};
        int[] profit = {24, 10, 10, 7};
        System.out.println(new ZeroOneKnapsack().solveTopDown(capacity, weight, profit));
        System.out.println(new ZeroOneKnapsack().solveBottomUp(capacity, weight, profit));
    }

    private int solveTopDown(int capacity, int[] weight, int[] profit) {
        dp = new int[capacity + 1][weight.length];

        for (int i = 0; i < capacity + 1; i++)
            for (int j = 0; j < weight.length; j++)
                dp[i][j] = -1;

        return solveTopDown(capacity, weight, profit, 0);
    }

    private int solveTopDown(int capacity, int[] weight, int[] profit, int index) {
        if (index >= weight.length || capacity <= 0) return 0;

        if (dp[capacity][index] != -1) return dp[capacity][index];

        if (weight[index] <= capacity) {
            int consider = profit[index] + solveTopDown(capacity - weight[index], weight, profit, index + 1);
            int dontConsider = solveTopDown(capacity, weight, profit, index + 1);
            dp[capacity][index] = Integer.max(consider, dontConsider);
        } else
            dp[capacity][index] = solveTopDown(capacity, weight, profit, index + 1);
        return dp[capacity][index];
    }

    private int solveBottomUp(int capacity, int[] weight, int[] profit) {
        int[][] T = new int[weight.length + 1][capacity + 1];
        for (int i = 1; i < weight.length + 1; i++) {
            int currWeight = weight[i - 1];
            for (int currCapacity = 1; currCapacity < capacity + 1; currCapacity++) {
                if (currCapacity >= currWeight) {
                    T[i][currCapacity] = Math.max(profit[i - 1] + T[i - 1][currCapacity - currWeight], T[i - 1][currCapacity]);
                } else {
                    T[i][currCapacity] = T[i - 1][currCapacity];
                }
            }
        }

        return T[weight.length][capacity];
    }

}
