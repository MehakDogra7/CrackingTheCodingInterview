package InterviewBit.StacksAndQueues;

import java.util.Stack;

public class BalancedParantheses {

    public static void main(String[] args) {
        String A = "(()())";
        System.out.println(new BalancedParantheses().solve(A));
    }

    public int solve(String A) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);
            if (curr == '(') stack.push(curr);
            else {
                if (stack.isEmpty()) return 0;
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
