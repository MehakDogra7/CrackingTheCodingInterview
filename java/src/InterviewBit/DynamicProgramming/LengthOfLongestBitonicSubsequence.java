package InterviewBit.DynamicProgramming;

import java.util.Arrays;

public class LengthOfLongestBitonicSubsequence {

    public static void main(String[] args) {
        int[] A = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(new LengthOfLongestBitonicSubsequence().solve(A));
    }

    private int solve(int[] A) {
        if (A.length == 0) return 0;
        int n = A.length;
        int[] dpLeft = new int[n], dpRight = new int[n];
        Arrays.fill(dpLeft, 1);
        Arrays.fill(dpRight, 1);

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (A[i] > A[j] && dpLeft[j] + 1 > dpLeft[i]) dpLeft[i] = dpLeft[j] + 1;

        for (int i = n - 2; i >= 0; i--)
            for (int j = n - 1; j > i; j--)
                if (A[i] > A[j] && dpRight[j] + 1 > dpRight[i]) dpRight[i] = dpRight[j] + 1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max = Integer.max(max, dpLeft[i] + dpRight[i] - 1);

        return max;
    }
}
