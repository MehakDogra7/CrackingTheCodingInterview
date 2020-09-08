package InterviewBit.DynamicProgramming;

public class RodCutting {
    int[][] dp;

    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Maximum Obtainable Value is " + new RodCutting().cutRod(arr));

    }

    private int cutRod(int[] A) {
        dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                dp[i][j] = -1;
            }
        }
        return cutRodTopDown(A, 0, 0);
    }

    private int cutRodTopDown(int[] A, int index, int sumTillNow) {
        if (sumTillNow >= A.length || index == A.length || sumTillNow + index + 1 > A.length) return 0;

        if (dp[index][sumTillNow] != -1) return dp[index][sumTillNow];

        //Don't consider it
        int dont = cutRodTopDown(A, index + 1, sumTillNow);
        //consider it
        int doSameIndex = A[index] + cutRodTopDown(A, index, sumTillNow + (index + 1));
        int doDiffIndex = A[index] + cutRodTopDown(A, index + 1, sumTillNow + (index + 1));

        dp[index][sumTillNow] = Integer.max(dont, Integer.max(doSameIndex, doDiffIndex));
        return dp[index][sumTillNow];
    }
}
