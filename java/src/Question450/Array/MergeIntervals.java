package Question450.Array;

import java.util.ArrayList;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] A = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        int[][] res = new MergeIntervals().merge(A);
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        sort(intervals, 0, n - 1);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(intervals[0][0]);
        l.add(intervals[0][1]);
        list.add(l);

        for (int i = 1; i < n; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int size = list.size() - 1;
            int prevEnd = list.get(size).get(1);

            if (currStart <= prevEnd) {
                if (currEnd > prevEnd) {
                    list.get(size).set(1, currEnd);
                }
            } else {
                l = new ArrayList<>();
                l.add(currStart);
                l.add(currEnd);
                list.add(l);
            }
        }

        int[][] res = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }

        return res;
    }

    public void sort(int[][] A, int low, int high) {
        if (low >= high) return;

        int pivot = partition(A, low, high);
        sort(A, low, pivot - 1);
        sort(A, pivot + 1, high);
    }

    private int partition(int[][] A, int low, int high) {

        int i = low - 1, j = low;
        while (j < high) {
            if (isLess(A[j], A[high])) {
                swap(A, ++i, j);
            }
            j++;
        }
        swap(A, ++i, high);
        return i;
    }

    private void swap(int[][] A, int i, int j) {
        int[] temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private boolean isLess(int[] x, int[] y) {
        if (x[0] < y[0]) return true;
        else if (x[0] > y[0]) return false;
        return x[1] < y[1];
    }
}
