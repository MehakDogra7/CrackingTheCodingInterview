package MustDo.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Flip {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>(List.of(0, 0, 0, 1, 0, 1));

        System.out.println(getMaxNumberOfZeros(A));
    }

    private static int getMaxNumberOfZeros(ArrayList<Integer> A) {

        int max = 0;
        int curr = 0;
        int numberOfZeros = 0;
        boolean previousWas1 = false;

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 1) {
                if (previousWas1) {
                    curr++;
                } else {
                    previousWas1 = true;
                    curr = 1;
                }
            } else {
                previousWas1 = false;
                numberOfZeros++;
            }

            if (curr > max) {
                max = curr;
            }
        }

        return numberOfZeros + max;
    }
}