package Question450.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseFirstKElementsOfQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        queue = new ReverseFirstKElementsOfQueue().modifyQueue(queue, 3);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        //add code here.
        rev(q, q.size());
        rev(q, q.size() - k);
        return q;
    }

    private void rev(Queue<Integer> q, int size) {
        if (size == 0) return;
        int dequeuedElement = q.poll();
        rev(q, size - 1);
        q.add(dequeuedElement);
    }
}
