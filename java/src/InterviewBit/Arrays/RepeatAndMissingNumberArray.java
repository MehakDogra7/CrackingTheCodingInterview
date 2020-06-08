package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumberArray {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>(List.of(4, 3, 6, 2, 1, 1));

        getRepeatAndMissingNumberArrayUsingSorting(A);
        getRepeatAndMissingNumberArrayWithExtraSpace(A);
        getRepeatAndMissingNumberArrayOptimal(A).forEach(System.out::println);
    }

    private static void getRepeatAndMissingNumberArrayUsingSorting(ArrayList<Integer> A) {

        A.sort(Integer::compareTo);

        int n = A.size();
        int actualSum = 0;
        int expectedSum = (n * (n + 1) / 2);
        int repeatedNumber = A.get(0);
        int missingNumber = 0;

        for (int i = 0; i < n; i++) {
            actualSum += A.get(i);
        }

        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) != i + 1) {
                repeatedNumber = A.get(i);
                break;
            }
        }

        missingNumber = expectedSum - (actualSum - repeatedNumber);

        System.out.println("Repeated Number is: " + repeatedNumber + " Missing Number is: " + missingNumber);
    }

    private static ArrayList<Integer> getRepeatAndMissingNumberArrayWithExtraSpace(ArrayList<Integer> A) {

        boolean[] B = new boolean[A.size()];
        ArrayList<Integer> result = new ArrayList<>();

        int repeatedNumber = A.get(0);
        int missingNumber = 0;

        for (int i = 0; i < A.size(); i++) {
            if (!B[A.get(i) - 1])
                B[A.get(i) - 1] = true;
            else
                repeatedNumber = A.get(i);
        }

        for (int i = 0; i < B.length; i++) {
            if (!B[i]) {
                missingNumber = i + 1;
            }
        }
        System.out.println("Repeated Number is: " + repeatedNumber + " Missing Number is: " + missingNumber);

        result.add(repeatedNumber);
        result.add(missingNumber);

        return result;
    }

    private static ArrayList<Integer> getRepeatAndMissingNumberArrayOptimal(ArrayList<Integer> A) {

        ArrayList<Integer> result = new ArrayList<>();
        int repeatedNumber = A.get(0);
        int missingNumber = 0;
        for (int i = 0; i < A.size(); i++) {
            int index = Math.abs(A.get(i)) - 1;
            if (A.get(index) < 0) {
                repeatedNumber = A.get(i);
            } else {
                A.set(index, -A.get(index));
            }
        }

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > 0) {
                missingNumber = i + 1;
            }
        }

        System.out.println("Repeated Number is: " + repeatedNumber + " Missing Number is: " + missingNumber);

        result.add(repeatedNumber);
        result.add(missingNumber);

        return result;
    }
}
