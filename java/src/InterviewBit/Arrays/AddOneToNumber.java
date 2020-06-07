package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class AddOneToNumber {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>(List.of(0));
        ArrayList<Integer> B = plusOne1(A);

        for (Integer i : B) {
            System.out.println(i + " ");

        }
    }

    private static ArrayList<Integer> plusOne1(ArrayList<Integer> A) {

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


    private static ArrayList<Integer> plusOne(ArrayList<Integer> A) {

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

        return addOneToNumber(A);
    }

    public static ArrayList<Integer> addOneToNumber(ArrayList<Integer> B) {

        if (B.get(B.size() - 1) != 9) {
            B.set(B.size() - 1, B.get(B.size() - 1) + 1);
            return B;
        }

        if (B.size() == 1) {
            B.removeAll(B);
            B.add(1);
            B.add(0);
            return B;
        }

        B.remove(B.size() - 1);
        B = (plusOne(B));
        B.add(0);

        return B;
    }
}
