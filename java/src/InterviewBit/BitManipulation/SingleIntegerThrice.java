package InterviewBit.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class SingleIntegerThrice {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 4, 3, 3, 2, 2, 3, 1, 1));
        System.out.println(new SingleIntegerThrice().solve(A));
    }

    private int solve(ArrayList<Integer> A) {

        int res = 0;

        for (int i = 0; i < 32; i++) {
            long sum = 0;
            for (int j = 0; j < A.size(); j++) {
                sum += A.get(j) & (1 << i);
            }
            if (sum % 3 != 0) {
                res += (1 << i);
            }
        }

        return res;
    }
}
