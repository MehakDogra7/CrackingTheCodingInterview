package Question450.Matrix;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PrintSortedMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] A = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = sc.nextInt();
                }
            }
            new PrintSortedMatrix().solve(A, n);
            System.out.println();
        }
    }

    private void solve(int[][] A, int n) {

        PriorityQueue<HeapObject> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            heap.add(new HeapObject(A[i][0], i, 0));
        }

        while (!heap.isEmpty()) {
            HeapObject curr = heap.poll();
            System.out.print(curr.val + " ");
            if (curr.col < n - 1) {
                HeapObject next = new HeapObject(A[curr.row][curr.col + 1], curr.row, curr.col + 1);
                heap.add(next);
            }
        }
    }

    static class HeapObject implements Comparable<HeapObject> {
        int val, row, col;

        public HeapObject(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        public int compareTo(HeapObject h) {
            return Integer.compare(this.val, h.val);
        }
    }
}
