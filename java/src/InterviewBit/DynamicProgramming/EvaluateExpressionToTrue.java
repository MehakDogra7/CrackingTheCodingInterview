package InterviewBit.DynamicProgramming;

public class EvaluateExpressionToTrue {

    int[][][] dp;

    public static void main(String[] args) {
        String A = "T^T^T^F|F&F^F|T^F^T";
        System.out.println(new EvaluateExpressionToTrue().cnttrue(A));
    }

    public int cnttrue(String A) {
        dp = new int[A.length()][A.length()][2];
        for (int i = 0; i < A.length(); i++)
            for (int j = 0; j < A.length(); j++)
                for (int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;

        return recursive(A, 0, A.length(), 1) % 1003;
    }

    private int recursive(String s, int i, int j, int flag) {
        int mod = 1003;
        if (i >= j) return 0;
        if (i + 1 == j) {
            if (flag == 1) return s.charAt(i) == 'T' ? 1 : 0;
            return s.charAt(i) == 'F' ? 1 : 0;
        }

        if (dp[i][j - 1][flag] != -1) {
            return dp[i][j - 1][flag];
        }

        long count = 0;
        for (int k = i + 1; k < j - 1; k = k + 2) {
            char operator = s.charAt(k);
            switch (operator) {
                case '|': {
                    if (flag == 1) {
                        int countBothTrue = recursive(s, i, k, 1) * recursive(s, k + 1, j, 1);
                        int countLeftTrue = recursive(s, i, k, 1) * recursive(s, k + 1, j, 0);
                        int countRightTrue = recursive(s, i, k, 0) * recursive(s, k + 1, j, 1);
                        count = (count + countBothTrue + countLeftTrue + countRightTrue) % mod;
                    } else {
                        count = (count + recursive(s, i, k, 0) * recursive(s, k + 1, j, 0)) % mod;
                    }
                    break;
                }
                case '&': {
                    if (flag == 1) {
                        count = (count + recursive(s, i, k, 1) * recursive(s, k + 1, j, 1)) % mod;
                    } else {
                        int countBothFalse = recursive(s, i, k, 0) * recursive(s, k + 1, j, 0);
                        int countLeftTrue = recursive(s, i, k, 1) * recursive(s, k + 1, j, 0);
                        int countRightTrue = recursive(s, i, k, 0) * recursive(s, k + 1, j, 1);
                        count = (count + countBothFalse + countLeftTrue + countRightTrue) % mod;
                    }
                    break;
                }
                case '^': {
                    if (flag == 1) {
                        int countLeftTrue = recursive(s, i, k, 1) * recursive(s, k + 1, j, 0);
                        int countRightTrue = recursive(s, i, k, 0) * recursive(s, k + 1, j, 1);
                        count = (count + countLeftTrue + countRightTrue) % mod;
                    } else {
                        int countBothTrue = recursive(s, i, k, 1) * recursive(s, k + 1, j, 1);
                        int countBothFalse = recursive(s, i, k, 0) * recursive(s, k + 1, j, 0);
                        count = (count + countBothTrue + countBothFalse) % mod;
                    }
                    break;
                }
            }
        }
        dp[i][j - 1][flag] = (int) (count % mod);
        return dp[i][j - 1][flag];
    }

}
