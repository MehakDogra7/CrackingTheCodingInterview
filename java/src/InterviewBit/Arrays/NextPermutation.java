package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(20, 50, 113));

        new NextPermutation().getNextPerm(A).forEach(i -> System.out.print(i + " "));
    }

    private ArrayList<Integer> getNextPerm(ArrayList<Integer> A) {

        boolean noNextPerm = true;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i + 1) > A.get(i)) {
                noNextPerm = false;
                break;
            }
        }

        if (noNextPerm) {
            sort(A, 0, A.size() - 1);
            return A;
        }

        int i = A.size() - 1;
        for (; i >= 0; i--) {
            if (i == 0) {
                break;
            } else if (A.get(i) > A.get(i - 1)) {
                i--;
                break;
            }
        }

        int closestGreater = Integer.MAX_VALUE;
        int closestGreaterIndex = i;
        for (int j = i + 1; j < A.size(); j++) {
            if (A.get(j) > A.get(i) && A.get(j) < closestGreater) {
                closestGreater = A.get(j);
                closestGreaterIndex = j;
            }
        }

        swap(A, i, closestGreaterIndex);
        sort(A, i + 1, A.size() - 1);
        return A;
    }

    private void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    private void sort(ArrayList<Integer> A, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(A, i, j);
        }
    }

    private void printPermutation(List<Integer> A, String prefix) {
        if (A.size() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < A.size(); i++) {
                List<Integer> rem = A.subList(0, i);
                rem.addAll(A.subList(i + 1, A.size()));
                printPermutation(rem, prefix + A.get(i));
            }
        }
    }
}
