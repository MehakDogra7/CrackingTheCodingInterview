package Question450.StacksAndQueues;

import java.util.Stack;

public class StackPermutation {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {4, 3, 2, 1, 5};
        System.out.println(new StackPermutation().validateStackSequences(A, B));
    }

    private boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        for (i = 0; i < n; i++) {
            if (pushed[i] == popped[j]) j++;
            else {
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
                stack.push(pushed[i]);
            }
        }
        while (!stack.isEmpty() && stack.peek() == popped[j]) {
            stack.pop();
            j++;
        }

        return j == n;
    }
}
