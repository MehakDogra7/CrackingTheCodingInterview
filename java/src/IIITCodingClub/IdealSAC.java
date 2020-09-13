package IIITCodingClub;

import java.util.Scanner;

public class IdealSAC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            System.out.println(solve(A));
            t--;
        }
    }

    private static long solve(int[] A) {
        if (A.length < 2) return 0;
        int n = A.length;
        long res = 0;

        for (int i = 0; i < n - 1; ) {
            int j = getMax(A, i);
            res = res + ((j - i) * Long.min(A[i], A[j]));
            i = j;
        }
        return res;
    }

    private static int getMax(int[] A, int i) {
        int max = 0;
        int maxIndex = i + 1;
        for (int j = i + 1; j < A.length; j++) {
            if (A[j] > A[i]) return j;

            if (A[j] > max) {
                max = A[j];
                maxIndex = j;
            }
        }
        return maxIndex;
    }

}
