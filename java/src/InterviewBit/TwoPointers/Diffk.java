package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class Diffk {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 3, 5));
        int B = 4;

        System.out.println(new Diffk().diffPossible(A, B));
        System.out.println(new Diffk().solveOptimal(A, B));
    }

    /**
     * TC: O(NlogN) using binary search
     * SC: O(1)
     *
     * @param A
     * @param B
     * @return
     */
    public int diffPossible(ArrayList<Integer> A, int B) {
        if (B > A.get(A.size() - 1) - A.get(0))
            return 0;

        for (int i = 0; i < A.size() - 1; i++) {
            int curr = A.get(i);
            int x = B + curr;
            int y = curr - B;
            int isPresent = binarySearch(A.subList(i + 1, A.size()), x);
            if (isPresent == -1) {
                isPresent = binarySearch(A.subList(i + 1, A.size()), y);
            }
            if (isPresent >= 0) {
                return 1;
            }
        }

        return 0;
    }

    private int binarySearch(List<Integer> A, int n) {

        int low = 0;
        int high = A.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == n) {
                return mid;
            } else if (A.get(mid) < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int solveOptimal(ArrayList<Integer> A, int B) {
        int p1 = 0;
        int p2 = 0;

        if (B > A.get(A.size() - 1) - A.get(0))
            return 0;

        while (p1 < A.size() && p2 < A.size()) {
            int x = A.get(p1);
            int y = A.get(p2);
            int diff = y - x;
            if (diff == B && p1 != p2) {
                return 1;
            } else if (diff > B) {
                p1++;
            } else {
                p2++;
            }
        }
        return 0;
    }
}
