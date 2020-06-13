package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumUnsortedSubarray {

    public static void main(String[] args) {

        ArrayList<Integer> A1 = new ArrayList<>(List.of(1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19));
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 1));

        getIndexOfUnsortedSubarray1(A1).forEach(System.out::print);
    }

    private static ArrayList<Integer> getIndexOfUnsortedSubarray(ArrayList<Integer> A) {
        int startPoint = -1;
        int endPoint = A.size();
        final ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                startPoint = i;
                break;
            }
        }

        for (int i = A.size() - 1; i > 0; i--) {
            if (A.get(i) < A.get(i - 1)) {
                endPoint = i;
                break;
            } else if (A.get(i).equals(A.get(i - 1))) {
                int orig = i;
                while (i > 0 && A.get(i).equals(A.get(i - 1))) {
                    i--;
                }
                if (i > 0 && A.get(i) < A.get(i - 1)) {
                    endPoint = orig;
                    break;
                } else {
                    i++;
                }

            }
        }

        if (startPoint != -1) {
            result.add(startPoint);
            result.add(endPoint);
        } else {
            result.add(-1);
        }

        return result;
    }

    private static ArrayList<Integer> getIndexOfUnsortedSubarray1(ArrayList<Integer> A) {
        int startPoint = -1;
        int endPoint = A.size();
        final ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                startPoint = i;
                break;
            }
        }

        for (int i = A.size() - 1; i > 0; i--) {
            if (A.get(i) < A.get(i - 1)) {
                endPoint = i;
                break;
            }
        }

        if (startPoint == -1) {
            result.add(-1);
            return result;
        }
        int max = A.get(startPoint);
        int min = A.get(startPoint);

        for (int i = startPoint; i <= endPoint; i++) {
            max = Math.max(max, A.get(i));
            min = Math.min(min, A.get(i));
        }

        for (int i = 0; i < startPoint; i++) {
            if (A.get(i) > min) {
                startPoint = i;
                break;
            }
        }

        for (int i = A.size() - 1; i > endPoint; i--) {
            if (A.get(i) < max) {
                endPoint = i;
                break;
            }
        }

        result.add(startPoint);
        result.add(endPoint);

        return result;
    }

}
