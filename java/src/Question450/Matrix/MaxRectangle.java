package Question450.Matrix;

import InterviewBit.DynamicProgramming.MaxRectangleInBinaryMatrix;

import java.util.Stack;

public class MaxRectangle {

    public static void main(String[] args) {
        int[][] A = {
                {1, 1},
                {1, 1}
        };
        System.out.println(new MaxRectangleInBinaryMatrix().maximalRectangle(A));
    }

    public int maximalRectangle(int[][] A) {

        int m = A.length, n = A[0].length;
        int[] dp = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) dp[j] = 0;
                else dp[j]++;
            }
            maxArea = Math.max(maxArea, getMaxArea(dp));
        }
        return maxArea;
    }

    private int getMaxArea(int[] dp) {

        int[] nsl = getNSL(dp);
        int[] nsr = getNSR(dp);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, (nsr[i] - nsl[i] + 1) * dp[i]);
        }

        return max;
    }

    private int[] getNSR(int[] dp) {
        int n = dp.length;
        int[] nsr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int curr = dp[i];
            while (!stack.isEmpty() && dp[stack.peek()] >= curr) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsr[i] = n - 1;
            } else {
                nsr[i] = stack.peek() - 1;
            }
            stack.push(i);
        }
        return nsr;
    }

    private int[] getNSL(int[] dp) {
        int n = dp.length;
        int[] nsl = new int[n];
        nsl[n - 1] = -1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int curr = dp[i];
            while (!stack.isEmpty() && dp[stack.peek()] >= curr) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsl[i] = 0;
            } else {
                nsl[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        return nsl;
    }

}
