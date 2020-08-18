package InterviewBit.DynamicProgramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String A = "abbcdgf";
        String B = "bbadcgf";

        System.out.println(new LongestCommonSubsequence().lcsBottomUp(A, B));
    }

    private int lcsBottomUp(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = 0;
        for (int j = 0; j <= n; j++) dp[0][j] = 0;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);

        return dp[m][n];
    }
}
