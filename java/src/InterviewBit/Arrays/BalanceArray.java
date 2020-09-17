package InterviewBit.Arrays;

public class BalanceArray {

    public static void main(String[] args) {
        int[] A = {5, 5, 2, 5, 8};
        System.out.println(new BalanceArray().solve(A));
    }

    private int solve(int[] A) {
        if (A.length < 2) return A.length;
        long[] leftEvenSum = new long[A.length], leftOddSum = new long[A.length];
        long[] rightEvenSum = new long[A.length], rightOddSum = new long[A.length];
        int count = 0;
        //calculateLeft
        for (int i = 1; i < A.length; i++) {
            if ((i & 1) == 1) {
                leftEvenSum[i] = leftEvenSum[i - 1] + A[i - 1];
                leftOddSum[i] = leftOddSum[i - 1];
            } else {
                leftEvenSum[i] = leftEvenSum[i - 1];
                leftOddSum[i] = leftOddSum[i - 1] + A[i - 1];
            }
        }

        //calculateRight
        for (int i = A.length - 2; i >= 0; i--) {
            if ((i & 1) == 1) {
                rightEvenSum[i] = rightEvenSum[i + 1] + A[i + 1];
                rightOddSum[i] = rightOddSum[i + 1];
            } else {
                rightEvenSum[i] = rightEvenSum[i + 1];
                rightOddSum[i] = rightOddSum[i + 1] + A[i + 1];
            }
        }

        for (int i = 0; i < A.length; i++) {
            long x = leftEvenSum[i] + rightOddSum[i];
            long y = leftOddSum[i] + rightEvenSum[i];
            if (x == y) count++;
        }

        return count;
    }
}
