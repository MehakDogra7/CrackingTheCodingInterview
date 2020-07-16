package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class RemoveElementFromArray {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(List.of(4, 1, 1, 2, 1, 3));
        int b = 1;

        System.out.println(new RemoveElementFromArray().removeElement(a, b));
    }

    public int removeElement(ArrayList<Integer> a, int b) {
        int j = 0;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b)) {
                a.set(j++, a.get(i));
            }
        }

        a.forEach(i -> System.out.print(i + " "));
        System.out.println();

        return j;
    }
}
