package InterviewBit.BinarySearch;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {

        List<Integer> A = Arrays.asList(1, 8, 21, 32, 45, 88);

        System.out.println(Arrays.binarySearch(new int[]{1, 8, 21, 32, 45, 88}, 325));
        System.out.println(binarySearchRecursion(A, 0, A.size() - 1, 325));
        System.out.println(binarySearchLoop(A, 0, A.size() - 1, 325));
        System.out.println();
        System.out.println(Arrays.binarySearch(new int[]{1, 8, 21, 32, 45, 88}, 88));
        System.out.println(binarySearchRecursion(A, 0, A.size() - 1, 88));
        System.out.println(binarySearchLoop(A, 0, A.size() - 1, 88));

        //Dupe Algo test
        int[] Array = {5, 7, 7, 8, 8, 10};
        int B = 8;
        System.out.println(new BinarySearch().binarySearchAllowDupes(Array, 0, Array.length - 1, 8));

    }

    private static int binarySearchRecursion(List<Integer> A, int low, int high, int n) {

        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == n) {
                return mid;
            }
            return (n < A.get(mid) ? binarySearchRecursion(A, low, mid - 1, n) : binarySearchRecursion(A, mid + 1, high, n));
        }
        return -(low + 1);
    }

    private static int binarySearchLoop(List<Integer> A, int low, int high, int n) {

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

    /**
     * This version of binary search will allow dupes values and if the searched element is present
     * multiple times then it will give the index of it first occurrence.
     *
     * @param A
     * @param search
     * @return
     */
    private int binarySearchAllowDupes(int[] A, int low, int high, int search) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == search && (mid == 0 || A[mid] > A[mid - 1])) {
                return mid;
            } else if (A[mid] < search) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
}
