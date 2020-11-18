package Question450.Array;

public class Sort012 {

    public static void main(String[] args) {
        int[] A = {0, 2, 1, 2, 0};
        sort012(A, A.length);
        for (int i : A) {
            System.out.print(i + " ");
        }
        int[] B = {0, 2, 1, 2, 0};
        sort012Optimized(B, B.length);
        for (int i : B) {
            System.out.print(i + " ");
        }
    }


    public static void sort012(int a[], int n) {
        // code here
        int zero = 0, one = 0, two = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) zero++;
            else if (a[i] == 1) one++;
            else two++;
        }
        int i = 0;
        while (zero > 0) {
            a[i++] = 0;
            zero--;
        }
        while (one > 0) {
            a[i++] = 1;
            one--;
        }
        while (two > 0) {
            a[i++] = 2;
            two--;
        }
    }

    public static void sort012Optimized(int a[], int n) {
        int low = 0, high = n - 1, mid = 0;

        while (mid < high) {
            if (a[mid] == 0) swap(a, low++, mid++);
            else if (a[mid] == 2) swap(a, high--, mid);
            else mid++;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
