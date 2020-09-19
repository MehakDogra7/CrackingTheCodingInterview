package InterviewBit.StacksAndQueues;

import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        String[] A = {"2", "1", "+", "3", "*"};
        System.out.println(new EvaluateExpression().solve(A));
    }

    private int solve(String[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length;

        for (int i = 0; i < n; i++) {
            String currString = A[i];
            switch (currString) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-(stack.pop() - stack.pop()));
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int first = stack.pop(), second = stack.pop();
                    stack.push(second / first);
                    break;
                default:
                    stack.push(Integer.parseInt(currString));
            }

        }
        return stack.pop();
    }
}
