package InterviewBit.Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DiffK2 {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 5, 3));
        int B = 4;

        System.out.println(new DiffK2().solve(A, B));
    }

    private int solve(ArrayList<Integer> A, int B) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < A.size(); i++) {
            int curr = A.get(i);
            if (set.contains(curr - B) || set.contains(curr + B)) {
                return 1;
            }
            set.add(curr);
        }

        return 0;
    }
}
