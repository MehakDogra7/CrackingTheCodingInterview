package InterviewBit.Math;

public class LargestCoPrimeDivisor {

    public static void main(String[] args) {

        System.out.println(new LargestCoPrimeDivisor().cpFact(30, 12));
    }

    private int gcd(int x, int y) {
        int dividend = Math.max(x, y);
        int divisor = Math.min(x, y);
        while (divisor != 0) {
            int rem = dividend % divisor;
            dividend = divisor;
            divisor = rem;
        }
        return dividend;
    }


    public int cpFact(int A, int B) {
        int x = gcd(A, B);
        while (x != 1) {
            A = A / x;
            x = gcd(A, B);
        }

        return A;
    }
}
