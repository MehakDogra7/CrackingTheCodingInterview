package Question450.Heap;

import java.util.PriorityQueue;

public class KthLargestSumContinuousSubarrays {

    public static void main(String[] args) {
        int[] A = {20, -5, -1};
        int k = 3;
        System.out.println(new KthLargestSumContinuousSubarrays().solve(A, k));
    }

    private int solve(int[] A, int k) {
        int n = A.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        prefixSum[1] = A[0];
        for (int i = 2; i < n + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                int currSum = prefixSum[j] - prefixSum[i];
                if (heap.size() < k) heap.add(currSum);
                else {
                    if (currSum > heap.peek()) {
                        heap.poll();
                        heap.add(currSum);
                    }
                }
            }
        }

        return heap.peek();
    }
}
