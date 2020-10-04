package InterviewBit.GreedyAlgorithm;

public class Bulbs {

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1};
        System.out.println(new Bulbs().solve(A));
    }

    private int solve(int[] A) {
        int count = 0;
        boolean curr = true;        //true for 0 and false for 1

        for (int i = 0; i < A.length; i++) {
            if (curr) {
                if (A[i] == 0) {
                    count++;
                    curr = false;
                }
            } else {
                if (A[i] == 1) {
                    count++;
                    curr = true;
                }
            }
        }

        return count;
    }
}
