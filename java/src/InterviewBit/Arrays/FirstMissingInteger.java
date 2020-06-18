package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class FirstMissingInteger {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(4, 5, 2, 3, 9));
        System.out.println(getFirstMissingIntegerUsingSorting(A));
        System.out.println(getFirstMissingIntegerUsingOptimal(A));
    }

    private static int getFirstMissingIntegerUsingSorting(ArrayList<Integer> A) {

        A.sort(Integer::compareTo);
        int missing = 1;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) <= 0) {
                continue;
            }
            if (A.get(i) == missing) {
                missing++;
            }
        }
        return missing;
    }

    private static int getFirstMissingIntegerUsingOptimal(ArrayList<Integer> A) {
        return 0;
    }
}
