package InterviewBit.BinarySearch;

public class SquareRootOfInteger {

    public static void main(String[] args) {
        //System.out.println(new SquareRootOfInteger().squareRoot(2147483647));
        System.out.println(new SquareRootOfInteger().squareRootOptimal(2147483647));
    }

    private int squareRoot(int A) {

        int i = 1;
        while (i * i <= A) {
            i++;
        }

        return i - 1;
    }

    /**
     * Optimal: Use Binary Search
     *
     * @param A
     * @return
     */
    private int squareRootOptimal(int A) {

        if (A == 0 || A == 1)
            return A;

        long l = 0, r = A / 2;
        long ans = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == A) {
                return (int) mid;
            } else if (mid * mid < A) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) ans;
    }
}
