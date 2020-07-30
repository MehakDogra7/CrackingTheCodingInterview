package InterviewBit.Hashing;

import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(List.of("cat", "dog", "god", "tca"));
        new Anagrams().solve(A).forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    private ArrayList<ArrayList<Integer>> solve(ArrayList<String> A) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            String curr = A.get(i);
            char[] chars = curr.toCharArray();
            Arrays.sort(chars);
            curr = new String(chars);
            if (map.containsKey(curr)) {
                map.get(curr).add(i + 1);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i + 1);
                map.put(curr, temp);
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
