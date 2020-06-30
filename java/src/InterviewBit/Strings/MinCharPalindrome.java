package InterviewBit.Strings;

public class MinCharPalindrome {

    public static void main(String[] args) {

        System.out.println(new MinCharPalindrome().solve("AACECAAAA"));
    }

    public int solve(String A) {

        String str = A + '$' + new StringBuilder(A).reverse();
        int[] lps = getLPSArray(str);
        return A.length() - lps[str.length() - 1];
    }

    private int[] getLPSArray(String str) {

        int i = 1, j = 0;
        int[] lps = new int[str.length()];
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                lps[i++] = ++j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }

        return lps;
    }
}
