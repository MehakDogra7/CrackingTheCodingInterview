package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class RemoveDupesFromSortedArray {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(List.of(1, 1, 1, 2, 2, 2, 2, 3, 4));

        System.out.println(new RemoveDupesFromSortedArray().removeDuplicates(a));
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        int j = 0;

        for (int i = 0; i < a.size() - 1; i++) {
            if (!a.get(i).equals(a.get(i + 1))) {
                a.set(j++, a.get(i));
            }
        }
        a.set(j++, a.get(a.size() - 1));

        return j;
    }
}
