package InterviewBit.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValueLessThanK {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(0, 1, 2, 5));
        int B = 2;
        int C = 21;

        System.out.println(new ValueLessThanK().solve(A, B, C));
    }

    public int solve(ArrayList<Integer> A, int B, int C) {

        int n = A.size();
        String strC = String.valueOf(C);
        int lengthOfC = strC.length();
        int[] dp = new int[B + 1];

        if (B > lengthOfC || A.size() == 0)
            return 0;

        else if (B < lengthOfC) {
            if (A.get(0) == 0 && B != 1) {
                return (int) ((n - 1) * Math.pow(n, B - 1));
            } else {
                return (int) Math.pow(n, B);
            }
        } else {

            int[] Lower = new int[11];
            boolean flag = true;

            populateLower(Lower, A);

            int d2;
            for (int i = 1; i < dp.length; i++) {
                int val = Integer.parseInt(String.valueOf(strC.charAt(i - 1)));
                d2 = Lower[val];
                dp[i] = dp[i - 1] * A.size();

                if (i == 1 && A.get(0) == 0 && B != 1)
                    d2 = d2 - 1;

                if (flag)
                    dp[i] += d2;

                flag = (flag & (Lower[val + 1] ==
                        Lower[val] + 1));
            }
        }
        return dp[B];
    }

    private void populateLower(int[] Lower, ArrayList<Integer> A) {
        Integer[] a = new Integer[A.size()];
        A.toArray(a);

        for (int i = 1; i < Lower.length; i++) {
            int index = Arrays.binarySearch(a, i);
            if (index >= 0) {
                Lower[i] = index;
            } else {
                Lower[i] = Math.abs(index) - 1;
            }
        }
    }

}
