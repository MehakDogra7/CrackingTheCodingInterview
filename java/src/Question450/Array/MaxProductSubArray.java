package Question450.Array;

public class MaxProductSubArray {

    public static void main(String[] args) {
        int A[] = {6, -3, -10, 0, 2};
        System.out.println(new MaxProductSubArray().solve(A));
    }

    private long solve(int[] A) {
        int n = A.length;

        long minTillNow = A[0], maxTillNow = A[0], result = A[0];

        for (int i = 1; i < n; i++) {
            long temp = minTillNow;
            minTillNow = Math.min(A[i] * maxTillNow, Math.min(A[i], minTillNow * A[i]));
            maxTillNow = Math.max(A[i] * temp, Math.max(A[i], maxTillNow * A[i]));

            result = Math.max(maxTillNow, result);
        }

        return result;
    }
}
