package Question450.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseQueueUsingRecursion {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(4);
        queue.add(3);
        queue.add(1);
        queue.add(10);
        queue.add(2);
        queue.add(6);

        queue = new ReverseQueueUsingRecursion().rev(queue);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    public Queue<Integer> rev(Queue<Integer> q) {
        //add code here.
        if (q.isEmpty()) return q;
        int dequeuedElement = q.poll();
        rev(q);
        q.add(dequeuedElement);
        return q;
    }
}
