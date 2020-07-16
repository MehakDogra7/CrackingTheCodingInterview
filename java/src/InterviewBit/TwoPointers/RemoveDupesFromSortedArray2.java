package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class RemoveDupesFromSortedArray2 {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(List.of(1, 1, 1, 2));

        System.out.println(new RemoveDupesFromSortedArray2().removeDuplicates(a));
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() == 0 || a.size() == 1)
            return a.size();

        int j = 0;

        for (int i = 0; i < a.size() - 2; i++) {
            if (!a.get(i).equals(a.get(i + 2))) {
                a.set(j++, a.get(i));
            }
        }
        a.set(j++, a.get(a.size() - 2));
        a.set(j++, a.get(a.size() - 1));

        //a.forEach(i -> System.out.print(i + " "));
        //System.out.println();

        return j;
    }
}
