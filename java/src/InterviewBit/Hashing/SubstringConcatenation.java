package InterviewBit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenation {

    public static void main(String[] args) {

        String S = "barfoothefoobar";
        ArrayList<String> L = new ArrayList<>(List.of("foo", "bar"));

        new SubstringConcatenation().findSubstring(S, L).forEach(i -> System.out.println(i + " "));
    }

    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        Map<String, Integer> map = new HashMap<>();
        int wordLength = B.get(0).length();
        int totalSizeOfL = 0;
        for (String s : B) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
            totalSizeOfL += s.length();
        }
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= A.length() - totalSizeOfL; i++) {
            Map<String, Integer> tempMap = new HashMap<>(map);
            String sub = A.substring(i, i + totalSizeOfL);
            boolean flag = true;
            for (int j = 0; j <= sub.length() - wordLength; j = j + wordLength) {
                String word = sub.substring(j, j + wordLength);
                if (tempMap.containsKey(word)) {
                    tempMap.put(word, tempMap.get(word) - 1);
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
                    if (entry.getValue() > 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result.add(i);
                }
            }
        }

        return result;
    }
}
