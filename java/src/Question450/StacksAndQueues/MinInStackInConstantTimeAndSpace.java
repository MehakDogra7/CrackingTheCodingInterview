package Question450.StacksAndQueues;

import java.util.Stack;

public class MinInStackInConstantTimeAndSpace {

    static int minElement;

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        MinInStackInConstantTimeAndSpace obj = new MinInStackInConstantTimeAndSpace();
        System.out.println("Is Empty: " + obj.isEmpty(stack));
        obj.push(4, stack);
        obj.push(5, stack);
        System.out.println("Minimum element: " + obj.min(stack));
        obj.push(3, stack);
        obj.push(2, stack);
        System.out.println("Minimum element: " + obj.min(stack));
        obj.push(1, stack);
        System.out.println("Minimum element: " + obj.min(stack));
        System.out.println("Popped element: " + obj.pop(stack));
        System.out.println("Minimum element: " + obj.min(stack));
        System.out.println("Is full: " + obj.isFull(stack, 5));
        obj.push(-5, stack);
        System.out.println("Is full: " + obj.isFull(stack, 5));
        System.out.println("Minimum element: " + obj.min(stack));
        obj.push(-10, stack);
        System.out.println("Minimum element: " + obj.min(stack));
        System.out.println("Popped element: " + obj.pop(stack));
        System.out.println("Minimum element: " + obj.min(stack));
    }

    public void push(int a, Stack<Integer> s) {
        //add code here.
        if (this.isEmpty(s)) {
            s.add(a);
            minElement = a;
        } else {
            if (a >= minElement) s.add(a);
            else {
                s.add(2 * a - minElement);
                minElement = a;
            }
        }
    }

    public int pop(Stack<Integer> s) {
        //add code here.
        if (this.isEmpty(s)) return Integer.MAX_VALUE;
        if (s.peek() > minElement) return s.pop();
        else {
            int pop = s.pop();
            int orig = minElement;
            minElement = 2 * orig - pop;
            return orig;
        }
    }

    public int min(Stack<Integer> s) {
        //add code here.
        if (this.isEmpty(s)) return Integer.MAX_VALUE;
        return minElement;
    }

    public boolean isFull(Stack<Integer> s, int n) {
        //add code here.
        return s.size() == n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        //add code here.
        return s.isEmpty();
    }
}
