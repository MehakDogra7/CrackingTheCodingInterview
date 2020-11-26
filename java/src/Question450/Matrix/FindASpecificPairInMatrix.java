package Question450.Matrix;

public class FindASpecificPairInMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 6, 1, 3},
                {-4, -1, 1, 7, -6},
                {0, -4, 10, -5, 1}};
        System.out.println(new FindASpecificPairInMatrix().solve(A));
    }

    private int solve(int[][] A) {          // m * n
        int m = A.length, n = A[0].length, maxTillNow = Integer.MIN_VALUE;
        int[][] temp = new int[m][n];

        int maxLast = Integer.MIN_VALUE;
        for (int col = n - 1; col >= 0; col--) {
            maxLast = Math.max(maxLast, A[m - 1][col]);
            temp[m - 1][col] = maxLast;
        }

        maxLast = Integer.MIN_VALUE;
        for (int row = m - 1; row >= 0; row--) {
            maxLast = Math.max(maxLast, A[row][n - 1]);
            temp[row][n - 1] = maxLast;
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                int next = temp[row + 1][col + 1];
                maxTillNow = Math.max(maxTillNow, next - A[row][col]);
                temp[row][col] = max(next, temp[row][col + 1], temp[row + 1][col], A[row][col]);
            }
        }
        return maxTillNow;
    }

    private int max(int next, int i, int i1, int i2) {
        return Math.max(next, Math.max(i, Math.max(i1, i2)));
    }
}
