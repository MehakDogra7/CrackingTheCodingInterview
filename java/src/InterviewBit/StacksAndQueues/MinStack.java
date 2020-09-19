package InterviewBit.StacksAndQueues;

import java.util.Stack;

public class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }


    public void push(int x) {
        mainStack.push(x);
        if (minStack.empty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        if (mainStack.isEmpty()) return;
        int pop = mainStack.pop();
        if (minStack.peek() == pop)
            minStack.pop();
    }

    public int top() {
        if (mainStack.isEmpty()) return -1;
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}
