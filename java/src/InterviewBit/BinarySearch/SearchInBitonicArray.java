package InterviewBit.BinarySearch;

public class SearchInBitonicArray {

    public static void main(String[] args) {

        int[] A = {5, 6, 7, 8, 9, 10, 3, 2, 1};
        int B = 6;

        System.out.println(new SearchInBitonicArray().solve(A, B));

    }

    public int solve(int[] A, int B) {

        if (A.length == 0) {
            return -1;
        }

        int bitonicPoint = 0;
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == 0 || mid == A.length - 1) {
                bitonicPoint = mid;
                break;
            } else if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                bitonicPoint = mid;
                break;
            } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (A[bitonicPoint] == B)
            return bitonicPoint;

        int index = binarySearch(A, 0, bitonicPoint - 1, B, true);
        if (index == -1)
            index = binarySearch(A, bitonicPoint + 1, A.length - 1, B, false);

        return index;
    }

    public int binarySearch(int[] A, int low, int high, int B, boolean isIncreasing) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < B) {
                if (isIncreasing)
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                if (isIncreasing)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }

        return -1;
    }
}
