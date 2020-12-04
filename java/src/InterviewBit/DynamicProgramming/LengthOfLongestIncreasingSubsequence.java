package InterviewBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LengthOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] A = {3, 4, -1, 0, 6, 2, 3};
        System.out.println(new LengthOfLongestIncreasingSubsequence().solve(A));
        System.out.println(new LengthOfLongestIncreasingSubsequence().solveOptimal(A));
    }

    /**
     * T.C. : O(n^2)
     *
     * @param A
     * @return
     */
    private int solve(int[] A) {
        if (A.length == 0) return 0;

        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (A[i] > A[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;

        for (int i = 0; i < n; i++)
            max = Integer.max(max, dp[i]);

        return max;
    }

    /**
     * T.C. : O(n^2)
     *
     * @param A
     * @return
     */
    private int solveOptimal(int[] A) {
        ArrayList<Integer> dp = new ArrayList<>();
        int n = A.length;
        dp.add(A[0]);

        for (int i = 1; i < n; i++) {
            int curr = A[i];
            if (dp.get(dp.size() - 1) < curr) dp.add(curr);
            else {
                int index = binarySearch(dp, curr);
                dp.set(index, curr);
            }
        }
        return dp.size();
    }

    private int binarySearch(ArrayList<Integer> dp, int curr) {

        int low = 0, high = dp.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (dp.get(mid) == curr) return mid;
            else if (dp.get(mid) < curr) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}
