package InterviewBit.BinarySearch;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {

        List<Integer> A = Arrays.asList(1, 8, 21, 32, 45, 88);

        System.out.println(getIndexRecursion(A, 0, A.size() - 1, 32));
        System.out.println(getIndexLoop(A, 0, A.size() - 1, 32));

    }

    private static int getIndexRecursion(List<Integer> A, int low, int high, int n) {

        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == n) {
                return mid;
            }
            return (n < A.get(mid) ? getIndexRecursion(A, low, mid - 1, n) : getIndexRecursion(A, mid + 1, high, n));
        }
        return -1;
    }

    private static int getIndexLoop(List<Integer> A, int low, int high, int n) {

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

        return -1;
    }
}
