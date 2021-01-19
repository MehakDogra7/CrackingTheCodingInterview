package Question450.StacksAndQueues;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        new ReverseStackUsingRecursion().reverse(s);
        while (!s.isEmpty()) System.out.print(s.pop() + " ");
    }

    private void reverse(Stack<Integer> s) {
        if (s.isEmpty() || s.size() == 1) return;
        int curr = s.pop();
        reverse(s);
        insertAtBottom(s, curr);
    }

    private void insertAtBottom(Stack<Integer> s, int curr) {
        if (s.isEmpty()) s.push(curr);
        else {
            int pop = s.pop();
            insertAtBottom(s, curr);
            s.push(pop);
        }
    }
}
