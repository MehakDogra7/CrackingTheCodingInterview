package Question450.Heap;

import java.util.Scanner;

public class Merge2BinaryMaxHeaps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] A = new int[n];
            int[] B = new int[m];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                B[i] = sc.nextInt();
            }

            int[] res = new Merge2BinaryMaxHeaps().solve(A, B, n, m);
            for (int re : res) {
                System.out.print(re + " ");
            }
            System.out.println();
        }
    }

    private int[] solve(int[] A, int[] B, int n, int m) {

        int[] res = new int[n + m];
        int r = 0;
        for (int i = 0; i < n; i++) {
            res[r++] = A[i];
        }
        for (int i = 0; i < m; i++) {
            res[r++] = B[i];
        }

        for (int i = (n + m) / 2 - 1; i >= 0; i--) {
            maxHeapify(res, n + m, i);
        }
        return res;
    }

    private void maxHeapify(int[] res, int n, int i) {
        while (i < n) {
            int largest = i;
            if ((2 * i + 1) < n && res[2 * i + 1] > res[largest])
                largest = 2 * i + 1;
            if ((2 * i + 2) < n && res[2 * i + 2] > res[largest])
                largest = 2 * i + 2;

            if (largest == i) break;
            swap(res, largest, i);
            i = largest;
        }
    }

    private void swap(int[] res, int i, int j) {
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }
}
