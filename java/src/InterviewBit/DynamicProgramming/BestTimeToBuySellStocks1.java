package InterviewBit.DynamicProgramming;

public class BestTimeToBuySellStocks1 {

    public static void main(String[] args) {
        int[] A = {1, 4, 5, 2, 4};
        System.out.println(new BestTimeToBuySellStocks1().solve(A));
    }

    private int solve(int[] A) {
        if (A.length <= 1) return 0;
        int maxTillNow = 0, maxProfit = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < maxTillNow) {
                maxProfit = Integer.max(maxProfit, maxTillNow - A[i]);
            }
            maxTillNow = Integer.max(maxTillNow, A[i]);
        }
        return maxProfit;
    }
}
