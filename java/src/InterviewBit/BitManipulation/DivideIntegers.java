package InterviewBit.BitManipulation;

public class DivideIntegers {

    public static void main(String[] args) {
        System.out.println(new DivideIntegers().divide(-2147483648, 1));
    }

    private int divide(int A, int B) {
        int sign = 1;

        if (A < 0) {
            if (B < 0) {
                sign = 1;
            } else {
                sign = -1;
            }
        } else if (B < 0) {
            sign = -1;
        }

        long x = Math.abs((long) A);
        long y = Math.abs((long) B);
        long quotient = 0;
        long temp = 0;

        for (int i = 31; i >= 0; i--) {
            if (temp + (y << i) <= x) {
                temp += (y << i);
                quotient |= 1l << i;
            }
        }

        quotient = sign > 0 ? quotient : -quotient;
        return quotient > Integer.MAX_VALUE || quotient < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) quotient;

    }
}
