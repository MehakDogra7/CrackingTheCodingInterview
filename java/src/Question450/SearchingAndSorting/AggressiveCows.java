package Question450.SearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int C = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            System.out.println(solve(A, N, C));
        }
    }

    private static int solve(int[] A, int N, int C) {

        Arrays.sort(A);
        int low = 1, high = A[N - 1], result = -1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (isFeasable(mid, A, N, C)) {
                result = Math.max(result, mid);
                low = mid + 1;
            } else
                high = mid;
        }
        return result;
    }

    private static boolean isFeasable(int mid, int[] A, int N, int C) {

        int prevCowPosition = A[0], cowsPlaced = 1;

        for (int i = 1; i < N; i++) {
            if (A[i] - prevCowPosition >= mid) {
                cowsPlaced++;
                prevCowPosition = A[i];

                if (cowsPlaced == C) return true;
            }
        }
        return false;
    }
}
