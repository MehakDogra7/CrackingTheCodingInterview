package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Very tough question needs some more practice to do these kind of questions
 */
public class MaxDistance {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(-1, -1, -1));

        System.out.println(getMaxDistanceBruteForce(A));
        System.out.println(getMaxDistanceOptimal(A));
    }

    private static int getMaxDistanceBruteForce(ArrayList<Integer> A) {

        int max = -1;

        for (int i = 0; i < A.size(); i++) {
            for (int j = A.size() - 1; j >= i; j--) {
                if (A.get(i) <= A.get(j)) {
                    if ((j - i) > max) {
                        max = j - i;
                    }
                }
            }
        }
        return max;
    }

    private static int getMaxDistanceOptimal(ArrayList<Integer> A) {

        int[] startingPoint = new int[A.size()];
        startingPoint[0] = A.get(0);
        int previous = startingPoint[0];

        for (int i = 1; i < A.size(); i++) {
            startingPoint[i] = A.get(i) < previous ? A.get(i) : 0;
            if (startingPoint[i] != 0) {
                previous = startingPoint[i];
            }
        }

        int max = -1;
        int i = A.size() - 1, j = A.size() - 1;

        while (i >= 0 && j >= 0) {
            if (startingPoint[i] == 0) {
                i--;
                continue;
            }
            if (A.get(j) >= startingPoint[i]) {
                max = Math.max(max, j - i);
                i--;
            } else {
                j--;
            }
        }

        return max;
    }
}

