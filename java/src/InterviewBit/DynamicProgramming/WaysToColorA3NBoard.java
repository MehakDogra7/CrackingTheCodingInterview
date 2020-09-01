package InterviewBit.DynamicProgramming;

public class WaysToColorA3NBoard {

    public static void main(String[] args) {
        System.out.println(new WaysToColorA3NBoard().solve(87));
    }

    private int solve(int A) {
        int mod = 1000000007;
        long c2 = 12, c3 = 24;
        for (int i = 2; i <= A; i++) {
            long tempC2 = c2;
            c2 = (5 * c3 + 7 * c2) % mod;
            c3 = (11 * c3 + 10 * tempC2) % mod;
        }
        return (int) (c2 + c3) % mod;
    }
}
