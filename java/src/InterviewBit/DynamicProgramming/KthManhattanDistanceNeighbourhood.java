package InterviewBit.DynamicProgramming;

public class KthManhattanDistanceNeighbourhood {
    public static void main(String[] args) {
        int[][] B = {
                {1, 2, 4},
                {4, 5, 8}
        };
        int[][] res = new KthManhattanDistanceNeighbourhood().solveDp(2, B);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] solveDp(int A, int[][] B) {
        int n = B.length, m = B[0].length;
        int[][] res = new int[n][m];
        int[][][] dp = new int[A + 1][n][m];

        for (int i = 0; i < n; i++)
            System.arraycopy(B[i], 0, dp[0][i], 0, m);

        for (int k = 1; k <= A; k++) {
            for (int p = 0; p < n; p++) {
                for (int q = 0; q < m; q++) {
                    dp[k][p][q] = max(p != 0 ? dp[k - 1][p - 1][q] : 0,
                            p != n - 1 ? dp[k - 1][p + 1][q] : 0,
                            q != 0 ? dp[k - 1][p][q - 1] : 0,
                            q != m - 1 ? dp[k - 1][p][q + 1] : 0,
                            dp[k - 1][p][q]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(dp[A][i], 0, res[i], 0, m);
        }
        return res;
    }

    private int max(int a, int b, int c, int d, int e) {
        return Integer.max(Integer.max(Integer.max(Integer.max(a, b), c), d), e);
    }

    public int[][] solveBruteForce(int A, int[][] B) {
        int n = B.length, m = B[0].length;
        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = calculateManhattanDistance(B, i, j, A);
            }
        }
        return res;
    }

    private int calculateManhattanDistance(int[][] A, int i, int j, int K) {
        int max = Integer.MIN_VALUE, n = A.length, m = A[0].length;

        for (int p = 0; p < n; p++) {
            for (int q = 0; q < m; q++) {
                if (Math.abs(i - p) + Math.abs(j - q) <= K)
                    max = Integer.max(max, A[p][q]);
            }
        }
        return max;
    }
}
