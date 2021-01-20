package Question450.StacksAndQueues;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {
        String A = "((a + b))";
        System.out.println(new RedundantBraces().braces(A));
    }

    private int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);
            if (curr != ')') stack.push(curr);
            else {
                int count = 0;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    count++;
                    stack.pop();
                }
                if (count < 2 || stack.isEmpty()) return 1;
                stack.pop();
            }
        }

        return 0;
    }
}
