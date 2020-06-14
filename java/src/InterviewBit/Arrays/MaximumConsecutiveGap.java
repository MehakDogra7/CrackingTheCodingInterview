package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumConsecutiveGap {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(1, 10, 5));

        System.out.println(getMaximumConsecutiveGapUsingSorting(A));
    }

    private static int getMaximumConsecutiveGapUsingSorting(ArrayList<Integer> A) {

        if (A.size() < 2) {
            return 0;
        }
        A.sort(Integer::compareTo);
        int max = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            max = Math.max(max, A.get(i + 1) - A.get(i));
        }

        return max;
    }
}
