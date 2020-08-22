package InterviewBit.DynamicProgramming;

import java.util.Arrays;

public class SmallestSequenceWithGivenPrime {
    public static void main(String[] args) {
        int[] solve = new SmallestSequenceWithGivenPrime().solve(2, 3, 5, 5);
        for (int i : solve) {
            System.out.print(i + " ");
        }
    }

    public int[] solve(int a, int b, int c, int d) {
        int[] res = new int[d + 1];
        int nA = a, nB = b, nC = c;
        int next = 1;
        int iA = 0, iB = 0, iC = 0;

        for (int i = 1; i <= d; i++) {
            next = Integer.min(nA, Integer.min(nB, nC));
            res[i] = next;
            if (nA == next)
                nA = res[++iA] * a;
            if (nB == next)
                nB = res[++iB] * b;
            if (nC == next)
                nC = res[++iC] * c;
        }
        return Arrays.copyOfRange(res, 1, res.length);
    }
}
