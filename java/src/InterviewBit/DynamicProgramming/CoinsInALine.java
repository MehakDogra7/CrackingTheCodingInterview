package InterviewBit.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class CoinsInALine {

    int[][] dp;

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(26, 88, 57, 26, 65, 60, 55, 40));
        System.out.println(new CoinsInALine().maxcoin(A));
    }

    public int maxcoin(ArrayList<Integer> A) {
        dp = new int[A.size() + 1][A.size() + 1];
        for (int i = 0; i < A.size() + 1; i++) {
            for (int j = 0; j < A.size() + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return recursive(A, 0, A.size(), 1);
    }

    private int recursive(ArrayList<Integer> list, int start, int end, int flag) {
        if (start > end) return 0;
        if (end == start) return list.get(start);
        if (end - start == 2) return Integer.max(list.get(start), list.get(end - 1));
        if (dp[start][end] != -1) return dp[start][end];

        if (flag == 0) {
            dp[start][end] = Integer.min(recursive(list, start + 1, end, 1),
                    recursive(list, start, end - 1, 1));
            return dp[start][end];
        }

        int startV = list.get(start) + recursive(list, start + 1, end, 0);
        int endV = list.get(end - 1) + recursive(list, start, end - 1, 0);
        dp[start][end] = Integer.max(startV, endV);
        return dp[start][end];
    }
}
