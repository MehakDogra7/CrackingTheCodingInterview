package InterviewBit.BinarySearch;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        int[] A = {6, 7, 0, 1, 2, 3, 4, 5};
        //int[] A = {1, 2, 3, 4, 5, 6, 7};
        int B = 4;


        for (int i = 0; i < A.length; i++) {
            System.out.println(new RotatedSortedArraySearch().search(A, A[i]));
        }
    }

    public int searchDupes(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target) return mid;

            else if ((A[low] == A[mid]) && (A[high] == A[mid])) {
                low++;
                high--;
            } else if (A[low] <= A[mid]) {
                if (target >= A[low] && target <= A[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (target >= A[mid] && target <= A[high])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public int findMinDupes(int[] A) {
        int min = Integer.MAX_VALUE;
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[low] == A[mid] && A[mid] == A[high]) {
                min = Integer.min(min, A[low]);
                low++;
                high--;
            } else if (A[low] <= A[mid]) {
                min = Integer.min(min, A[low]);
                low = mid + 1;
            } else if (A[mid] <= A[high]) {
                min = Integer.min(min, A[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    public int search(final int[] A, int B) {
        int low = 0;
        int high = A.length - 1;

        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == 0 && A[mid] < A[mid + 1]) {
                min = mid;
                break;
            } else if (mid == A.length - 1 && A[mid] < A[mid - 1]) {
                min = mid;
                break;
            } else {
                if (A[mid] < A[mid + 1] && A[mid] < A[mid - 1]) {
                    min = mid;
                    break;
                } else if (A[mid] < A[high]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        if (A[min] == B)
            return min;
        int index = -1;
        index = binarySearch(A, 0, min - 1, B);
        if (index == -1) {
            index = binarySearch(A, min + 1, A.length - 1, B);
        }
        return index;

    }

    public int binarySearch(final int[] A, int low, int high, int B) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /*public int search1(final int[] A, int B) {
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < A[high]) {
                if (A[mid] > B) {
                    return
                }
            } else if (A[mid] > B) {

            }
        }

        return -1;
    }*/
}
