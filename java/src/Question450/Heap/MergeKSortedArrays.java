package Question450.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        int k = 3;
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        mergeKArrays(arr, k).forEach(i -> System.out.print(i + " "));
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) {
        // Write your code here.
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            heap.add(new Pair(i, 0, arrays[i][0]));
        }

        while (!heap.isEmpty()) {
            Pair poll = heap.poll();
            res.add(poll.val);
            if (poll.index + 1 < arrays[poll.aNo].length) {
                heap.add(new Pair(poll.aNo, poll.index + 1, arrays[poll.aNo][poll.index + 1]));
            }
        }

        return res;
    }

    static class Pair implements Comparable<Pair> {
        int aNo, index, val;

        public Pair(int aNo, int index, int val) {
            this.aNo = aNo;
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(this.val, pair.val);
        }
    }
}
