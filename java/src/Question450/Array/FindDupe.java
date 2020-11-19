package Question450.Array;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/submissions/
 */
public class FindDupe {

    public static void main(String[] args) {
        int[] A = {2, 2, 2, 2, 2};
        System.out.println(new FindDupe().findDuplicate(A));
    }

    //Floyd's cycle detection
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int tortoise = nums[0], hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return tortoise;
    }
}
