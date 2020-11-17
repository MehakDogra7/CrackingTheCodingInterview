package Question450.Array;

import java.util.Scanner;

public class CyclicallyRotateAnArrayByOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];

            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            System.out.print(A[n - 1] + " ");
            for (int i = 0; i < n - 1; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}
