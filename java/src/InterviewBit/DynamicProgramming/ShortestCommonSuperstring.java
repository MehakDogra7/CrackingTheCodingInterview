/*
package InterviewBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class ShortestCommonSuperstring {

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(List.of("fevlutui", "ilxfntf", "whiade", "idehwakceipb", "lkgvxeb"));
        System.out.println(new ShortestCommonSuperstring().solve(A));
    }

    public int solve(ArrayList<String> A) {
        return 0
    }

    public int recursive(ArrayList<String> A) {
        if (A.size() < 2) return 0;
        if (A.size() == 2) {
            String s1 = A.get(0), s2 = A.get(1);
            return merge(s1, s2).length();
        }
        int count = 0;
        for (int i = 0; i < A.size(); i++) {

        }
    }

    */
/*public int solve(ArrayList<String> A) {
        if (A.size() == 0) return 0;
        String str = "";

        while (A.size() > 1) {
            int index1 = -1, index2 = -1, maxLength = -1;
            for (int i = 0; i < A.size(); i++) {
                for (int j = i + 1; j < A.size(); j++) {
                    String s1 = A.get(i), s2 = A.get(j), merged = merge(s1, s2);
                    int curr = s1.length() + s2.length() - merged.length();
                    if (curr > maxLength) {
                        maxLength = curr;
                        index1 = i;
                        index2 = j;
                        str = merged;
                    }
                }
            }
            A.remove(index1);
            A.remove(index2 - 1);
            A.add(str);
            A.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
        return A.get(0).length();
    } *//*


    private String merge(String s1, String s2) {
        if (s1.contains(s2)) return s1;
        else if (s2.contains(s1)) return s2;

        int overlapped1 = 0, overlapped2 = 0, len1 = s1.length(), len2 = s2.length();
        for (int len = 1; len <= len1 && len <= len2; len++) {
            if (s1.substring(len1 - len).equals(s2.substring(0, len))) overlapped1 = len;
            if (s2.substring(len2 - len).equals(s1.substring(0, len))) overlapped2 = len;
        }
        if (overlapped1 >= overlapped2) return s1.substring(0, len1 - overlapped1) + s2;
        return s2.substring(0, len2 - overlapped2) + s1;
    }
}
*/
