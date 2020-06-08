package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxSumContiguousSubarray {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>(List.of(1, -1, 1, -1, -1, -1));

        System.out.println("Max Sum of Subarray is: " + getMaxSumOfContiguousSubarray(A));

        ArrayList<Integer> B = getMaxSumContiguousSubarray(A);
        System.out.print("Max Sum Subarray is: ");
        for (Integer i : B) {
            System.out.print(i + " ");

        }
    }

    private static Integer getMaxSumOfContiguousSubarray(ArrayList<Integer> A) {

        int max = A.get(0), currentMax = A.get(0);

        for (int i = 1; i < A.size(); i++) {

            currentMax = Math.max(A.get(i), currentMax + A.get(i));

            if (max < currentMax) {
                max = currentMax;
            }
        }

        return max;
    }

    private static ArrayList<Integer> getMaxSumContiguousSubarray(ArrayList<Integer> A) {

        ArrayList<Integer> B = new ArrayList<>();
        int max = A.get(0), currentMax = A.get(0);
        int current = 0, start = 0, end = 0;

        for (int i = 1; i < A.size(); i++) {

            if (A.get(i) > currentMax + A.get(i)) {
                currentMax = A.get(i);
                current = i;
            } else {
                currentMax = currentMax + A.get(i);
            }

            if (max < currentMax) {
                max = currentMax;
                start = current;
                end = i;
            }
        }

        System.out.println(start + " " + end);
        for (int i = start; i <= end; i++) {
            B.add(A.get(i));
        }

        return B;
    }
}
