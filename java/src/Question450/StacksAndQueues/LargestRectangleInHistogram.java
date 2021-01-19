package Question450.StacksAndQueues;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];

        int n = heights.length, maxArea = 0;
        int[] left = generateNSL(heights, n);
        int[] right = generateNSR(heights, n);

        for (int i = 0; i < n; i++)
            maxArea = Math.max(maxArea, heights[i] * ((right[i] - left[i]) - 1));


        return maxArea;
    }

    private int[] generateNSR(int[] heights, int n) {
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            int curr = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= curr) stack.pop();
            if (stack.isEmpty()) right[i] = n;
            else right[i] = stack.peek();
            stack.push(i);
        }
        return right;
    }

    private int[] generateNSL(int[] heights, int n) {
        int[] left = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= curr) stack.pop();
            if (stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();
            stack.push(i);
        }
        return left;
    }
}
