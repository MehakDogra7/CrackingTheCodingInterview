package Question450.Heap;

import java.util.Arrays;

public class KLargestElementInAnArray {

    public static void main(String[] args) {
        int[] arr = {12, 5, 787, 1, 23};
        int K = 2;
        int[] res = new KLargestElementInAnArray().kLargest(arr, arr.length, K);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    int[] kLargest(int[] arr, int n, int k) {
        // code here
        int indexOfKthLargestElement = getIndex(arr, 0, n - 1, n - k + 1);
        Arrays.sort(arr, indexOfKthLargestElement, n);

        int[] res = new int[k];
        for (int i = 0, j = n - 1; i < k; i++) {
            res[i] = arr[j--];
        }
        return res;
    }

    private int getIndex(int[] A, int l, int r, int k) {

        int n = r - l + 1, i = 0;
        if (k < 1 || k > n) return Integer.MAX_VALUE;

        int[] median = new int[(n + 4) / 5];
        for (; i < n / 5; i++) {
            median[i] = getMedian(A, l + i * 5, 5);
        }

        if (i * 5 < n) {
            median[i] = getMedian(A, l + i * 5, n % 5);
            i++;
        }

        int medianOfMedian = i == 1 ? median[0] : getIndex(median, 0, median.length - 1, (i + 1) / 2);

        int pivot = partition(A, l, r, medianOfMedian);

        if (pivot - l == k - 1) return pivot;
        else if (pivot - l > k - 1) return getIndex(A, l, pivot - 1, k);
        return getIndex(A, pivot + 1, r, k - (pivot - l + 1));
    }

    private int partition(int[] a, int l, int r, int medianOfMedian) {

        for (int i = l; i <= r; i++) {
            if (a[i] == medianOfMedian) {
                swap(a, i, r);
                break;
            }
        }

        int i = l - 1, j = l;
        while (j <= r) {
            if (a[j] < a[r]) {
                swap(a, ++i, j);
            }
            j++;
        }
        swap(a, ++i, r);
        return i;
    }


    private int getMedian(int[] a, int start, int n) {
        Arrays.sort(a, start, start + n);
        return a[(start + (start + n)) / 2];
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
