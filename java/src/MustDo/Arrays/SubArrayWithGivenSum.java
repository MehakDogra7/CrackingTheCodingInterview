package MustDo.Arrays;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {

        int[] array = {1, 2, 3};
        int target = 3;
        //bruteForce(array, target);
        optimal(array, target);
    }

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
}
