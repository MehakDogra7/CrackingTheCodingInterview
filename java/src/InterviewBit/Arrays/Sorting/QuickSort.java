package InterviewBit.Arrays.Sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] A = {6, 1, 2, 4, 3, 5, 7, 9, 8};
        new QuickSort().sort(A, 0, A.length - 1);
        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    private void sort(int[] A, int low, int high) {
        if (low >= high) return;

        int pivot = partition(A, low, high);
        sort(A, low, pivot - 1);
        sort(A, pivot + 1, high);
    }

    private int partition(int[] A, int low, int high) {
        if (low == high) return low;

        int pivot = high;
        int i = low - 1, j = low;
        while (j <= high) {
            if (A[j] < A[pivot]) {
                swap(A, ++i, j);
            }
            j++;
        }
        swap(A, ++i, pivot);
        return i;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
