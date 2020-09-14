package InterviewBit.Arrays;

public class MaximumSumSquareSubMatrix {
    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}
        };

        System.out.println(new MaximumSumSquareSubMatrix().solve(A, 3));
    }

    public int solve(int[][] A, int B) {
        int n = A.length, m = n - B + 1, currSum = 0, ans = Integer.MIN_VALUE;
        if (B > n) return 0;
        int[][] res = new int[m][m];
        for (int rowB = 0; rowB < B; rowB++) {
            for (int colB = 0; colB < B; colB++) {
                currSum += A[rowB][colB];
            }
        }
        res[0][0] = currSum;
        ans = currSum;

        for (int rowA = 0; rowA < m; rowA++) {
            for (int colA = 0; colA < m; colA++) {
                if (rowA == 0 && colA == 0) continue;
                if (colA != 0) {
                    res[rowA][colA] = res[rowA][colA - 1] - getSumOfColumn(A, colA - 1, rowA, B) + getSumOfColumn(A, colA + B - 1, rowA, B);
                } else {
                    res[rowA][colA] = res[rowA - 1][colA] - getSumOfRow(A, rowA - 1, colA, B) + getSumOfRow(A, rowA + B - 1, colA, B);
                }
                ans = Math.max(ans, res[rowA][colA]);
            }

        }


        return ans;
    }

    private int getSumOfRow(int[][] A, int row, int col, int B) {
        int sum = 0;
        for (int i = col; i < col + B; i++) {
            sum += A[row][i];
        }
        return sum;
    }

    private int getSumOfColumn(int[][] A, int col, int row, int B) {
        int sum = 0;
        for (int i = row; i < row + B; i++) {
            sum += A[i][col];
        }
        return sum;
    }
}
