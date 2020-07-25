package InterviewBit.TwoPointers;

import java.util.Arrays;

public class CountTriangles {

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 2};

        System.out.println(new CountTriangles().solve(A));
    }

    private int solve(int[] A) {
        Arrays.sort(A);
        long res = 0;
        for (int i = A.length - 1; i > 0; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {
                    res += r - l;
                    res %= 1000000007;
                    r--;
                } else {
                    l++;
                }
            }

        }

        return (int) res;
    }
}
