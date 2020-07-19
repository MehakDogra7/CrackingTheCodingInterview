package InterviewBit.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class MinXORValue {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(0, 4, 7, 8, 9));

        System.out.println(new MinXORValue().solve(A));
    }

    private int solve(ArrayList<Integer> A) {

        A.sort(Integer::compareTo);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            min = Integer.min(min, A.get(i) ^ A.get(i + 1));
        }

        return min;
    }
}
