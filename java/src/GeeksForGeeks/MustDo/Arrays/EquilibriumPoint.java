package GeeksForGeeks.MustDo.Arrays;

public class EquilibriumPoint {
    public static void main(String[] args) {
        long[] A = {1, 3, 5, 2, 2};
        System.out.println(equilibriumPoint(A, A.length));
    }

    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        if (n == 1) return 1;

        for (int i = 1; i < n; i++)
            arr[i] += arr[i - 1];

        long sumTillNow = 0;
        for (int i = arr.length - 1; i >= 1; i--) {
            long actual = arr[i] - arr[i - 1];
            if (sumTillNow == arr[i - 1]) return i + 1;
            sumTillNow += actual;
        }
        return -1;
    }
}
