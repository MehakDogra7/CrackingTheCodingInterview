package InterviewBit.Strings;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {

        System.out.println(getPalindromeSubstring("aaabaaa"));

    }

    private static String getPalindromeSubstring(String A) {

        int n = A.length();
        boolean[][] table = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < n - 1; i++) {
            if (A.charAt(i) == A.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;

                if (table[i + 1][j - 1] && A.charAt(i) == A.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return A.substring(start, start + maxLength);
    }
}
