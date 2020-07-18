package InterviewBit.BitManipulation;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverse(3));
    }

    public long reverse(long a) {
        long res = 0;

        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((a & (1 << i)) != 0) {
                res |= 1;
            }
        }

        return res;
    }
}
