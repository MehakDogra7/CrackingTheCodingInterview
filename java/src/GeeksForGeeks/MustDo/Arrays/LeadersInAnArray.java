package GeeksForGeeks.MustDo.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeadersInAnArray {


    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int A[] = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(inputLine[i]);
            }
            solve(A, n);
        }
    }

    private static void solve(int[] A, int n) {
        int maxTillNow = Integer.MIN_VALUE;
        int[] maxRight = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = maxTillNow;
            maxTillNow = Math.max(maxTillNow, A[i]);
        }

        for (int i = 0; i < n; i++) {
            if (A[i] >= maxRight[i]) {
                System.out.print(A[i] + " ");
            }
        }

        System.out.println();
    }
}
