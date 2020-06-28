package InterviewBit.Math;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArray {


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(List.of(0, 0, 9, 9));
        ArrayList<Integer> B = rearrangeArray(A);

        for (Integer i : B) {
            System.out.println(i + " ");
        }
    }

    private static ArrayList<Integer> rearrangeArray(ArrayList<Integer> A) {

        for (int i = 0; i < A.size(); i++) {
            int temp = A.get(A.get(i));

        }
        return null;
    }
}
