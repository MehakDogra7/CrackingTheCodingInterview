package InterviewBit.DynamicProgramming;

public class RodCutting2InterviewBit {

    long[][] dp;
    int[][] permutation;
    int[] res;
    int resIndex;

    public static void main(String[] args) {
        int N = 6;
        int[] Arr = {1, 2, 5};
        int[] res = new RodCutting2InterviewBit().rodCut(N, Arr);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    public int[] rodCut(int N, int[] arr) {
        int n = arr.length;
        dp = new long[n][n];
        permutation = new int[n][n];
        res = new int[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        resIndex = 0;
        solve(N, N, arr, 0, arr.length - 1);
        generateResult(arr, 0, arr.length - 1);
        return res;
    }

    private void generateResult(int[] A, int i, int j) {
        if (i > j || i < 0 || j >= permutation.length) return;
        if (i == j) {
            res[resIndex++] = A[permutation[i][j]];
            return;
        }
        res[resIndex++] = A[permutation[i][j]];
        generateResult(A, i, permutation[i][j] - 1);
        generateResult(A, permutation[i][j] + 1, j);
    }

    private long solve(int N, int origN, int[] A, int i, int j) { //i and j included
        if (i > j || i < 0 || j >= A.length) return 0;
        if (i == j) {
            permutation[i][j] = i;
            return N;
        }

        if (dp[i][j] != -1) return dp[i][j];

        long min = Long.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int leftN = A[k] - (i == 0 ? 0 : A[i - 1]);
            int rightN = (j == A.length - 1 ? origN : A[j + 1]) - A[k];
            long left = solve(leftN, origN, A, i, k - 1);
            long right = solve(rightN, origN, A, k + 1, j);
            if (min > left + right) {
                min = left + right;
                permutation[i][j] = k;
            }
        }
        dp[i][j] = N + min;
        return N + min;
    }
}
