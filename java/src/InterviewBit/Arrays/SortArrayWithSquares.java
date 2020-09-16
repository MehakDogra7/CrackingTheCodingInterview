package InterviewBit.Arrays;

public class SortArrayWithSquares {

    public static void main(String[] args) {
        int[] A = {-6, -3, -1, 2, 4, 5};
        int[] result = new SortArrayWithSquares().solve(A);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private int[] solve(int[] A) {
        if (A.length == 0) return new int[0];
        int n = A.length;
        int[] res = new int[n];
        int positiveIndex = n;

        for (int i = 0; i < n; i++) {
            if (A[i] >= 0) {
                positiveIndex = i;
                break;
            }
        }

        int negativeIndex = positiveIndex - 1, i = 0;
        while (negativeIndex >= 0 || positiveIndex < n) {
            int negative = negativeIndex >= 0 ? Math.abs(A[negativeIndex]) : Integer.MAX_VALUE;
            int positive = positiveIndex < n ? A[positiveIndex] : Integer.MAX_VALUE;
            if (negative < positive) {
                res[i++] = (int) Math.pow(A[negativeIndex--], 2);
            } else {
                res[i++] = (int) Math.pow(A[positiveIndex++], 2);
            }
        }

        return res;
    }
}
