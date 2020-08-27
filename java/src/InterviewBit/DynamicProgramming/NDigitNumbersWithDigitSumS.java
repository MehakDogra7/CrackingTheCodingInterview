package InterviewBit.DynamicProgramming;

public class NDigitNumbersWithDigitSumS {

    int[][] dp;

    public static void main(String[] args) {
        int S = 22, N = 75;
        System.out.println(new NDigitNumbersWithDigitSumS().solve(N, S));
    }

    private static void findCount(int A, int B) {
        int start = (int) Math.pow(10, A - 1);
        int end = (int) Math.pow(10, A) - 1;

        int count = 0;
        int i = start;

        while (i < end) {
            int currentNum = 0;
            int temp = i;
            while (temp != 0) {
                currentNum += temp % 10;
                temp = temp / 10;
            }

            if (currentNum == B) {
                count++;
                count %= 1000000007;
                i += 9;
            } else
                i++;
        }
        System.out.println(count);
    }

    private int solve(int A, int B) {
        if (B == 0) return 0;
        dp = new int[A + 1][B + 1];
        for (int i = 0; i < A + 1; i++) {
            for (int j = 0; j < B + 1; j++) {
                dp[i][j] = -1;
            }
        }
        int mod = 1000000007;
        long count = 0;
        for (int i = 1; i <= 9; i++) {
            if (B - i >= 0) {
                int temp = solveRecursive(A - 1, B - i) % mod;
                count += temp;
                count %= mod;
            }
        }

        return (int) count;
    }

    private int solveRecursive(int indicesRemaining, int sumRemaining) {
        if (indicesRemaining == 0)
            return sumRemaining == 0 ? 1 : 0;
        int mod = 1000000007;

        if (dp[indicesRemaining][sumRemaining] != -1) return dp[indicesRemaining][sumRemaining];
        long count = 0;
        for (int i = 0; i <= 9; i++) {
            if (sumRemaining - i >= 0) {
                int temp = solveRecursive(indicesRemaining - 1, sumRemaining - i) % mod;
                count += temp;
                count %= mod;
            }
        }
        return dp[indicesRemaining][sumRemaining] = (int) count;
    }
}