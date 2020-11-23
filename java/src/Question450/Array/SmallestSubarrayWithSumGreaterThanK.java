package Question450.Array;

import java.util.Scanner;

public class SmallestSubarrayWithSumGreaterThanK {

    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }

            System.out.println(solve(A, x));
        }
    }

    private static int solve(int[] A, int x) {
        int minLength = A.length, sum = 0, start = 0, end = 0;

        while (end < A.length) {

            while (end < A.length && sum <= x) {
                sum += A[end++];
            }

            while (start < A.length && sum > x) {
                minLength = Math.min(minLength, end - start);
                sum -= A[start++];
            }
        }

        return minLength;
    }
}
