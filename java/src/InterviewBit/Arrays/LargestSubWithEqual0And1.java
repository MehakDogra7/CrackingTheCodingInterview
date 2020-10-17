package InterviewBit.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubWithEqual0And1 {

    public static void main(String[] args) {
        int[] A = {1, 0, 1, 1, 1, 0, 0};
        int[] res = new LargestSubWithEqual0And1().solve(A);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] solve(int[] A) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0, end = -1, maxLength = Integer.MIN_VALUE;
        int n = A.length;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) A[i] = -1;
        }

        for (int i = 0; i < A.length; i++) {
            currSum += A[i];

            if (currSum == 0) {
                maxLength = Math.max(maxLength, i + 1);
                end = i;
            }

            if (map.containsKey(n + currSum)) {
                maxLength = i - map.get(n + currSum);
                end = i;
            } else map.put(n + currSum, i);
        }
        res[0] = end - maxLength + 1;
        res[1] = end;
        return res;
    }
}
