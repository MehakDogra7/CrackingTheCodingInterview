package Question450.SearchingAndSorting;

import java.util.Scanner;

public class TheDoubleHelixSPOJ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            int[] A = new int[n];

            for (int i = 0; i < n; i++)
                A[i] = sc.nextInt();

            int m = sc.nextInt();
            int[] B = new int[m];

            for (int i = 0; i < m; i++)
                B[i] = sc.nextInt();
            System.out.println(solve(A, B, n, m));
        }
    }

    private static long solve(int[] A, int[] B, int n, int m) {

        long currSequenceSumA = 0, currSequenceSumB = 0, maxSum = 0;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (A[i] == B[j]) {
                currSequenceSumA += A[i++];
                currSequenceSumB += B[j++];
                maxSum += Math.max(currSequenceSumA, currSequenceSumB);
                currSequenceSumA = 0;
                currSequenceSumB = 0;
            } else if (A[i] > B[j]) currSequenceSumB += B[j++];
            else currSequenceSumA += A[i++];
        }

        while (i < n) currSequenceSumA += A[i++];
        while (j < m) currSequenceSumB += B[j++];

        maxSum += Math.max(currSequenceSumA, currSequenceSumB);

        return maxSum;
    }
}
