package Question450.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class InterleaveTheFirstHalfOfQueueWithSecondHalf {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        new InterleaveTheFirstHalfOfQueueWithSecondHalf().solve(queue);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    private void solve(Queue<Integer> queue) {
        if (queue.size() < 4) return;

        Stack<Integer> stack = new Stack<>();
        int i = 0, size = queue.size(), halfSize = size / 2;
        while (i < halfSize) {
            stack.push(queue.poll());
            i++;
        }

        while (!stack.isEmpty()) queue.add(stack.pop());
        i = 0;
        while (i < halfSize) {
            queue.add(queue.poll());
            i++;
        }

        i = 0;
        while (i < halfSize) {
            stack.push(queue.poll());
            i++;
        }

        i = 0;
        while (i < halfSize) {
            queue.add(stack.pop());
            queue.add(queue.remove());
            i++;
        }
    }
}
