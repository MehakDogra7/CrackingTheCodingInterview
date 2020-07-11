package InterviewBit.BinarySearch;

public class SearchForARange {

    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;

        int[] res = new SearchForARange().searchRange(A, B);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] searchRange(final int[] A, int B) {
        int[] res = new int[2];

        int start = binarySearch(A, B);
        if (start < 0) {
            res[0] = -1;
            res[1] = -1;
        } else {
            int end = binarySearch(A, B + 1);
            if (end < 0) {
                end = Math.abs(end) - 1;
            }
            res[0] = start;
            res[1] = end - 1;
        }

        return res;
    }

    private int binarySearch(int[] A, int search) {
        int low = 0, high = A.length - 1;
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
