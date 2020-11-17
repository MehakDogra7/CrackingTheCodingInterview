package Question450.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveAllNegToEnd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> negative = new ArrayList<>();
            StringBuilder res = new StringBuilder("");
            while (n > 0) {
                int curr = sc.nextInt();
                if (curr >= 0) res.append(curr).append(" ");
                else negative.add(curr);
                n--;
            }
            negative.forEach(i -> res.append(i).append(" "));

            System.out.println(res.toString().trim());
            t--;
        }
    }

    private static int[] move(int[] A) {
        int[] res = new int[A.length];
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) res[j++] = A[i];
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) res[j++] = A[i];
        }
        return res;
    }


}
