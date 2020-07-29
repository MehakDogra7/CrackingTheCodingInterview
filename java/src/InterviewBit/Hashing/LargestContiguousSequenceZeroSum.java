package InterviewBit.Hashing;

import java.util.*;

public class LargestContiguousSequenceZeroSum {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, -3, 3));
        Objects.requireNonNull(new LargestContiguousSequenceZeroSum().solve(A)).forEach(i -> System.out.print(i + " "));
    }

    private ArrayList<Integer> solve(ArrayList<Integer> A) {
        int currSum = 0;
        int start = 0;
        int end = -1;
        int maxLength = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            currSum += A.get(i);

            if (currSum == 0) {
                int currLen = i + 1;
                if (currLen > maxLength) {
                    start = 0;
                    end = i;
                    maxLength = (end - start) + 1;
                }
            }

            if (map.containsKey(currSum)) {
                int currLen = ((i - (map.get(currSum) + 1)) + 1);
                if (currLen > maxLength) {
                    start = map.get(currSum) + 1;
                    end = i;
                    maxLength = (end - start) + 1;
                }
            } else {
                map.put(currSum, i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(A.get(i));
        }

        return result;
    }
}
