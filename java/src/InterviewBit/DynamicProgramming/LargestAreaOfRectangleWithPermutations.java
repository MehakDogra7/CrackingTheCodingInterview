package InterviewBit.DynamicProgramming;

import java.util.Arrays;

public class LargestAreaOfRectangleWithPermutations {

    public static void main(String[] args) {
        int[][] A = {
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0}
        };
        System.out.println(new LargestAreaOfRectangleWithPermutations().solve(A));      //Exchange column 2 and 3
    }

    private int solve(int[][] A) {
        int n = A.length, m = A[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] != 0) A[i][j] = A[i - 1][j] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.sort(A[i]);
        }

        int maxArea = 0, currArea = 0;
        for (int i = 0; i < n; i++) {
            int width = 1;
            for (int j = m - 1; j >= 0; j--) {
                currArea = A[i][j] * width++;
                maxArea = Integer.max(maxArea, currArea);
            }
        }
        return maxArea;
    }
}
