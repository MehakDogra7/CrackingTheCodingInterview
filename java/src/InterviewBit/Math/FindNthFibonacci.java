package InterviewBit.Math;

public class FindNthFibonacci {

    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        System.out.println(new FindNthFibonacci().solve(n));
    }

    public int solve(int A) {
        if (A <= 2) return 1;
        int mod = 1000000007;
        long[][] X = {
                {1, 1},
                {1, 0}
        };
        long[][] Y = {
                {1, 0},
                {0, 1}
        };

        while (A > 0) {
            if ((A & 1) == 1) {
                Y = multiply(X, Y);
            }
            X = multiply(X, X);
            A >>= 1;
        }
        return (int) (Y[1][0]) % mod;
    }

    public long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        int mod = 1000000007;

        res[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % mod;
        res[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % mod;
        res[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % mod;
        res[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % mod;

        return res;
    }
}
