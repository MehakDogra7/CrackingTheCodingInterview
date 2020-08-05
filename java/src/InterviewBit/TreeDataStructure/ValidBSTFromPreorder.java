package InterviewBit.TreeDataStructure;

import java.util.Stack;

public class ValidBSTFromPreorder {

    public static void main(String[] args) {
        int[] A = {7, 7, 10, 10, 9, 5, 2, 8};

        System.out.println(new ValidBSTFromPreorder().solve(A));
    }

    private int solve(int[] preOrder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < preOrder.length; i++) {
            int currElement = preOrder[i];
            if (currElement < root) return 0;
            else while (!stack.isEmpty() && currElement > stack.peek()) {
                root = stack.pop();
            }
            stack.push(currElement);
        }
        return 1;
    }
}
