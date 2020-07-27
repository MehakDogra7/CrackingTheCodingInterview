package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3));

        ArrayList<ArrayList<Integer>> B = new Permutations().permute(A);
        B.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        result.clear();
        recursive(A, new ArrayList<>());
        return result;
    }

    private void recursive(ArrayList<Integer> A, ArrayList<Integer> list) {
        if (A.size() == 0) {
            result.add(list);
            return;
        }

        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>(A);
            temp.remove(i);
            ArrayList<Integer> temp2 = new ArrayList<>(list);
            temp2.add(A.get(i));
            recursive(temp, temp2);
        }

    }
}
