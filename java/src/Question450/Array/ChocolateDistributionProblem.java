package Question450.Array;

import java.util.Arrays;
import java.util.Scanner;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            System.out.println(solve(A, n, m));

            t--;
        }
    }

    private static int solve(int[] A, int n, int m) {

        // Number of students cannot be
        // more than number of packets
        if (n < m)
            return -1;

        Arrays.sort(A);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= n - m; i++) {
            int j = i + m - 1;
            minDiff = Math.min(minDiff, A[j] - A[i]);
        }

        return minDiff;
    }
}
