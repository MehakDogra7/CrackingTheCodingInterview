package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateInArray {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(3, 1, 4, 1, 4));

        System.out.println(getDupeNumWithExtraSpace(A));
        System.out.println(getDupeNum(A));
    }

    private static int getDupeNumWithExtraSpace(ArrayList<Integer> A) {

        int n = A.size();
        boolean[] occurrence = new boolean[n];

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < occurrence.length) {
                if (occurrence[A.get(i)])
                    return A.get(i);
                else
                    occurrence[A.get(i)] = true;
            }
        }

        return -1;
    }

    private static int getDupeNum(ArrayList<Integer> A) {

        int n = A.size();
        for (int i = 0; i < n; i++) {
            int index = A.get(i) % n;
            A.set(index, A.get(index) + n);
        }

        for (int i = 0; i < n; i++) {
            if ((A.get(i) / n) > 1 && A.get(i) % n != 0) {
                return i;
            }
        }
        return -1;
    }
}
