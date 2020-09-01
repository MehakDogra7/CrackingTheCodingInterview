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

    public int maximalRectangle(int[][] A) { // m X n matrix
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
    }
}
