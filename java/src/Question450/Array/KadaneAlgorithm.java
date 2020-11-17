package Question450.Array;

public class KadaneAlgorithm {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, -2, 5};
        System.out.println(new KadaneAlgorithm().maxSubarraySum(A, A.length));
    }

    int maxSubarraySum(int arr[], int n) {

        // Your code here
        int currSum = arr[0], maxSum = arr[0];

        for (int i = 1; i < n; i++) {
            currSum = Math.max(arr[i], arr[i] + currSum);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
