package InterviewBit.Arrays;

import java.util.Arrays;

public class PerfectPeakOfArray {

    public static void main(String[] args) {
        int[] A = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        System.out.println(new PerfectPeakOfArray().perfectPeak(A));
    }

    public int perfectPeak(int[] A) {
        boolean[] left = calculateLeftSide(A);
        boolean[] right = calculateRightSide(A);

        for (int i = 0; i < A.length; i++) {
            if (left[i] && right[i]) {
                return 1;
            }
        }
        return 0;
    }

    private boolean[] calculateRightSide(int[] A) {
        int n = A.length, minTillNow = A[n - 1];
        boolean[] right = new boolean[n];
        Arrays.fill(right, false);

        for (int i = n - 2; i > -1; i--) {
            if (A[i] < minTillNow) right[i] = true;
            minTillNow = Integer.min(minTillNow, A[i]);
        }
        return right;
    }

    private boolean[] calculateLeftSide(int[] A) {
        int n = A.length, maxTillNow = A[0];
        boolean[] left = new boolean[n];
        Arrays.fill(left, false);

        for (int i = 1; i < n; i++) {
            if (A[i] > maxTillNow) left[i] = true;
            maxTillNow = Integer.max(maxTillNow, A[i]);
        }
        return left;
    }
}
