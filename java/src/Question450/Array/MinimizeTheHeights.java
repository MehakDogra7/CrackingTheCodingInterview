package Question450.Array;

import java.util.Arrays;

public class MinimizeTheHeights {

    public static void main(String[] args) {
        int[] A = {1, 5, 8, 10};
        System.out.println(new MinimizeTheHeights().getMinDiff(A, A.length, 2));
    }

    int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int x = arr[0] + k;
        int y = arr[n - 1] - k;
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        int ans = arr[n - 1] - arr[0];

        for (int i = 1; i < n - 1; i++) {
            int curr = arr[i];
            int add = curr + k;
            int subtract = curr - k;

            if (subtract >= min || add <= max) continue;
            else if (max - subtract <= add - min) {
                min = subtract;
            } else {
                max = add;
            }
        }

        return Math.min(ans, max - min);
    }
}
