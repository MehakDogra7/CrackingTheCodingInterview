package InterviewBit.Strings;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {

        System.out.println(getPalindromeSubstring("aaabaaa"));
        System.out.println(getPalindromeSubstringConstantSpace("aaabaaa"));
        System.out.println(longestPalindromicSubstringLinear("aaabaaa"));

    }

    private static String getPalindromeSubstringConstantSpace(String A) {
        if (A.length() < 2) return A;

        int start = 0, end = 0;
        for (int i = 0; i < A.length(); i++) {
            int l1 = expand(A, i, i);
            int l2 = expand(A, i, i + 1);
            int max = Math.max(l1, l2);
            if (max > end - start + 1) {
                start = i - ((max - 1) / 2);
                end = i + (max / 2);
            }
        }

        return A.substring(start, end + 1);
    }

    private static int expand(String A, int left, int right) {
        while (left > -1 && right < A.length() && A.charAt(left) == A.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;    //-1 because above condition will break with not equal to condition hence remove 1 char from both left and right side.
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

    public static String longestPalindromicSubstringLinear(String A) {
        if (A.length() < 2) return A;
        int n = A.length(), m = 2 * n + 1, start = 0, end = 0;
        char[] newInput = new char[m];
        int[] T = new int[m];

        for (int i = 0, j = 0; i < m; i++) {
            if ((i % 2) == 0) newInput[i] = '$';
            else newInput[i] = A.charAt(j++);
        }

        for (int i = 0; i < m; ) {
            while (start > 0 && end < m - 1 && newInput[start - 1] == newInput[end + 1]) {
                start--;
                end++;
            }

            T[i] = end - start + 1;

            if (end == m - 1) break;

            int newCentre = end + (i % 2 == 0 ? 1 : 0);

            for (int j = i + 1; j < end + 1; j++) {
                T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
                if (j + T[i - (j - i)] / 2 == end) {
                    newCentre = j;
                    break;
                }
            }
            i = newCentre;
            end = i + T[i] / 2;
            start = i - T[i] / 2;
        }

        StringBuilder res = new StringBuilder();
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < m; i++) {
            if (max < T[i]) {
                max = T[i];
                maxIndex = i;
            }
        }
        start = maxIndex - max / 2;
        end = start + max;
        for (int i = start; i < end; i++) {
            if (newInput[i] != '$') res.append(newInput[i]);
        }

        return res.toString();
    }


}
