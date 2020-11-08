package CompaniesInterviewExperience.Walmart;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/kth-most-frequent-character-in-a-given-string/
 */
public class KthMostFrequentChar {

    public static void main(String[] args) {
        String A = "GeeksforGeeks";
        int K = 3;
        System.out.println(new KthMostFrequentChar().solve(A, K));
    }

    private Character solve(String A, int k) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < A.length(); i++) {
            Character curr = A.charAt(i);
            if (map.containsKey(curr)) map.put(curr, map.get(curr) + 1);
            else map.put(curr, 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Collection<Integer> values = map.values();
        Set<Integer> set = new HashSet<>(values);

        int i = 0, n = set.size();
        int[] Array = new int[n];

        for (Integer val : set)
            Array[i++] = val;

        int value = identifyKthSmallest(Array, 0, n - 1, n - k + 1);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == value) return entry.getKey();
        }

        return null;
    }

    private int identifyKthSmallest(int[] A, int low, int high, int k) {
        if (k < 1 || k > high - low + 1) return Integer.MAX_VALUE;

        int n = high - low + 1, i = 0;
        int[] median = new int[(n + 4) / 5];

        for (i = 0; i < n / 5; i++) {
            median[i] = findMedian(A, low + i * 5, 5);
        }

        if (i * 5 < n) {
            median[i] = findMedian(A, low + i * 5, n % 5);
            i++;
        }

        int medOfMed = (i == 1) ? median[i - 1] : identifyKthSmallest(median, 0, i - 1, i / 2);
        int pivotPosition = partition(A, low, high, medOfMed);

        if (pivotPosition - low == k - 1) return A[pivotPosition];
        else if (pivotPosition - low > k - 1) return identifyKthSmallest(A, low, pivotPosition - 1, k);
        return identifyKthSmallest(A, pivotPosition + 1, high, k - pivotPosition + low - 1);
    }

    private int partition(int[] A, int low, int high, int medOfMed) {
        int i;
        for (i = low; i < high; i++) {
            if (A[i] == medOfMed) break;
        }

        swap(A, i, high);

        int pivot = high;
        i = low - 1;
        int j = low;
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

    private int findMedian(int[] A, int i, int n) {
        if (i <= n)
            Arrays.sort(A, i, n);
        else
            Arrays.sort(A, n, i);
        return A[n / 2];
    }
}
