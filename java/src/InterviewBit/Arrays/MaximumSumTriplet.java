package InterviewBit.Arrays;

import java.util.TreeSet;

public class MaximumSumTriplet {

    public static void main(String[] args) {
        int[] A = {2, 5, 3, 1, 4, 9};
        System.out.println(new MaximumSumTriplet().solve(A));
    }

    private int solve(int[] A) {
        if (A.length < 3) return 0;
        int ans = Integer.MIN_VALUE, n = A.length;
        int[] right = new int[n];
        right[n - 1] = A[n - 1];
        for (int i = n - 2; i > -1; i--) {
            right[i] = Math.max(A[i], right[i + 1]);
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(A[0]);
        for (int i = 1; i < n - 1; i++) {
            Integer leftMax = treeSet.lower(A[i]);
            int rightMax = right[i + 1];
            if (rightMax > A[i] && leftMax != null) {
                ans = Math.max(ans, leftMax + A[i] + rightMax);
            }
            treeSet.add(A[i]);
        }
        if (ans == Integer.MIN_VALUE) return 0;
        return ans;
    }
}
