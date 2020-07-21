package InterviewBit.BitManipulation;

public class TrailingZeros {

    public static void main(String[] args) {
        System.out.println(new TrailingZeros().solveMutable(4));
        System.out.println(new TrailingZeros().solveImmutable(4));
    }

    public int solveMutable(int A) {
        int count = 0;

        while (A > 0) {
            if ((A & 1) == 1) {
                break;
            }
            count++;
            A >>= 1;
        }

        return count;
    }

    public int solveImmutable(int A) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((A & (1 << i)) != 0) {
                break;
            }
            count++;
        }

        return count;
    }
}
