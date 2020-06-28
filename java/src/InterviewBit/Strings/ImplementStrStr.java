package InterviewBit.Strings;

public class ImplementStrStr {

    public static void main(String[] args) {

        System.out.println(get("aabaaaababaabbbabbabbbaabababaaaaaababaaabbabbabbabbaaaabbbbbbaabbabbbbbabababbaaabbaabbbababbb",
                "bba"));

    }

    private static int get(String A, String B) {

        int i = 0;
        int startIndex = -1;
        while (i < A.length()) {
            int j = 0;
            if (A.charAt(i) == B.charAt(j)) {
                startIndex = i;
                while (i < A.length() &&
                        j < B.length() &&
                        A.charAt(i) == B.charAt(j)) {
                    i++;
                    j++;
                }
                if (j == B.length()) {
                    return startIndex;
                } else {
                    i = startIndex + 1;
                }
            } else {
                i++;
            }
        }

        return -1;
    }
}
