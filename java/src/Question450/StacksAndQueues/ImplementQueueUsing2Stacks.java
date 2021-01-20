package Question450.StacksAndQueues;

import java.util.Stack;

public class ImplementQueueUsing2Stacks {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    public static void main(String[] args) {
        ImplementQueueUsing2Stacks obj = new ImplementQueueUsing2Stacks();
        obj.Push(2);
        obj.Push(3);
        System.out.println(obj.Pop());
        obj.Push(4);
        System.out.println(obj.Pop());
    }

    /* The method insert to push element
       into the queue */
    void Push(int x) {
        // Your code here
        s1.push(x);
    }


    /* The method remove which return the
      element popped out of the queue*/
    int Pop() {
        // Your code here
        if (!s2.isEmpty()) return s2.pop();
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.isEmpty() ? -1 : s2.pop();
    }
}
