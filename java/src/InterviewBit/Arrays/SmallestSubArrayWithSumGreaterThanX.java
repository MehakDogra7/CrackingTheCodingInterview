package InterviewBit.Arrays;

public class SmallestSubArrayWithSumGreaterThanX {

    public static void main(String[] args) {
        int[] A = {1, 4, 45, 6, 0, 19};
        System.out.println(new SmallestSubArrayWithSumGreaterThanX().solve(A, 51));
    }

    private int solve(int[] A, int target) {
        int currSum = 0;
        int start = 0, end = 0;
        int minLength = A.length + 1;

        while (end < A.length) {

            while (currSum <= target && end < A.length)
                currSum += A[end++];

            while (currSum > target && start < A.length) {
                minLength = Math.min(minLength, end - start);
                currSum -= A[start++];
            }
        }
        return minLength;
    }
}
