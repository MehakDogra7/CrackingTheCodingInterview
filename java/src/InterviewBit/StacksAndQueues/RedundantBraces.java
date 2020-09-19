package InterviewBit.StacksAndQueues;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {
        String A = "((a+b)*((b+c)/d))";
        System.out.println(new RedundantBraces().solve(A));
    }

    /*private int solve(String A) {
        Stack<Character> stack = new Stack<>();
        int n = A.length();

        for (int i = 0; i < n; i++) {
            char curr = A.charAt(i);
            if (curr == '(') {
                if (!stack.isEmpty() && A.charAt(i - 1) == '(') {
                    stack.push('t');
                }
                stack.push(curr);
            } else if (curr == ')') {
                if (stack.isEmpty()) return 1;
                stack.pop();
                if (i != n - 1 && A.charAt(i + 1) == ')') {
                    if (stack.peek() == 't') return 1;
                }
                if (!stack.isEmpty() && stack.peek() == 't') stack.pop();
            }
        }

        return 0;
    }*/

    private int solve(String A) {
        Stack<Character> stack = new Stack<>();
        Set<Character> operators = new HashSet<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        int n = A.length();

        for (int i = 0; i < n; i++) {
            char curr = A.charAt(i);
            if (curr == '(') {
                stack.push(curr);
                stack.push('1');
            } else if (curr == ')') {
                if (stack.peek() == '1') return 1;
                stack.pop();
            } else if (operators.contains(curr)) {
                if (!stack.isEmpty() && stack.peek() == '1') stack.pop();
            }
        }

        return 0;
    }
}
