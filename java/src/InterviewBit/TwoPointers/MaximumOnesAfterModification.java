package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class MaximumOnesAfterModification {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 0, 0, 1, 0, 1, 0, 1, 0, 1));
        int B = 2;

        System.out.println(new MaximumOnesAfterModification().solve(A, B));
    }

    public int solve(ArrayList<Integer> A, int B) {

        int p1 = 0, p2 = 0;
        int countZero = 0, bestSize = 0;

        while (p1 < A.size() && p2 < A.size()) {
            if (countZero <= B) {
                if (A.get(p2).equals(0)) {
                    countZero++;
                }
                p2++;
            } else {
                if (A.get(p1).equals(0)) {
                    countZero--;
                }
                p1++;
            }

            if (countZero <= B) {
                if ((p2 - p1) > bestSize) {
                    bestSize = p2 - p1;
                }
            }
        }

        return bestSize;
    }

}
