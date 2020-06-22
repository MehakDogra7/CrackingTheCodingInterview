package InterviewBit.Math;

public class ReverseInteger {

    public static void main(String[] args) {

        int n = -1153072433;
        System.out.println(reverse(n));
    }


    private static int reverse(int A) {

        boolean isNegative = A < 0;
        int rev = 0;
        int temp = Math.abs(A);
        while (temp > 0) {
            int x = temp % 10;
            rev = rev * 10 + x;
            temp /= 10;
        }

        int revrev = 0;
        temp = Math.abs(rev);
        while (temp > 0) {
            int x = temp % 10;
            revrev = revrev * 10 + x;
            temp /= 10;
        }

        if (!String.valueOf(Math.abs(A)).contains(String.valueOf(revrev)))
            return 0;

        return isNegative ? -rev : rev;
    }
}
