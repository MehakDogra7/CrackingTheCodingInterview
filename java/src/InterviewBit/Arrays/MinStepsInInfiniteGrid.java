package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MinStepsInInfiniteGrid {

    public static void main(String[] args) {
        System.out.println(coverPoints(new ArrayList<>(List.of(0, 1, 1)), new ArrayList<>(List.of(0, 1, 2))));
    }

    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        int count = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            int a = Math.abs(A.get(i) - A.get(i + 1));
            int b = Math.abs(B.get(i) - B.get(i + 1));

            count += Math.max(a, b);
        }
        return count;
    }

}
