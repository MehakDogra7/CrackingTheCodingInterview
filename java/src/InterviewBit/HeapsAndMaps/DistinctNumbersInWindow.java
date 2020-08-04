package InterviewBit.HeapsAndMaps;

import java.util.*;

public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 1, 3, 4, 3));
        int B = 3;
        new DistinctNumbersInWindow().solveOptimal(A, B).forEach(i -> {
            System.out.print(i + " ");
        });
    }

    private ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= A.size() - B; i++) {
            Set<Integer> set = new HashSet<>(A.subList(i, i + B));
            result.add(set.size());
        }
        return result;
    }

    private ArrayList<Integer> solveOptimal(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        int distinct = 0;

        if (A.size() < B) {
            return result;
        }

        for (int i = 0; i < B; i++) {
            int curr = A.get(i);
            if (map.containsKey(curr)) map.put(curr, map.get(curr) + 1);
            else {
                map.put(curr, 1);
                distinct++;
            }
        }
        result.add(distinct);
        for (int i = 1; i <= A.size() - B; i++) {
            int prev = A.get(i - 1);
            if (map.get(prev) == 1) {
                map.remove(prev);
                distinct--;
            } else map.put(prev, map.get(prev) - 1);

            int curr = A.get(i + B - 1);
            if (map.containsKey(curr)) map.put(curr, map.get(curr) + 1);
            else {
                map.put(curr, 1);
                distinct++;
            }
            result.add(distinct);
        }
        return result;
    }
}
