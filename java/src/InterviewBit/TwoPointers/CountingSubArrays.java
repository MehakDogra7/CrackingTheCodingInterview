package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class CountingSubArrays {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3));
        int B = 7;

        System.out.println(new CountingSubArrays().solve(A, B));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int p1 = 0, p2 = 0;
        int count = 0;
        long sum = 0;

        while (p1 < A.size() && p2 < A.size()) {

            if (sum + A.get(p2) < B) {
                sum += A.get(p2++);
                count += p2 - p1;
            } else {
                sum -= A.get(p1++);
            }

        }

        return count;
    }
}
