package InterviewBit.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class ArrangeMiceToHoles {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(-49, 58, 72, -78, 9, 65, -42, -3));
        ArrayList<Integer> B = new ArrayList<>(List.of(30, -13, -70, 58, -34, 79, -36, 27));
        System.out.println(new ArrangeMiceToHoles().mice(A, B));
    }

    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        A.sort(Integer::compareTo);
        B.sort(Integer::compareTo);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, Math.abs(B.get(i) - A.get(i)));
        }

        return max;
    }
}
