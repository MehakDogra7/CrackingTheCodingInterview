package InterviewBit.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixMedian {

    public static void main(String[] args) {
        final ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

        A.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        System.out.println(new MatrixMedian().findMedian(A));
    }

    public int findMedian(ArrayList<ArrayList<Integer>> A) {

        int n = A.size();
        int m = A.get(0).size();

        int min = A.get(0).get(0);
        int max = A.get(0).get(m - 1);

        for (int row = 0; row < n; row++) {
            min = Math.min(min, A.get(row).get(0));
            max = Math.max(max, A.get(row).get(m - 1));
        }

        int desired = (m * n + 1) / 2;

        while (min < max) {

            int mid = min + (max - min) / 2;
            int place = 0;

            for (int i = 0; i < n; i++) {
                int index = binarySearch(A.get(i), mid);
                if (index < 0)
                    index = Math.abs(index) - 1;
                else {
                    while (index < A.get(i).size() && A.get(i).get(index) == mid)
                        index++;
                }
                place += index;
            }
            if (place < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private int binarySearch(ArrayList<Integer> A, int n) {

        int low = 0, high = A.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A.get(mid) == n) {
                return mid;
            } else if (A.get(mid) > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -(low + 1);
    }


}
