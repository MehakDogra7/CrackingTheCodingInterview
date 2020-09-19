package InterviewBit.StacksAndQueues;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 3, -1, -3, 5, 3, 6, 7));
        int B = 3;

        ArrayList<Integer> solve = new SlidingWindowMaximum().solve(A, B);
        solve.forEach(i -> System.out.print(i + " "));
        System.out.println();
        solve = new SlidingWindowMaximum().solveOptimal(A, B);
        solve.forEach(i -> System.out.print(i + " "));
    }


    /**
     * TC: O(nlogB)
     *
     * @param A length: n
     * @param B
     * @return
     */
    private ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = A.size(), i = 0;
        if (B > n) B = n;
        PriorityQueue<Integer> queue = new PriorityQueue<>(n - B + 1, (a, b) -> -Integer.compare(a, b));
        for (i = 0; i < B; i++) {
            queue.add(A.get(i));
        }

        res.add(queue.peek());
        for (i = 1; i <= n - B; i++) {
            queue.remove(A.get(i - 1));
            int next = A.get(i + B - 1);
            queue.add(next);
            res.add(queue.peek());
        }

        return res;
    }

    /**
     * TC: O(n)
     *
     * @param A length: n
     * @param B
     * @return
     */
    private ArrayList<Integer> solveOptimal(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = A.size(), i = 0;
        if (B > n) B = n;
        Deque<Integer> deque = new LinkedList<>();

        for (i = 0; i < B; i++) {
            int curr = A.get(i);
            while (!deque.isEmpty() && A.get(deque.peekLast()) <= curr) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (i = B; i < n; i++) {
            res.add(A.get(deque.peek()));
            if ((!deque.isEmpty()) && deque.peek() <= i - B)
                deque.removeFirst();
            int curr = A.get(i);
            while (!deque.isEmpty() && A.get(deque.peekLast()) <= curr) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        res.add(A.get(deque.peek()));
        return res;
    }


}
