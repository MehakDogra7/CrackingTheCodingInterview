package InterviewBit.TwoPointers;

import java.util.Arrays;

public class SumOf3Numbers {

    public static void main(String[] args) {
        int[] A = {-1, 2, 1, -4};
        int B = 1;

        /*int[] A = {1, 2, 3, 4, 5};
        int B = 9;*/

        System.out.println(new SumOf3Numbers().solveBruteForce(A, B));
        System.out.println(new SumOf3Numbers().solveOptimal(A, B));
    }

    private int solveBruteForce(int[] A, int B) {

        //int sum = 0;
        int oldDiff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    int sum = A[i] + A[j] + A[k];
                    int currDiff = Math.abs(B - sum);
                    if (currDiff < oldDiff) {
                        oldDiff = currDiff;
                        ans = sum;
                    }
                }
            }
        }
        return ans;
    }

    private int solveOptimal(int[] A, int B) {

        Arrays.sort(A);
        int ans = 0;
        int oldDiff = Integer.MAX_VALUE;
        int currDiff = 0;

        for (int i = 0; i < A.length; i++) {
            int p1 = i + 1;
            int p2 = A.length - 1;
            while (p1 < p2) {
                int sum = A[i] + A[p1] + A[p2];
                if (sum == B) {
                    return sum;
                } else if (sum < B) {
                    p1++;
                } else {
                    p2--;
                }
                currDiff = Math.abs(B - sum);
                if (currDiff < oldDiff) {
                    oldDiff = currDiff;
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
