package Question450.SearchingAndSorting;

import java.util.Scanner;

//TODO
public class KthElementIn2SortedArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[m];

        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            B[i] = sc.nextInt();
        System.out.println(solve(A, B, n, m, k));

    }

    private static int solve(int[] A, int[] B, int n, int m, int k) {


        return 0;
    }
}
