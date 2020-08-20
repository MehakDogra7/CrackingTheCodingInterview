package InterviewBit.DynamicProgramming;

public class RegularExpression2 {

    int[][] dp;

    public static void main(String[] args) {
        String A = "abcccd";
        String B = "abc*.";
        System.out.println(new RegularExpression2().isMatchBottomUp(A, B));
    }

    public int isMatchBottomUp(final String A, final String B) {
        int m = A.length();
        int n = B.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            dp[i][0] = false;
        dp[0][0] = true;
        for (int i = 1; i < n; i++)
            if (B.charAt(i - 1) != '*' && B.charAt(i) == '*') {
                dp[0][i] = dp[0][i + 1] = true;
            } else break;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.') dp[i][j] = dp[i - 1][j - 1];
                else if (B.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')
                        dp[i][j] |= dp[i - 1][j];
                } else dp[i][j] = false;
            }
        }
        return dp[m][n] ? 1 : 0;
    }
}
