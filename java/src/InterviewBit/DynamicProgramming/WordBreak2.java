package InterviewBit.DynamicProgramming;

import java.util.*;

public class WordBreak2 {

    Set<String> dict;
    Map<Integer, ArrayList<String>> dp;

    public static void main(String[] args) {
        String A = "catsanddog";
        ArrayList<String> B = new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"));
        ArrayList<String> result = new WordBreak2().wordBreak(A, B);
        result.forEach(System.out::println);
    }

    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        dict = new HashSet<>(B);
        dp = new HashMap<>();

        ArrayList<String> result = topDown(A, 0);
        result.sort(String::compareTo);
        return result;
    }

    private ArrayList<String> topDown(String A, int index) {
        if (index == A.length()) {
            String temp = "";
            ArrayList<String> list = new ArrayList<>();
            list.add(temp);
            return list;
        }

        if (dp.containsKey(index)) return dp.get(index);

        ArrayList<String> list = new ArrayList<>();
        for (int i = index + 1; i <= A.length(); i++) {
            String current = A.substring(index, i);
            if (dict.contains(current)) {
                combine(topDown(A, i), current, list);
            }
        }
        dp.put(index, list);
        return list;
    }

    private void combine(ArrayList<String> list, String word, ArrayList<String> listToAdd) {
        if (list.isEmpty()) return;

        for (String s : list) {
            if (!s.isEmpty()) listToAdd.add(word + " " + s);
            else listToAdd.add(word);
        }
    }

}
