package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class AddOneToNumber {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>(List.of(0, 0, 9, 9));
        ArrayList<Integer> B = plusOneUsingLoop(A);

        for (Integer i : B) {
            System.out.println(i + " ");

        }
    }

    private static ArrayList<Integer> plusOneUsingLoop(ArrayList<Integer> A) {

        while (!A.isEmpty()) {
            if (A.get(0) != 0) {
                break;
            }
            A.remove(0);
        }

        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i) != 9) {
                A.set(i, A.get(i) + 1);
                return A;
            } else {
                A.set(i, 0);
            }
        }
        A.add(0, 1);

        return A;
    }


    private static ArrayList<Integer> plusOneUsingRecursion(ArrayList<Integer> A) {

        while (!A.isEmpty()) {
            if (A.get(0) != 0) {
                break;
            }
            A.remove(0);
        }

        if (A.isEmpty()) {
            A.add(1);
            return A;
        }


        if (A.get(A.size() - 1) != 9) {
            A.set(A.size() - 1, A.get(A.size() - 1) + 1);
            return A;
        }

        if (A.size() == 1) {
            A.removeAll(A);
            A.add(1);
            A.add(0);
            return A;
        }

        A.remove(A.size() - 1);
        A = (plusOneUsingRecursion(A));
        A.add(0);

        return A;

    }
}
