package CollegeAssignments.Algo;

import java.util.Stack;

public class MostCompetitiveSubsequence {

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 6};
        int k = 2;
        int[] result = new MostCompetitiveSubsequence().mostCompetitive(nums, k);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    /**
     * Time Complexity : O(n)
     * Space Complexity: O(n)
     *
     * @param nums - Array of integers.
     * @param k    - size of subsequence.
     * @return - competitive subsequence of nums of size k.
     */
    public int[] mostCompetitive(int[] nums, int k) {
        int[] result = new int[k];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            while (!stack.isEmpty() && curr < stack.peek() && stack.size() - 1 + nums.length - i >= k)
                stack.pop();
            if (stack.size() < k) stack.push(curr);
        }

        for (int i = result.length - 1; i >= 0; i--)
            result[i] = stack.pop();

        return result;
    }
}
