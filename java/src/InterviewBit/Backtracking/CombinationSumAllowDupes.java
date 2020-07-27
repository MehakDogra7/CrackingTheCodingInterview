package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumAllowDupes {

    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(8, 10, 6, 11, 1, 16, 8));

        new CombinationSumAllowDupes().combinationSum(A, 28);
        result.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        result.clear();
        A.sort(Integer::compareTo);
        int i = 0;
        while (i < A.size() - 1) {
            if (A.get(i).equals(A.get(i + 1))) {
                A.remove(i);
            } else {
                i++;
            }
        }

        recursiveAllowDupes(A, new ArrayList<>(), B, 0);
        Collections.reverse(result);

        return result;
    }

    public void recursiveAllowDupes(ArrayList<Integer> A, ArrayList<Integer> temp, int target, int i) {
        if (target == 0) {
            result.add(temp);
            return;
        }

        if (i >= A.size()) {
            return;
        }

        if (A.get(i) > target) {
            recursiveAllowDupes(A, temp, target, i + 1);
        } else {
            //2 Possibilities -- 1.) Go with the currNumber, 2.) Proceed with the next number
            recursiveAllowDupes(A, temp, target, i + 1); //2.)
            ArrayList<Integer> temp2 = new ArrayList<>(temp);
            temp2.add(A.get(i));
            recursiveAllowDupes(A, temp2, target - A.get(i), i); //1.)
        }
    }

}
