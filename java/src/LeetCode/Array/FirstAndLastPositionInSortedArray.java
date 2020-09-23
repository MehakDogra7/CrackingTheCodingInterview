package LeetCode.Array;

public class FirstAndLastPositionInSortedArray {
    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = new FirstAndLastPositionInSortedArray().searchRange(A, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] searchRange(int[] A, int target) {
        int leftIndexForTarget = binarySearchAllowDupesFirst(A, target);
        int rightIndexForTarget = binarySearchAllowDupesLast(A, target);

        int[] res = new int[2];
        if (leftIndexForTarget < 0) {
            res[0] = res[1] = -1;
            return res;
        }
        res[0] = leftIndexForTarget;
        res[1] = rightIndexForTarget;
        return res;
    }

    private int binarySearchAllowDupesFirst(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target && (mid == 0 || A[mid] > A[mid - 1])) {
                return mid;
            } else if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    private int binarySearchAllowDupesLast(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target && (mid == A.length - 1 || A[mid] < A[mid + 1])) {
                return mid;
            } else if (A[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -(low + 1);
    }
}
