package InterviewBit.DynamicProgramming;

public class Arrange2 {
    int[][] dp;

    public static void main(String[] args) {
        String A = "WBWB";
        int B = 2;
        System.out.println(new Arrange2().arrange(A, B));
    }

    public int arrange(String A, int B) {
        if (B > A.length()) return -1;

        dp = new int[A.length()][B + 1];
        for (int i = 0; i < A.length(); i++)
            for (int j = 0; j < B + 1; j++)
                dp[i][j] = -1;

        return recursive(A, B, 0);
    }

    private int recursive(String A, int stable, int index) {
        if (index >= A.length()) return Integer.MAX_VALUE;

        if (dp[index][stable] != -1) return dp[index][stable];
        if (stable == 1) {
            dp[index][stable] = calculateProduct(A.substring(index));
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = index; i < A.length(); i++) {
                int temp = recursive(A, stable - 1, i + 1);
                if (temp == Integer.MAX_VALUE) continue;
                min = Integer.min(min, temp + calculateProduct(A.substring(index, i + 1)));
            }
            dp[index][stable] = min;
        }
        return dp[index][stable];
    }

    private int calculateProduct(String s) {
        int white = 0, block = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'W') white++;
            else block++;
        }
        return white * block;
    }
}
