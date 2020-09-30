package InterviewBit.DynamicProgramming;

import java.math.BigDecimal;

public class UniqueBST2 {
    public static void main(String[] args) {
        System.out.println(new UniqueBST2().numTrees(18));
    }

    public int numTrees(int A) {
        BigDecimal num = BigDecimal.valueOf(2 * A);
        for (int i = (2 * A) - 1; i > A; i--) {
            num = num.multiply(BigDecimal.valueOf(i));
        }

        num = num.divide(BigDecimal.valueOf(fact(A)));
        num = num.divide(BigDecimal.valueOf(A + 1));
        return num.intValue();
    }

    public long fact(int n) {
        long fact = 1;
        for (long i = 2; i < n + 1; i++) {
            fact *= i;
        }
        return fact;
    }
}
