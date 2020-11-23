package Question450.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TrappingRainWater {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] A = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(solve(A, n));
        }
    }

    private static int solve(int[] A, int n) {
        int res = 0;

        int[] greatestLeft = new int[n];

        int maxTillNow = A[0];

        for (int i = 1; i < n - 1; i++) {
            if (A[i] >= maxTillNow) maxTillNow = A[i];
            else greatestLeft[i] = maxTillNow - A[i];
        }
        maxTillNow = A[n - 1];
        for (int i = n - 2; i > 0; i--) {
            int temp = 0;
            if (A[i] >= maxTillNow) maxTillNow = A[i];
            else temp = maxTillNow - A[i];
            res += Math.min(greatestLeft[i], temp);
        }

        return res;
    }
}
