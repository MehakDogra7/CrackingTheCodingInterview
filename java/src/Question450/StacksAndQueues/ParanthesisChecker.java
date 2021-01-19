package Question450.StacksAndQueues;

import java.util.Stack;

public class ParanthesisChecker {


    public static void main(String[] args) {
        String A = "[()]{}{[()()]()}";
        System.out.println(ispar(A));
    }

    static boolean ispar(String A) {
        // add your code here
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);
            if (curr == '[' || curr == '{' || curr == '(') stack.push(curr);
            else {
                if (stack.isEmpty()) return false;
                else if (curr == ']') {
                    if (stack.peek() == '[') stack.pop();
                    else return false;
                } else if (curr == ')') {
                    if (stack.peek() == '(') stack.pop();
                    else return false;
                } else if (curr == '}') {
                    if (stack.peek() == '{') stack.pop();
                    else return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
