package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3, 3, 4, 5, 6));
        ArrayList<Integer> B = new ArrayList<>(List.of(3, 5));

        findIntersection(A, B).forEach(System.out::println);

    }

    private static ArrayList<Integer> findIntersection(ArrayList<Integer> A, ArrayList<Integer> B) {

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i).equals(B.get(j))) {
                result.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
