package MustDo.Array;

import java.util.Scanner;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int target = scanner.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = scanner.nextInt();
            }

            bruteForce(array, target);
        }
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
}
