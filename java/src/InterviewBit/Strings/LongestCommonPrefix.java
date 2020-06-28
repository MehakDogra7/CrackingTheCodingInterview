package InterviewBit.Strings;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        ArrayList<String> A = new ArrayList<>(List.of("abab", "ab", "abcd"));

        System.out.println(new LongestCommonPrefix().longestCommonPrefix(A));

    }

    public String longestCommonPrefix(ArrayList<String> A) {

        if (A.size() == 0) {
            return "";
        }

        String common = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            common = getCommon(common, A.get(i));
        }

        return common;
    }

    private static String getCommon(String common, String S) {

        StringBuilder res = new StringBuilder();
        int i = 0;

        while (i < common.length() && i < S.length()) {
            if (common.charAt(i) != S.charAt(i))
                break;
            res.append(common.charAt(i));
            i++;
        }
        return res.toString();
    }
}
