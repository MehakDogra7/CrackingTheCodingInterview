package Question450.StacksAndQueues;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        new DeleteMiddleElementOfStack().deleteMid(stack, stack.size());
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }

    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // code here
        if (sizeOfStack == 0) return;
        int mid = sizeOfStack / 2;
        Stack<Integer> temp = new Stack<>();
        while (mid > 0) {
            temp.push(s.pop());
            mid--;
        }
        s.pop();

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }
}
