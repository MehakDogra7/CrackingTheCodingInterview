package InterviewBit.DynamicProgramming;

public class MaxSumWithoutAdjacentElements {

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4},
                {2, 3, 4, 5}};
        System.out.println(new MaxSumWithoutAdjacentElements().adjacent(A));
    }

    public int adjacent(int[][] A) {
        int[] temp = new int[A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            temp[i] = Math.max(A[0][i], A[1][i]);
        }
        if (temp.length == 1) return temp[0];

        int[] dp = new int[temp.length];
        dp[0] = temp[0];
        dp[1] = Math.max(temp[1], dp[0]);

        for (int i = 2; i < temp.length; i++) {
            dp[i] = Math.max(temp[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[temp.length - 1];
    }
}
