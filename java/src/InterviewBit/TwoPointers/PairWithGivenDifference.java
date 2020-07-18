package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class PairWithGivenDifference {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(-10, 20));
        int B = 30;

        System.out.println(new PairWithGivenDifference().solve(A, B));

    }

    public int solve(ArrayList<Integer> A, int B) {
        A.sort(Integer::compareTo);

        int p1 = 0, p2 = 0;

        while (p1 < A.size() && p2 < A.size()) {
            int x = A.get(p1);
            int y = A.get(p2);
            int diff = Math.abs(x - y);
            if (diff == Math.abs(B) && p1 != p2) {
                return 1;
            } else if (diff < Math.abs(B)) {
                p1++;
            } else {
                p2++;
            }
        }
        return 0;
    }
}
