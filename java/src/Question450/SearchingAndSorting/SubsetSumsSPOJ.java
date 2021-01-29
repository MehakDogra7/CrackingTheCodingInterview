package Question450.SearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

//TODO
public class SubsetSumsSPOJ {

    static int[] dp;
    static int count, a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        int[] Array = new int[N];
        for (int i = 0; i < N; i++)
            Array[i] = sc.nextInt();
        System.out.println(solve(Array, N));
    }

    private static int solve(int[] Array, int n) {
        count = 0;
        dp = new int[n];
        Arrays.fill(dp, 0);

        topDown(Array, n - 1, 0);
        if (0 >= a && 0 <= b) count++;

        return count;
    }

    private static void topDown(int[] Array, int index, int sumTillNow) {
        if (index < 0) return;

        if (Array[index] + sumTillNow >= a && Array[index] + sumTillNow <= b) count++;

        topDown(Array, index - 1, sumTillNow);
        topDown(Array, index - 1, sumTillNow + Array[index]);
    }
}
