package InterviewBit.DynamicProgramming;

public class BestTimeToBuySellStock2 {

    public static void main(String[] args) {
        int[] A = {2, 5, 7, 1, 4, 3, 1, 3};
        System.out.println(new BestTimeToBuySellStock2().solve(A));
    }

    private int solve(int[] A) {
        int i, n = A.length;
        int p = 0;
        for (i = 0; i < n - 1; i++) {
            if (A[i] < A[i + 1]) {
                p = p + (A[i + 1] - A[i]);
            }
        }
        return p;
    }
}
