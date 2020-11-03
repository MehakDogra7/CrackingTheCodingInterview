package InterviewBit.DynamicProgramming;

import java.util.Stack;

public class MaxRectangleInBinaryMatrix {
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

    /*public int maximalRectangle(int[][] A) { // m X n matrix
        int m = A.length, n = A[0].length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = A[0][i];
        }
        int maxArea = getMaxArea(temp);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0)
                    temp[j] = 0;
                else
                    temp[j] += 1;
            }
            maxArea = Integer.max(maxArea, getMaxArea(temp));
        }
        return maxArea;
    }

    private int getMaxArea(int[] temp) {
        if (temp.length == 0) return 0;
        if (temp.length == 1) return temp[0];
        int top = 0, area = temp[0];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i;
        for (i = 1; i < temp.length; i++) {
            if (!stack.isEmpty() && temp[stack.peek()] <= temp[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temp[stack.peek()] > temp[i]) {
                    top = stack.pop();
                    if (stack.isEmpty())
                        area = Integer.max(area, temp[top] * i);
                    else
                        area = Integer.max(area, temp[top] * (i - stack.peek() - 1));
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            top = stack.pop();
            if (stack.isEmpty())
                area = Integer.max(area, temp[top] * i);
            else
                area = Integer.max(area, temp[top] * (i - stack.peek() - 1));
        }
        return area;
    }*/

}
