package GeeksForGeeks.MustDo.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairSum {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, -2, 1, 0, 5));
        int sum = 0;

        getPairBruteForce(A, sum).forEach(i -> System.out.print(i + " "));
        System.out.println();
        getPairSorting(A, sum).forEach(i -> System.out.print(i + " "));
        System.out.println();
        getPairOptimal(A, sum).forEach(i -> System.out.print(i + " "));
    }

    /**
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param A
     * @param sum
     * @return
     */
    private static ArrayList<Integer> getPairBruteForce(ArrayList<Integer> A, int sum) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) + A.get(j) == sum) {
                    result.add(A.get(i));
                    result.add(A.get(j));
                    return result;
                }
            }
        }
        result.add(-1);
        return result;
    }

    /**
     * TC: O(nlogn)
     * SC: O(1)
     *
     * @param A
     * @param sum
     * @return
     */
    private static ArrayList<Integer> getPairSorting(ArrayList<Integer> A, int sum) {
        ArrayList<Integer> result = new ArrayList<>();

        A.sort(Integer::compareTo);
        int i = 0, j = A.size() - 1;
        while (i < j) {
            if (A.get(i) + A.get(j) == sum) {
                result.add(A.get(i));
                result.add(A.get(j));
                return result;
            } else if (A.get(i) + A.get(j) > sum) {
                j--;
            } else {
                i++;
            }
        }

        result.add(-1);
        return result;
    }

    /**
     * TC: O(n)
     * SC: O(n)
     *
     * @param A
     * @param sum
     * @return
     */
    private static ArrayList<Integer> getPairOptimal(ArrayList<Integer> A, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.size(); i++) {
            if (set.contains(sum - A.get(i))) {
                result.add(A.get(i));
                result.add(sum - A.get(i));
                return result;
            }
            set.add(A.get(i));
        }

        result.add(-1);

        return result;
    }
}
