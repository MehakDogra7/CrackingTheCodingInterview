package Question450.Array;

public class InversionOfArray {

    static long count = 0;

    public static void main(String[] args) {

    }

    static long inversionCount(long arr[], long N) {
        // Your Code Here
        count = 0;
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }

    private static void mergeSort(long[] A, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            merge(A, start, mid, end);
        }
    }

    private static void merge(long[] A, int start, int mid, int end) {
        long[] B = new long[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i < mid + 1 && j < end + 1) {
            if (A[i] <= A[j])
                B[k++] = A[i++];
            else {
                count += mid - i + 1;
                B[k++] = A[j++];
            }
        }
        while (i < mid + 1) {
            B[k++] = A[i++];
        }
        while (j < end + 1) {
            B[k++] = A[j++];
        }
        i = start;
        for (int l = 0; l < B.length; l++) {
            A[start++] = B[l];
        }
    }
}
