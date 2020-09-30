package InterviewBit.DynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioning2 {

    int[] dp;

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning2().minCut("aabb"));
    }

    public int minCut(String A) {
        dp = new int[A.length()];
        Arrays.fill(dp, -1);
        return recursive(A, 0);
    }

    private int recursive(String A, int i) {
        if (i >= A.length()) return 0;

        if (dp[i] != -1) return dp[i];

        if (isPalindrome(A.substring(i))) return dp[i] = 0;

        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j <= A.length(); j++) {
            String curr = A.substring(i, j);
            if (isPalindrome(curr)) {
                min = Math.min(min, 1 + recursive(A, j));
            }
        }
        return dp[i] = min;
    }

    public boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }

}
