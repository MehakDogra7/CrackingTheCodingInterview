package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class MaximumContinuousSeriesOf1s {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 1, 0, 1, 1, 0, 0, 1, 1, 1));
        int B = 2;

        new MaximumContinuousSeriesOf1s().solve(A, B).forEach(i -> System.out.println(i));
    }

    private ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        ArrayList<Integer> result = new ArrayList<>();

        int left = 0, right = 0;
        int bestLeft = 0, bestSize = 0;
        int zeroCount = 0;

        while (right < A.size()) {
            if (zeroCount <= B) {
                if (A.get(right).equals(0)) {
                    zeroCount++;
                }
                right++;
            } else {
                if (A.get(left).equals(0)) {
                    zeroCount--;
                }
                left++;
            }

            if ((right - left) > bestSize && zeroCount <= B) {
                bestSize = right - left;
                bestLeft = left;
            }
        }

        for (int i = 0; i < bestSize; i++) {
            result.add(bestLeft++);
        }

        return result;
    }
}
