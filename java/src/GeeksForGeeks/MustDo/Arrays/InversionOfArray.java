package GeeksForGeeks.MustDo.Arrays;

import java.util.Scanner;

public class InversionOfArray {
    static long count = 0;

    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            count = 0;
            mergeSort(A, 0, A.length - 1);
            System.out.println(count);
            t--;
        }
    }

    private static void mergeSort(int[] A, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            merge(A, start, mid, end);
        }
    }

    private static void merge(int[] A, int start, int mid, int end) {
        int[] B = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i < mid + 1 && j < end + 1) {
            if (A[i] <= A[j])
                B[k++] = A[i++];
            else {
                count += mid - i + 1;
                B[k++] = A[j++];
            }
        }
        while (i < mid + 1) {
            B[k++] = A[i++];
        }
        while (j < end + 1) {
            B[k++] = A[j++];
        }
        i = start;
        for (int l = 0; l < B.length; l++) {
            A[start++] = B[l];
        }

    }
}
