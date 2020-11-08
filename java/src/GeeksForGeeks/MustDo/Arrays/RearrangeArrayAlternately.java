package GeeksForGeeks.MustDo.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RearrangeArrayAlternately {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            solve(A);
            t--;
        }
    }

    private static void solve(int[] A) {
        Arrays.sort(A);
        int start = 0, end = A.length - 1;
        while (start < end) {
            System.out.print(A[end--] + " " + A[start++] + " ");
        }
        if (A.length % 2 != 0) System.out.println(A[start]);
        else System.out.println();
    }
}
