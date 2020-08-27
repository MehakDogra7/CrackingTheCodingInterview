package InterviewBit.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticProgression {

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(new LongestArithmeticProgression().solve(A));
    }

    private int solve(int[] A) {
        if (A.length < 2) return A.length;
        int n = A.length, max, finalMax = Integer.MIN_VALUE;

        Map<Integer, Integer>[] dp = new HashMap[A.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dp[0] = map;
        for (int i = n - 1; i >= 0; i--) {
            max = 2;
            Map<Integer, Integer> newMap = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int currD = A[i] - A[j];
                Map<Integer, Integer> currMap = dp[j];
                if (currMap.containsKey(currD)) {
                    max = Integer.max(max, currMap.get(currD) + 1);
                }
                int value = currMap.containsKey(currD) ? currMap.get(currD) + 1 : 2;
                if (!newMap.containsKey(currD) || newMap.get(currD) < value)
                    newMap.put(currD, value);
            }
            dp[i] = newMap;
            finalMax = Integer.max(finalMax, max);
        }

        return finalMax;
    }
}
