package CompaniesInterviewExperience.Walmart;

import java.util.Arrays;

public class MaximizingDifference {

    public static int getSum(int BITree[], int index) {

        int sum = 0;

        while (index > 0) {

            sum += BITree[index];

            index -= index & (-index);
        }
        return sum;
    }

    public static void updateBIT(int BITree[], int n,
                                 int index, int val) {

        while (index <= n) {

            BITree[index] += val;

            index += index & (-index);
        }
    }

    public static void convert(int arr[], int n) {

        int[] temp = new int[n];
        for (int i = 0; i < n; i++)
            temp[i] = arr[i];

        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {

            arr[i] = Arrays.binarySearch(temp, arr[i]) + 1;
        }
    }

    public static void findElements(int arr[], int n) {
        convert(arr, n);

        int[] BIT = new int[n + 1];
        for (int i = 1; i <= n; i++)
            BIT[i] = 0;

        int[] smaller_right = new int[n];
        int[] greater_left = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            smaller_right[i] = getSum(BIT, arr[i] - 1);

            updateBIT(BIT, n, arr[i], 1);
        }

        System.out.print("Smaller right: ");

        for (int i = 0; i < n; i++)
            System.out.print(smaller_right[i] + " ");

        System.out.println();

        for (int i = 1; i <= n; i++)
            BIT[i] = 0;

        for (int i = 0; i < n; i++) {
            greater_left[i] = i - getSum(BIT, arr[i]);

            updateBIT(BIT, n, arr[i], 1);
        }

        System.out.print("Greater left: ");

        for (int i = 0; i < n; i++)
            System.out.print(greater_left[i] + " ");
    }

    public static void main(String[] args) {
        int arr[] = {12, 1, 2, 3, 0, 11, 4};

        int n = arr.length;

        findElements(arr, n);
    }
}
