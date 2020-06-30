package InterviewBit.Strings;

public class ImplementStrStr {

    public static void main(String[] args) {

        System.out.println(substring("aaaaabbabbaaaababbbbaaabbbaababaababbaabaabaaabbabab",
                "bbbaababaa"));

        System.out.println(substringOptimal("aaaaabbabbaaaababbbbaaabbbaababaababbaabaabaaabbabab",
                "bbbaababaa"));
    }

    /**
     * O(m * n)
     *
     * @param A
     * @param B
     * @return
     */
    private static int substring(String A, String B) {

        int i = 0, j = 0;
        int startIndex = -1;
        boolean flag = true;

        while (i < A.length()) {
            if (flag) {
                startIndex = i;
            }
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
                flag = false;
            } else {
                flag = true;
                j = 0;
                i = startIndex + 1;
            }

            if (j == B.length()) {
                return startIndex;
            }
        }

        return -1;
    }

    /**
     * O(m + n)
     *
     * @param A
     * @param B
     * @return
     */
    private static int substringOptimal(String A, String B) {

        int[] prefixTrack = isSuffixAPrefix(B);
        int i = 0, j = 0;
        while (i < A.length()) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = prefixTrack[j - 1];
                } else {
                    i++;
                }
            }
            if (j == B.length()) {
                return i - j;
            }
        }
        return -1;
    }

    /**
     * TC: O(n)
     * SC: O(n)
     *
     * @param pattern
     * @return
     */
    private static int[] isSuffixAPrefix(String pattern) {

        int[] occur = new int[pattern.length()];

        int i = 1, j = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                occur[i++] = ++j;
            } else {
                if (j != 0)
                    j = occur[j - 1];
                else
                    occur[i++] = 0;
            }
        }
        return occur;
    }
}
