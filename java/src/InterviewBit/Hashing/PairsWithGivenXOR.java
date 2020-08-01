package InterviewBit.Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PairsWithGivenXOR {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(5, 4, 10, 15, 7, 6));
        System.out.println(new PairsWithGivenXOR().solve(A, 5));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            int xor = A.get(i) ^ B;
            if (set.contains(xor)) {
                count++;
            }
            set.add(A.get(i));
        }

        return count;
    }
}
