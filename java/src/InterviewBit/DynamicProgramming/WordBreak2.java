package InterviewBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

    Set<String> dict;
    ArrayList<String> res;

    public static void main(String[] args) {
        String A = "catsanddog";
        ArrayList<String> B = new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"));
        ArrayList<String> result = new WordBreak2().wordBreak(A, B);
        result.forEach(System.out::println);
    }

    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        dict = new HashSet<>(B);
        res = new ArrayList<>();

        topDown(A, 0, "");
        return res;
    }

    private void topDown(String A, int index, String temp) {
        if (index == A.length()) {
            res.add(temp.trim());
            return;
        }

        for (int i = 1; i + index <= A.length(); i++) {
            String last = A.substring(index, index + i);
            if (dict.contains(last)) {
                topDown(A, index + i, temp + " " + last);
            }
        }
    }

}
