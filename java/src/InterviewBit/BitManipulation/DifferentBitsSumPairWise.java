package InterviewBit.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class DifferentBitsSumPairWise {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 3, 5));

        System.out.println(new DifferentBitsSumPairWise().solve(A));
    }

    private int solve(ArrayList<Integer> A) {
        long res = 0;
        for (int i = 0; i < 32; i++) {
            long count = 0;
            for (int j = 0; j < A.size(); j++) {
                if ((A.get(j) & 1 << i) != 0) {
                    count++;
                }
            }
            res += count * (A.size() - count) * 2;
            res %= 1000000007;
        }

        return (int) res % 1000000007;
    }
}
