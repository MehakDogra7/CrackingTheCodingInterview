package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Combinations {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new Combinations().combine(4, 2);

        result.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            number.add(i);
        }
        populate(result, number, 0, B, new ArrayList<>());
        Collections.reverse(result);
        return result;
    }

    private void populate(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> number, int i, int k, ArrayList<Integer> list) {
        if (list.size() == k) {
            result.add(list);
            return;
        }
        if (i >= number.size()) {
            return;
        }

        populate(result, number, i + 1, k, list);
        ArrayList<Integer> list2 = new ArrayList<>(list);
        list2.add(number.get(i));
        populate(result, number, i + 1, k, list2);
    }


}
