package InterviewBit.BinarySearch;

public class PowerOfTwoIntegers {

    public static void main(String[] args) {

        System.out.println(isPossible(216));
        System.out.println(isPossibleOptimal(216));
    }

    private static boolean isPossible(int A) {

        for (int i = 2; i <= Math.sqrt(A); i++) {
            int p = i;
            while (p <= A) {
                p *= i;
                if (p == A)
                    return true;
            }
        }
        return false;
    }

    private static int isPossibleOptimal(int A) {
        if (A == 1) {
            return 1;
        }
        double sq = Math.sqrt(A);
        double log = Math.log(A);
        for (int i = 2; i <= sq; i++) {
            double P = log / Math.log(i);
            if ((P - (int) P) < 0.00000001)
                return 1;
        }
        return 0;
    }
}
