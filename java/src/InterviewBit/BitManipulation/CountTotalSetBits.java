package InterviewBit.BitManipulation;

/**
 * Really really tricky question
 */
public class CountTotalSetBits {

    public static void main(String[] args) {
        System.out.println(new CountTotalSetBits().solve(4));
    }

    public int solve(int A) {
        int bits = (int) (Math.log(A) / Math.log(2)) + 1;
        long res = 0;
        A++;

        for (int i = 0; i < bits; i++) {
            long currPow2 = (long) Math.pow(2, i);
            long totalPair = A / currPow2;
            long totalPairOf1 = totalPair / 2;

            res += totalPairOf1 * currPow2;
            res %= 1000000007;

            if ((totalPair & 1) == 1) {
                res += A % currPow2;
                res %= 1000000007;
            }
        }
        return (int) res;
    }
}
