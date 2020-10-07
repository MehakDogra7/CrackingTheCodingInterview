package InterviewBit.GreedyAlgorithm;

import java.util.Arrays;

public class DistributeCandy {

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4, 6, 10, -11};

        System.out.println(new DistributeCandy().solve(A));
        System.out.println(new DistributeCandy().solveOptimal(A));
    }

    private int solveOptimal(int[] A) {
        int n = A.length, count = 0;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);

        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) candy[i] = candy[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) candy[i] = Math.max(candy[i], candy[i + 1] + 1);
        }

        for (int x : candy) count += x;
        return count;
    }

    private int solve(int[] A) {
        if (A.length < 2) return A.length;

        int ans = 0, n = A.length;
        int[] chocolate = new int[n];
        chocolate[0] = 1;

        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                chocolate[i] = chocolate[i - 1] + 1;
            } else if (A[i] <= A[i - 1]) {
                if (chocolate[i - 1] > 1) {
                    chocolate[i] = 1;
                } else {
                    chocolate[i] = 1;
                    int j = i - 1;
                    while ((j >= 0 && A[j] > A[j + 1] && chocolate[j] == chocolate[j + 1])) {
                        chocolate[j--]++;
                    }
                }
            }
        }

        for (int i : chocolate) {
            ans += i;
        }
        return ans;
    }
}
