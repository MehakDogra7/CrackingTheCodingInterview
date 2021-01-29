package Question450.Heap;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] A = {12, 10, 2, 3, 5, 6};
        int size = 2;
        ArrayList<Integer> res = new SlidingWindowMaximum().solve(A, size);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    private ArrayList<Integer> solve(int[] A, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            int curr = A[i];
            while (!queue.isEmpty() && A[queue.peekLast()] < curr)
                queue.pollLast();
            queue.add(i);
        }

        for (int i = size; i < A.length; i++) {
            res.add(A[queue.peekFirst()]);
            if (queue.peekFirst() <= i - size)
                queue.pollFirst();
            int curr = A[i];
            while (!queue.isEmpty() && A[queue.peekLast()] < curr)
                queue.pollLast();
            queue.add(i);
        }
        res.add(A[queue.peekFirst()]);

        return res;
    }
}
