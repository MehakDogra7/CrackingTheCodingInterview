package InterviewBit.Strings;

import java.util.Stack;

public class MinimumParantheses {

    public static void main(String[] args) {
        System.out.println(new MinimumParantheses().solve("(("));
    }

    private int solve(String A) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < A.length(); i++) {
            if ('(' == A.charAt(i)) {
                stack.push(A.charAt(i));
            } else if (')' == A.charAt(i)) {
                if (stack.empty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }

        count += stack.size();
        return count;
    }
}
