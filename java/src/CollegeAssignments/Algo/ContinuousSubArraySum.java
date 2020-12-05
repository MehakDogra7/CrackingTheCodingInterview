package CollegeAssignments.Algo;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {

    public static void main(String[] args) {
        int[] nums = {23, 2, 6, 4, 7};
        System.out.println(new ContinuousSubArraySum().checkSubarraySum(nums, 6));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (k != 0) currSum = currSum % k;
            if (map.containsKey(currSum)) {
                if (i - map.get(currSum) > 1) return true;
            } else map.put(currSum, i);
        }
        return false;
    }
}
