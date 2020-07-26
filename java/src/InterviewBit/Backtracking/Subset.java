package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3));

        new Subset().subsets(A);
        result.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        result.clear();
        A.sort(Integer::compareTo);
        subset(0, A, new ArrayList<>());
        sort();

        return result;
    }

    private void subset(int i, ArrayList<Integer> A, ArrayList<Integer> list) {
        if (i >= A.size()) {
            result.add(list);
            return;
        }

        subset(i + 1, A, list);
        ArrayList<Integer> list2 = new ArrayList<>(list);
        list2.add(A.get(i));
        subset(i + 1, A, list2);
    }

    private void sort() {
        result.sort((x, y) -> {
            for (int i = 0; i < Integer.min(x.size(), y.size()); i++) {
                if (x.get(i) < y.get(i)) {
                    return -1;
                } else if (y.get(i) < x.get(i))
                    return 1;
            }
            if (x.size() < y.size())
                return -1;
            return 1;
        });
    }
}
