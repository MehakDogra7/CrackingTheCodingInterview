package Question450.Array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int[] A = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(findLongestConseqSubseq(A, A.length));
    }

    static int findLongestConseqSubseq(int arr[], int N) {
        // add your code here
        if (arr.length < 2) return arr.length;
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for (int i : arr) {
            set.add(i);
        }

        for (int i = 0; i < N; i++) {
            int curr = arr[i];
            if (!set.contains(curr + 1)) {
                int ele = curr - 1, count = 1;
                while (set.contains(ele)) {
                    count++;
                    ele--;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
