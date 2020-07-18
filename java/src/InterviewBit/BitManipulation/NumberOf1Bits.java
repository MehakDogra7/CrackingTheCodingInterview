package InterviewBit.BitManipulation;

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().numSetBits(5));
    }

    public int numSetBits(long a) {
        int count = 0;

        while (a > 0) {
            if ((a & 1) == 1) {
                count++;
            }
            a >>= 1;
        }

        return count;
    }
}
