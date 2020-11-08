package CompaniesInterviewExperience.Walmart;

import java.util.Arrays;

public class KthSmallest {

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int n = arr.length, k = 3;
        System.out.println(k + "'th smallest element is " + new KthSmallest().kthSmallest(arr, 0, n - 1, k));
    }

    public int kthSmallest(int[] arr, int l, int r, int k) {
        if (k < 1 || k > r - l + 1) return Integer.MAX_VALUE;       // If k is more than number of elements in array

        int n = r - l + 1, i;

        int[] median = new int[(n + 4) / 5];        // There will be floor((n+4)/5) groups;
        for (i = 0; i < n / 5; i++) {
            median[i] = findMedian(arr, l + i * 5, 5);
        }

        if (i * 5 < n) {                            // For last group with less than 5 elements
            median[i] = findMedian(arr, l + i * 5, n % 5);
            i++;
        }

        int medOfMed = (i == 1) ? median[i - 1] : kthSmallest(median, 0, i - 1, i / 2);
        int pos = partition(arr, l, r, medOfMed);

        if (pos - l == k - 1) return arr[pos];      // If position is same as k
        else if (pos - l > k - 1) return kthSmallest(arr, l, pos - 1, k);        // If position is more, recur for left
        return kthSmallest(arr, pos + 1, r, k - pos + l - 1);       // Else recur for right subarray
    }

    public int findMedian(int[] arr, int i, int n) {
        if (i <= n)
            Arrays.sort(arr, i, n); // Sort the array
        else
            Arrays.sort(arr, n, i);
        return arr[n / 2]; // Return middle element
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int[] arr, int l, int r, int x) {
        // It searches for x in arr[l..r], and partitions the array around x.
        // Search for x in arr[l..r] and move it to end
        int i;
        for (i = l; i < r; i++)
            if (arr[i] == x)
                break;
        swap(arr, i, r);

        // Standard partition algorithm
        i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }
}
