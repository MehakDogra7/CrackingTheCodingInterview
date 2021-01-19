package Question450.StacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        String A = "(A-B)*[C/(D+E)+F]";
        System.out.println(new InfixToPostfix().convertToPostfix(A));
    }

    private String convertToPostfix(String A) {

        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 0);
        priority.put('-', 0);
        priority.put('*', 1);
        priority.put('/', 1);
        priority.put('^', 2);

        Stack<Character> operatorStack = new Stack<>();
        StringBuilder res = new StringBuilder("");

        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);
            if (curr == '(' || curr == '[') operatorStack.push(curr);
            else if (curr == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') res.append(operatorStack.pop());
                operatorStack.pop();
            } else if (curr == ']') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '[') res.append(operatorStack.pop());
                operatorStack.pop();
            } else if (priority.containsKey(curr)) {
                int currentPriority = priority.get(curr);
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(' &&
                        operatorStack.peek() != '[' && priority.get(operatorStack.peek()) >= currentPriority)
                    res.append(operatorStack.pop());
                operatorStack.push(curr);
            } else {
                res.append(curr);
            }
        }

        while (!operatorStack.isEmpty()) res.append(operatorStack.pop());

        return res.toString();
    }


}
