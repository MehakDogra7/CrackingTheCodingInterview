package Question450.StacksAndQueues;

import java.util.Stack;

public class EvaluatePostfixExpression {

    public static void main(String[] args) {
        String S = "231*+9-";
        System.out.println(evaluatePostFix(S));
    }

    public static int evaluatePostFix(String S) {
        // Your code here
        Stack<Integer> operandStack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char currChar = S.charAt(i);
            int curr = currChar - 48;
            if (curr >= 0 && curr <= 9) operandStack.push(curr);
            else {
                int b = operandStack.pop();
                int a = operandStack.pop();
                if (currChar == '*') operandStack.push(a * b);
                else if (currChar == '/') operandStack.push(a / b);
                else if (currChar == '+') operandStack.push(a + b);
                else operandStack.push(a - b);
            }
        }

        return operandStack.pop();
    }
}
