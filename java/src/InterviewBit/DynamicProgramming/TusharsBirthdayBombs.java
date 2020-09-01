package InterviewBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TusharsBirthdayBombs {

    //ArrayList<Integer>[][] dp;

    public static void main(String[] args) {
        int A = 11;
        ArrayList<Integer> B = new ArrayList<>(List.of(6, 8, 5, 4, 7));
        new TusharsBirthdayBombs().solve(A, B).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        int min = Collections.min(B), i = 0, available = A % min;
        while (result.size() < A / min) {
            if (B.get(i) - min <= available) {
                available = available - (B.get(i) - min);
                result.add(i);
            } else {
                i++;
            }
        }
        return result;
    }
}
