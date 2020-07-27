package InterviewBit.Backtracking;

import java.util.*;
/**
 * Consider 1 element only once
 */
public class CombinationSum2 {

    public static Set<ArrayList<Integer>> result = new HashSet<>();

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(8, 8, 8));

        new CombinationSum2().combinationSum(A, 16);
        result.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        result.clear();
        a.sort(Integer::compareTo);

        recursive(a, new ArrayList<>(), b, 0);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(result);
        Collections.reverse(ans);

        return ans;
    }


    private void recursive(ArrayList<Integer> A, ArrayList<Integer> temp, int target, int i) {
        if (target == 0) {
            result.add(temp);
            return;
        }

        if (i >= A.size()) {
            return;
        }

        if (A.get(i) > target) {
            recursive(A, temp, target, i + 1);
        } else {
            recursive(A, temp, target, i + 1);
            ArrayList<Integer> temp2 = new ArrayList<>(temp);
            temp2.add(A.get(i));
            recursive(A, temp2, target - A.get(i), i + 1);
        }
    }
}
