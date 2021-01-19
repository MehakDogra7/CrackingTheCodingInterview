package Question450.StacksAndQueues;

import java.util.Stack;

public class ReverseStringUsingStack {

    public static void main(String[] args) {
        String A = "GeeksforGeeks";
        System.out.println(new ReverseStringUsingStack().reverse(A));
    }

    public String reverse(String S) {
        //code here
        StringBuilder rev = new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            stack.push(S.charAt(i));
        }

        while (!stack.isEmpty()) {
            rev.append(stack.pop());
        }
        return rev.toString();
    }
}
