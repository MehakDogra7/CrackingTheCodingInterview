package InterviewBit.DynamicProgramming;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] p = {1, 2, 1, 4, 1};
        System.out.println(new MatrixChainMultiplication().solve(p));
    }

    private int solve(int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        for (int i = 0; i < n; i++) m[i][i] = 0;

        for (int l = 1; l <= n - 1; l++) {
            for (int i = 0; i <= (n - l) - 1; i++) {
                int j = i + l;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        return m[0][n - 1];
    }
}
