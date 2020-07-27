package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets2 {

    public static Set<ArrayList<Integer>> result = new HashSet<>();

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 2));
        ArrayList<ArrayList<Integer>> B = new Subsets2().subsetsWithDup(A);
        B.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        result.clear();
        A.sort(Integer::compareTo);
        recursive(A, 0, new ArrayList<>());
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(result);
        sort(ans);
        return ans;
    }

    private void recursive(ArrayList<Integer> A, int i, ArrayList<Integer> temp) {
        if (i >= A.size()) {
            result.add(temp);
            return;
        }

        recursive(A, i + 1, temp);
        ArrayList<Integer> temp2 = new ArrayList<>(temp);
        temp2.add(A.get(i));
        recursive(A, i + 1, temp2);
    }

    private void sort(ArrayList<ArrayList<Integer>> ans) {
        ans.sort((x, y) -> {
            for (int i = 0; i < Integer.min(x.size(), y.size()); i++) {
                if (x.get(i) < y.get(i)) {
                    return -1;
                } else if (x.get(i) > y.get(i)) {
                    return 1;
                }
            }
            if (x.size() < y.size()) {
                return -1;
            }
            return 1;
        });
    }
}
