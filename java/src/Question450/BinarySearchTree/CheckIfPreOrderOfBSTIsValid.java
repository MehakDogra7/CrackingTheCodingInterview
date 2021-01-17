package Question450.BinarySearchTree;

import java.util.Stack;

public class CheckIfPreOrderOfBSTIsValid {

    public static void main(String[] args) {
        int[] pre = {4, 5, 6, 2, 10, 9};
        System.out.println(new CheckIfPreOrderOfBSTIsValid().solve(pre));
    }

    private boolean solve(int[] pre) {
        int n = pre.length;
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int curr = pre[i];
            if (curr < root) return false;
            while (!stack.isEmpty() && curr > stack.peek()) {
                root = stack.pop();
            }
            stack.push(curr);
        }
        return true;
    }
}
