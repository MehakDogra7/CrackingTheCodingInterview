package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumAbsoluteDifference {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>(List.of(89, -83, 38, 58, 79, -80, 8, 19, 31, -95));

        System.out.println("Maximum Absolute Difference Using BruteForce is: " + getMaxAbsoluteDifferenceBruteForce(A));
        System.out.println("Maximum Absolute Difference Optimal Solution is: " + getMaxAbsoluteDifferenceOptimal(A));

    }

    private static int getMaxAbsoluteDifferenceBruteForce(ArrayList<Integer> A) {

        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int curr_max = Math.abs(A.get(i) - A.get(j)) + Math.abs(i - j);
                if (max < curr_max) {
                    max = curr_max;
                }
            }
        }
        return max;
    }

    private static int getMaxAbsoluteDifferenceOptimal(ArrayList<Integer> A) {
        int min1 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < A.size(); i++) {
            int value1 = A.get(i) + i;
            int value2 = A.get(i) - i;

            if (min1 > value1) {
                min1 = value1;
            }
            if (max1 < value1) {
                max1 = value1;
            }
            if (min2 > value2) {
                min2 = value2;
            }
            if (max2 < value2) {
                max2 = value2;
            }
        }

        int max3 = max1 - min1;
        int max4 = max2 - min2;

        return Math.max(max3, max4);
    }
}
