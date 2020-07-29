package MustDo.Arrays;

import java.util.HashMap;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {

        int[] array = {10, 2, -2, -20, 10};
        int target = -10;
        bruteForce(array, target);
        optimal(array, target);
        optimal2(array, target);
    }

    /**
     * T.C. : O(n^2)
     *
     * @param array
     * @param target
     */
    private static void bruteForce(int[] array, int target) {
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            int sum = array[i];
            int j = i + 1;
            while (sum < target && j < array.length) {
                sum += array[j];
                j++;
            }
            if (sum == target) {
                System.out.println(i + 1 + " " + j);
                flag = true;
                return;
            }
        }
        if (!flag) {
            System.out.println("-1");
        }
    }

    /**
     * T.C. : O(n)
     * Doesn't handle negative values
     *
     * @param array
     * @param target
     */
    private static void optimal(int[] array, int target) {
        int l = 0;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            while (sum > target && l < i) {
                sum -= array[l++];
            }

            if (sum == target) {
                System.out.println(l + " " + i);
                return;
            }
        }

        System.out.println("-1");
    }

    /**
     * T.C. : O(n)
     * S.C. : O(n)
     * Does handle negative values
     *
     * @param array
     * @param target
     */
    private static void optimal2(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int currSum = 0;
        int start = 0;
        int end = -1;

        for (int i = 0; i < array.length; i++) {
            currSum += array[i];

            if (currSum == target) {
                start = 0;
                end = i;
                break;
            }

            if (map.containsKey(currSum - target)) {
                start = map.get(currSum - target) + 1;
                end = i;
                break;
            }

            map.put(currSum, i);
        }

        System.out.println(start + " " + end);
    }
}
