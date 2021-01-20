package Question450.StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsing2Queues {


    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    public static void main(String[] args) {
        ImplementStackUsing2Queues obj = new ImplementStackUsing2Queues();
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        obj.push(4);
        System.out.println(obj.pop());
    }

    int pop() {
        // Your code here
        if (q1.isEmpty()) return -1;
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int dequeue = q1.poll();
        while (!q2.isEmpty()) q1.add(q2.poll());
        return dequeue;
    }

    /* The method push to push element into the stack */
    void push(int a) {
        // Your code here
        q1.add(a);
    }
}
