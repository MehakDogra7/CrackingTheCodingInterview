package Question450.SearchingAndSorting;

import java.util.Scanner;

public class FirstAndLastPositions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            solve(A, n, x);
        }
    }

    private static void solve(int[] A, int n, int x) {
        int start = binarySearch(A, n, x);
        if (start < 0) {
            System.out.println("-1");
        } else {
            int end = binarySearch(A, n, x + 1);
            System.out.println(start + " " + (Math.abs(end) - 1));
        }
    }

    private static int binarySearch(int[] A, int n, int x) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] >= x) high = mid - 1;
            else low = mid + 1;
        }
        return (low < A.length && A[low] == x) ? low : -low;
    }
}
