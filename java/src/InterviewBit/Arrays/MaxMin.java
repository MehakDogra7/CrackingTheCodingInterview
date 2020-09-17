package InterviewBit.Arrays;

public class MaxMin {
    public static void main(String[] args) {
        int[] A = {-2, 1, -4, 5, 3};
        System.out.println(new MaxMin().solve(A));
    }

    private int solve(int[] A) {
        if (A.length == 0) return 0;
        if (A.length == 1) return A[0] << 1;

        int max = A[0], min = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
            } else if (A[i] > max) {
                max = A[i];
            }
        }
        return min + max;
    }
}
