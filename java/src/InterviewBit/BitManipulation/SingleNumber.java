package InterviewBit.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 2, 3, 1));
        System.out.println(new SingleNumber().solve(A));
    }

    private int solve(ArrayList<Integer> A) {

        int res = 0;
        for (Integer i : A) {
            res ^= i;
        }
        return res;
    }
}
