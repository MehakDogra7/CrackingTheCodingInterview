package InterviewBit.Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(6, 4, 5, 2, 3));
        System.out.println(new LongestConsecutiveSequence().solve(A));
    }

    private Integer solve(ArrayList<Integer> A) {
        int maxCount = 0;
        Set<Integer> set = new HashSet<>(A);
        for (Integer a : A) {
            if (!set.contains(a + 1)) {
                int ele = a - 1;
                int count = 1;
                while (set.contains(ele)) {
                    ele--;
                    count++;
                }
                maxCount = Integer.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
