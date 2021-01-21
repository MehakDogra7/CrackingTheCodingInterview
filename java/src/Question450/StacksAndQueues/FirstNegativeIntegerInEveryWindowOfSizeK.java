package Question450.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstNegativeIntegerInEveryWindowOfSizeK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            int[] res = solve(A, n, k);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }

    private static int[] solve(int[] A, int n, int k) {
        ArrayList<Integer> temp = new ArrayList<>();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int curr = A[i];
            if (curr < 0) {
                queue.addLast(i);
            }
        }
        for (int i = k; i < n; i++) {
            if (queue.isEmpty())
                temp.add(0);
            else
                temp.add(A[queue.peekFirst()]);
            if (!queue.isEmpty() && queue.peekFirst() <= i - k)
                queue.pollFirst();
            if (A[i] < 0)
                queue.addLast(i);
        }

        if (queue.isEmpty()) temp.add(0);
        else temp.add(A[queue.peekFirst()]);

        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
}
