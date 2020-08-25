package InterviewBit.DynamicProgramming;

public class LongestValidParenthesis {

    public static void main(String[] args) {
        System.out.println(new LongestValidParenthesis().solve("())((((()(((()(()(())(((((((()()())(())(()((())(())))()()(((()((((())("));
    }

    private int solve(String A) {
        int[] dp = new int[A.length()];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < A.length(); i++) {
            if (A.charAt(i) == '(') dp[i] = 0;
            else {
                if (A.charAt(i - 1) == '(')
                    dp[i] = (((i - 2) >= 0) ? dp[i - 2] : 0) + 2;
                else if ((i - dp[i - 1] - 1) >= 0 && A.charAt(i - dp[i - 1] - 1) == '(')
                    dp[i] = dp[i - 1] + 2 + (((i - dp[i - 1] - 2) >= 0) ? dp[i - dp[i - 1] - 2] : 0);
            }
            max = Integer.max(max, dp[i]);
        }
        return max;
    }
}
