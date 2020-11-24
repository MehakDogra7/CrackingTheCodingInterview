package Question450.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinSwapsKTogether {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] A = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(solve(A, n, k));
        }
    }

    /*private static int solve(int[] A, int n, int k) {
        int swapCount = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (A[i] <= k) list.add(i);
        }

        int median = list.size() / 2;

        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            int dest = list.get(median) - (median - i);
            if(Math.abs(dest-curr) != 0) swapCount++;
        }

        return swapCount;
    }*/

    private static int solve(int[] A, int n, int k) {
        int count = 0, bad = 0, minSwaps;

        for (int i : A) {
            if (i <= k) count++;
        }
        int i = 0;
        for (; i < count; i++) {
            if (A[i] > k) bad++;
        }
        minSwaps = bad;
        int start = 0, end = start + count - 1;
        while (end < n - 1) {
            if (A[start++] > k) bad--;
            if (A[++end] > k) bad++;

            minSwaps = Math.min(minSwaps, bad);
        }
        return minSwaps;
    }


}
