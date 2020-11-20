package Question450.Array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TripletSumInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            int[] A = new int[n];

            for (int i = 0; i < n; i++) A[i] = sc.nextInt();

            System.out.println(solve(A, n, x));
            t--;
        }
    }

    private static int solve(int[] A, int n, int x) {

        Set<Integer> set = new HashSet<>();
        set.add(A[0]);

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int currSum = A[i] + A[j];
                if (set.contains(x - currSum)) return 1;
            }
            set.add(A[i]);
        }
        return 0;
    }

}
