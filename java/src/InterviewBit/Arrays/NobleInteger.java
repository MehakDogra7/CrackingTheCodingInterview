package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class NobleInteger {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 2, 3));

        System.out.println(getNobleIntegerBruteForce(A));
        System.out.println(getNobleIntegerUsingSorting(A));
    }

    private static int getNobleIntegerBruteForce(ArrayList<Integer> A) {

        for (int i = 0; i < A.size(); i++) {
            int curr = A.get(i);
            int numOfMax = 0;
            for (int j = 0; j < A.size(); j++) {
                if (A.get(j) > curr) {
                    numOfMax++;
                }
            }
            if (numOfMax == curr) {
                return 1;
            }
        }
        return -1;
    }

    private static int getNobleIntegerUsingSorting(ArrayList<Integer> A) {

        A.sort(Integer::compareTo);
        int n = A.size();

        for (int i = 0; i < n; i++) {
            if (i != n - 1 && A.get(i).equals(A.get(i + 1))) {
                continue;
            }
            if (A.get(i) == (n - 1) - i) {
                return 1;
            }
        }
        return -1;
    }
}
