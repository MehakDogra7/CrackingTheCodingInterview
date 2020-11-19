package Question450.Array;

public class BuySellStock {

    public static void main(String[] args) {
        int[] A = {7, 1, 5, 3, 6, 4};
        System.out.println(new BuySellStock().maxProfit(A));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        int maxTillNow = prices[n - 1], max = Integer.MIN_VALUE;

        for (int i = prices.length - 2; i >= 0; i--) {
            int curr = prices[i];
            if (curr > maxTillNow) {
                maxTillNow = curr;
            } else {
                max = Integer.max(max, maxTillNow - curr);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
