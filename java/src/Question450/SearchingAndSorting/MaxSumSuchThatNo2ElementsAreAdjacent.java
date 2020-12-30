package Question450.SearchingAndSorting;

import java.util.Scanner;

public class MaxSumSuchThatNo2ElementsAreAdjacent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            System.out.println(new MaxSumSuchThatNo2ElementsAreAdjacent().solve(A, A.length));
        }
    }

    private int solve(int[] A, int n) {
        if (n == 1) return A[0];

        int[] dp = new int[n];
        dp[n - 1] = A[n - 1];
        dp[n - 2] = Math.max(A[n - 1], A[n - 2]);

        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], A[i] + dp[i + 2]);
        }

        return dp[0];
    }
}
