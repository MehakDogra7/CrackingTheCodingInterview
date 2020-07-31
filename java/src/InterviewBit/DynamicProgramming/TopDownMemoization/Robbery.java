package InterviewBit.DynamicProgramming.TopDownMemoization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Robbery {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(200, 7000, 900, 300, 1000));
        System.out.println(new Robbery().solve(A));
    }

    private int solve(ArrayList<Integer> A) {
        int[] dp = new int[A.size()];
        Arrays.fill(dp, -1);

        return maxRobbery(A, dp, 0);
    }

    private int maxRobbery(ArrayList<Integer> A, int[] dp, int i) {

        if (i == A.size() - 1) {
            dp[i] = A.get(i);
            return dp[i];
        } else if (i == A.size() - 2) {
            dp[i] = Integer.max(A.get(i), A.get(i + 1));
            return dp[i];
        }

        if (dp[i + 1] == -1) {
            dp[i + 1] = maxRobbery(A, dp, i + 1);
        }
        if (dp[i + 2] == -1) {
            dp[i + 2] = maxRobbery(A, dp, i + 2);
        }

        return Integer.max((A.get(i) + dp[i + 2]), (dp[i + 1]));
    }


}
