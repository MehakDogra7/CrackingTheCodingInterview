package InterviewBit.DynamicProgramming;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] A = {2, 3, -2, 4};
        System.out.println(new MaxProductSubarray().solve(A));
    }

    private int solve(int[] A) {
        if (A.length == 0) return 0;
        if (A.length == 1) return A[0];

        int n = A.length, maxProduct = A[0];
        int maxTillNow = A[0], minTillNow = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = maxTillNow;
            maxTillNow = Integer.max(A[i], Integer.max(A[i] * maxTillNow, A[i] * minTillNow));
            minTillNow = Integer.min(A[i], Integer.min(A[i] * temp, A[i] * minTillNow));
            maxProduct = Integer.max(maxTillNow, maxProduct);
        }

        return maxProduct;
    }
}
