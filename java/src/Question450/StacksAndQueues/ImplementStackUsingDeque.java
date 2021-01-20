package Question450.StacksAndQueues;

import java.util.ArrayDeque;

public class ImplementStackUsingDeque {

    ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        ImplementStackUsingDeque obj = new ImplementStackUsingDeque();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.pop());
        obj.push(3);
        System.out.println(obj.pop());
    }

    int pop() {
        // Your code here
        return queue.isEmpty() ? -1 : queue.pollFirst();
    }

    /* The method push to push element into the stack */
    void push(int a) {
        // Your code here
        queue.offerFirst(a);
    }
}
