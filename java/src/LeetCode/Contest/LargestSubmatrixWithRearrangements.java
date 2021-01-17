package LeetCode.Contest;

import java.util.HashMap;
import java.util.Map;

public class LargestSubmatrixWithRearrangements {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 1}
        };
        System.out.println(new LargestSubmatrixWithRearrangements().largestSubmatrix(matrix));
    }


    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) dp[i][j] = dp[i - 1][j] + 1;
            }
        }

        for (int i = 0; i < m; i++) {
            Map<Integer, Integer> rowCount = new HashMap<>();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                int curr = dp[i][j];
                min = Math.min(min, curr);
                max = Math.max(max, curr);
                rowCount.put(curr, rowCount.getOrDefault(curr, 0) + 1);
            }
            int sum = 0;
            for (int k = max; k >= min; k--) {
                if (rowCount.containsKey(k)) {
                    rowCount.put(k, rowCount.get(k) + sum);

                    sum = rowCount.get(k);
                    maxArea = Math.max(maxArea, (k * sum));
                }
            }
        }
        return maxArea;
    }
}
