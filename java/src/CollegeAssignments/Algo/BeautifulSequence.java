package CollegeAssignments.Algo;

import java.util.ArrayList;
import java.util.Scanner;

public class BeautifulSequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt() - i;
            }
            System.out.println(N - longestIncreasingSubsequence(a));
        }

    }

    private static int longestIncreasingSubsequence(int[] A) {
        ArrayList<Integer> dp = new ArrayList<>();
        int n = A.length;
        dp.add(0);

        for (int i = 0; i < n; i++) {
            if (A[i] <= 0) continue;

            int curr = A[i];
            int index = binarySearch(dp, curr);
            if (index == dp.size() - 1) dp.add(curr);
            else dp.set(index + 1, curr);
        }
        return dp.size() - 1;
    }

    private static int binarySearch(ArrayList<Integer> dp, int curr) {
        int low = 0, high = dp.size() - 1;

        while (low < high) {
            int mid = (low + high) / 2 + 1;
            if (dp.get(mid) <= curr) low = mid;
            else high = mid - 1;
        }
        return low;
    }
}
