package InterviewBit.Arrays;

public class PickFromBothSides {

    public static void main(String[] args) {
        int[] A = {5, -2, 3, 1, 2};
        System.out.println(new PickFromBothSides().solve(A, 3));
    }

    public int solve(int[] A, int B) {
        if (A.length == 1) return A[0];
        int n = A.length, minSum, currSum = 0, totalSum = 0, rem = n - B;

        for (int i = 0; i < rem; i++) {
            currSum += A[i];
            totalSum += A[i];
        }
        minSum = currSum;
        for (int i = rem; i < n; i++) {
            currSum = currSum + A[i] - A[i - rem];
            minSum = Integer.min(minSum, currSum);
            totalSum += A[i];
        }
        return totalSum - minSum;
    }


}
