package InterviewBit.DynamicProgramming;

public class TusharsBirthdayParty {

    int[][] dp;

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5, 4};
        int[] B = {3, 2, 4, 1};
        int[] C = {1, 2, 5, 10};
        System.out.println(new TusharsBirthdayParty().solve(A, B, C));
    }

    public int solve(final int[] A, final int[] B, final int[] C) {
        int cost = 0, maxA = A[0];
        for (int cap : A) {
            maxA = Math.max(maxA, cap);
        }
        dp = new int[B.length][maxA + 1];
        for (int m = 0; m < B.length; m++)
            for (int n = 0; n < maxA + 1; n++)
                dp[m][n] = -1;

        for (int i = 0; i < A.length; i++) {
            int currCapacity = A[i];
            cost += knapsack(B, C, currCapacity, 0);
        }
        return cost;
    }

    private int knapsack(int[] weight, int[] cost, int capacity, int index) {
        if (capacity == 0) return 0;
        if (index == weight.length) return Integer.MAX_VALUE;

        if (dp[index][capacity] != -1) return dp[index][capacity];

        int min = Integer.MAX_VALUE;
        if (weight[index] > capacity) {
            min = knapsack(weight, cost, capacity, index + 1);
        } else {
            int considerAndBeOnSame = knapsack(weight, cost, capacity - weight[index], index);
            if (considerAndBeOnSame != Integer.MAX_VALUE)
                min = cost[index] + considerAndBeOnSame;
            int considerAndNext = knapsack(weight, cost, capacity - weight[index], index + 1);
            if (considerAndNext != Integer.MAX_VALUE)
                min = Integer.min(min, cost[index] + considerAndNext);
            int dontConsider = knapsack(weight, cost, capacity, index + 1);
            if (dontConsider != Integer.MAX_VALUE)
                min = Integer.min(min, dontConsider);
        }

        return dp[index][capacity] = min;
    }

}
