package InterviewBit.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class XORingTheSubarrays {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(3, 4, 5));
        System.out.println(new XORingTheSubarrays().solveOptimal(A));
        System.out.println(new XORingTheSubarrays().solve1(A));
        //System.out.println(4 ^ 5 ^ 7 ^ 5 ^ (4 ^ 5) ^ (5 ^ 7) ^ (7 ^ 5) ^ (4 ^ 5 ^ 7) ^ (5 ^ 7 ^ 5) ^ (4 ^ 5 ^ 7 ^ 5));
    }

    public int solveOptimal(ArrayList<Integer> A) {
        int finalXOR = 0;

        if ((A.size() & 1) == 0)
            return 0;

        for (int i = 0; i < A.size(); i = i + 2) {
            finalXOR ^= A.get(i);
        }

        return finalXOR;
    }

    public int solve1(ArrayList<Integer> A) {
        long finalXOR = 0;

        int len = 1;
        while (len <= A.size()) {
            long xorL = 0;
            for (int i = 0; i < A.size(); i++) {
                long xor2 = 0;
                int j = i, k = 0;
                if (A.size() - j < len) {
                    continue;
                }
                while (j < A.size() && k < len) {
                    xor2 ^= A.get(j++);
                    k++;
                }
                xorL ^= xor2;
            }
            finalXOR ^= xorL;
            len++;
        }

        return (int) finalXOR;
    }
}
