package Question450.Array;

import java.util.Arrays;
import java.util.Scanner;

public class IsArraySubset {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[] A = new int[m];
            int[] B = new int[n];

            for (int i = 0; i < m; i++) A[i] = sc.nextInt();
            for (int i = 0; i < n; i++) B[i] = sc.nextInt();

            System.out.println(new IsArraySubset().solve(A, B, m, n));
            t--;
        }
    }

    private String solve(int[] A, int[] B, int m, int n) {
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;

        while (i < m && j < n) {
            if (A[i] == B[j]) {
                i++;
                j++;
            } else if (A[i] > B[j]) break;
            else i++;
        }
        if (j == n) return "Yes";
        return "No";
    }
}
