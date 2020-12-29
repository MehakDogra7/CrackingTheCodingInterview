package InterviewBit.DynamicProgramming;

public class EggDroppingProblem {
//TODO
    public static void main(String[] args) {
        int numberOfEggs = 2;
        int numberOfFloors = 100;
        System.out.println(new EggDroppingProblem().findMinimumAttempts(numberOfEggs, numberOfFloors));
        System.out.println(new EggDroppingProblem().findMinimumAttemptsUsingBinomialCoefficient(numberOfEggs, numberOfFloors));
    }

    /**
     * TC: O(numberOfEggs * numberOfFloors * numberOfFloors)
     * @param numberOfEggs
     * @param numberOfFloors
     * @return
     */
    private int findMinimumAttempts(int numberOfEggs, int numberOfFloors) {

        int[][] dp = new int[numberOfEggs + 1][numberOfFloors + 1];         //eggs - row, floors - column

        for (int i = 1; i < numberOfFloors + 1; i++) dp[1][i] = i;
        for (int i = 1; i < numberOfEggs + 1; i++) dp[i][1] = 1;


        for (int i = 2; i < numberOfEggs + 1; i++) {
            for (int j = 2; j < numberOfFloors + 1; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    int eggBreak = dp[i - 1][k - 1];
                    int eggDoesntBreaks = dp[i][j - k];
                    min = Math.min(min, Math.max(eggBreak, eggDoesntBreaks));
                }
                dp[i][j] = 1 + min;
            }
        }

        return dp[numberOfEggs][numberOfFloors];
    }

    /**
     * TC: O(numberOfEggs * log(numberOfFloors))
     * @param numberOfEggs
     * @param numberOfFloors
     * @return
     */
    private int findMinimumAttemptsUsingBinomialCoefficient(int numberOfEggs, int numberOfFloors) {
        int low = 1, high = numberOfFloors;

        while (low < high) {
            int mid = (low + high) / 2;
            if (binomialCoefficient(mid, numberOfEggs, numberOfFloors) < numberOfFloors)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int binomialCoefficient(int x, int n, int k) {
        int sum = 0, term = 1;
        for (int i = 1; i < n + 1 && sum < k; i++) {
            term = term * (x - i + 1);
            term = term / i;
            sum = sum + term;
        }
        return sum;
    }

}
