package Question450.SearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class RotiPrataSPOJ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int p = sc.nextInt();
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++)
                A[i] = sc.nextInt();

            System.out.println(solve(A, p, n));
        }
    }

    private static int solve(int[] A, int p, int n) {

        Arrays.sort(A);

        int low = 1, high = 10 * p * (p + 1) / 2;
        while (low < high) {
            int mid = (low + high) / 2;

            if (isPossible(A, p, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /**
     * check whether it is possible to make p parathas with time = mid
     */
    private static boolean isPossible(int[] A, int parathasRequired, int mid) {
        int parathasMade = 0;
        for (int i = 0; i < A.length; i++) {
            int x = solveEquation(mid, A[i]);
            parathasMade += x;
            if (parathasMade >= parathasRequired) return true;
        }
        return false;
    }

    /**
     * ----> mid = x/2 [2*i + (x-1)*i]     -------> find x
     * ----> x^2 + x = [(mid * 2) / i]     -------> solve quadratic equation
     * <p>
     * a = 1, b = 1, c = -[(mid * 2) / i]
     */
    private static int solveEquation(int mid, int i) {
        int temp = (int) Math.sqrt(4 * ((int) ((mid * 2) / i)) + 1);
        temp--;
        temp = temp / 2;
        return temp;
    }
}
