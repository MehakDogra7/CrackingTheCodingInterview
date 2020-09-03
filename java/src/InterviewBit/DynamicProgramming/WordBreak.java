package InterviewBit.DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        String A = "myinterviewtrainer";
        String[] B = {"interview", "my", "trainer"};
        System.out.println(new WordBreak().solveOptimized(A, B));
    }

    private int solve(String A, String[] B) {
        Set<String> set = new HashSet<>(Arrays.asList(B));
        boolean[][] dp = new boolean[A.length()][A.length()];

        if (A.length() <= 1) return set.contains(A) ? 1 : 0;

        for (int i = 0; i < A.length(); i++) {
            dp[i][i] = set.contains(String.valueOf(A.charAt(i)));
        }

        for (int len = 2; len <= A.length(); len++) {
            for (int i = 0; i <= A.length() - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j - 1; k++) {
                    if (set.contains(A.substring(i, j + 1))) {
                        dp[i][j] = true;
                        break;
                    }
                    if (!dp[i][j]) {
                        dp[i][j] = dp[i][k] && dp[k + 1][j];
                    }
                }
            }
        }
        return dp[0][A.length() - 1] ? 1 : 0;
    }

    public int solveOptimized(String A, String[] B) {
        boolean[] dp = new boolean[A.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= A.length(); i++) {
            String temp = A.substring(0, i);
            for (String curr : B) {
                if (temp.endsWith(curr)) {
                    dp[i] = dp[i] || dp[i - curr.length()];
                }
            }
        }
        return dp[A.length()] ? 1 : 0;
    }
}
