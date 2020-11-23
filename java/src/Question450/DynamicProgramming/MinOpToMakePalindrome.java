package Question450.DynamicProgramming;

public class MinOpToMakePalindrome {
    int[][] dp;

    public static void main(String[] args) {
        String A = "geeks";
        System.out.println(new MinOpToMakePalindrome().solveTopDown(A));
    }

    //TODO
    private int bottomUp(String A) {
        return 0;
    }

    private int solveTopDown(String A) {
        dp = new int[A.length()][A.length()];

        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < A.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return solveTopDown(A, 0, A.length() - 1);
    }

    private int solveTopDown(String A, int i, int j) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (A.charAt(i) == A.charAt(j)) dp[i][j] = solveTopDown(A, i + 1, j - 1);
        else {
            int x = solveTopDown(A, i + 1, j);
            int y = solveTopDown(A, i, j - 1);
            dp[i][j] = Math.min(x, y) + 1;
        }

        return dp[i][j];
    }

}
