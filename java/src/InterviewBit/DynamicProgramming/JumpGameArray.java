package InterviewBit.DynamicProgramming;

public class JumpGameArray {

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 0, 4};
        System.out.println(new JumpGameArray().solve(A));
    }

    private int solve(int[] A) {
        int n = A.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            int currMaxJump = A[i];
            for (int j = 1; j <= currMaxJump && j < n; j++) {
                if (dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0] ? 1 : 0;
    }
}
