package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {


    public static void main(String[] args) {

        ArrayList<Integer> B = new ArrayList<>(List.of(1, 5, 8));
        ArrayList<Integer> A = new ArrayList<>(List.of(6, 9));

        merge(A, B);
        A.forEach(System.out::println);
    }

    private static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) > b.get(j)) {
                a.add(i++, b.get(j++));
            } else {
                i++;
            }
        }
        while (j < b.size()) {
            a.add(b.get(j++));
        }
    }
}
