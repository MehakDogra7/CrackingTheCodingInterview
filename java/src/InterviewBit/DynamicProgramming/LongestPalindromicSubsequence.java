package InterviewBit.DynamicProgramming;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String A = "xabyaz";
        System.out.println(new LongestPalindromicSubsequence().solve(A));
    }

    private int solve(String A) {
        int n = A.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[i][n] = 0;
        }

        for (int i = 1; i <= n; i++)
            for (int j = n - 1; j >= 0; j--)
                if (A.charAt(i - 1) == A.charAt(j))
                    dp[i][j] = 1 + dp[i - 1][j + 1];
                else
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j + 1]);

        return dp[n][0];
    }

    public int solve2(String A) {
        if(A.length() < 2) return A.length();

        int n = A.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        int len = 2;
        for(int x = 1 ; x < n; x++){
            for (int i = 0; i < n - x; i++){
                int j = i + len - 1;
                if(A.charAt(i) == A.charAt(j))
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
            len++;
        }
        return dp[0][n-1];
    }
}
