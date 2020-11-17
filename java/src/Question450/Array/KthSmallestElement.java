package Question450.Array;

import java.util.Arrays;

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] A = {2, 3, 8, 4, 1, 10, 9};
        System.out.println(kthSmallest(A, 0, A.length - 1, 6));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        //Your code here

        int n = r - l + 1, i = 0;
        if (k < 1 || k > n) return Integer.MAX_VALUE;

        int[] median = new int[(n + 4) / 5];

        for (i = 0; i < n / 5; i++) {
            median[i] = findMedian(arr, l + i * 5, 5);
        }
        if (i * 5 < n) {
            median[i] = findMedian(arr, l + i * 5, n % 5);
            i++;
        }

        int medianOfMedian = (i == 1) ? median[0] : kthSmallest(median, 0, median.length - 1, (i + 1) / 2);

        int pivot = partition(arr, l, r, medianOfMedian);

        if (pivot - l == k - 1) return arr[pivot];
        else if (pivot - l > k - 1) return kthSmallest(arr, l, pivot - 1, k);
        return kthSmallest(arr, pivot + 1, r, k - (pivot - l + 1));
    }

    private static int partition(int[] arr, int l, int r, int medianOfMedian) {
        for (int i = l; i <= r; i++) {
            if (arr[i] == medianOfMedian) {
                swap(arr, i, r);
                break;
            }
        }

        int i = l - 1, j = l;
        while (j <= r) {
            if (arr[j] < arr[r]) {
                swap(arr, ++i, j);
            }
            j++;
        }

        swap(arr, ++i, r);
        return i;
    }

    private static int findMedian(int[] arr, int start, int n) {
        Arrays.sort(arr, start, start + n);

        int mid = (start + (start + n)) / 2;

        return arr[mid];
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
