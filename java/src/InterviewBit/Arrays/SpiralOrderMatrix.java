package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderMatrix {

    public static void main(String[] args) {
        final List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

        A.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        ArrayList<Integer> integers = spiralOrder(A);
        for (Integer i : integers) {
            System.out.println(i + " ");
        }
    }

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {

        ArrayList<Integer> B = new ArrayList<>();
        int t = 0, b = A.size() - 1, l = 0, r = A.get(0).size() - 1;
        int dir = 0;
        while (t <= b && l <= r) {
            if (dir == 0) {
                for (int i = l; i <= r; i++) {
                    B.add(A.get(t).get(i));
                }
                dir = 1;
                t++;
            } else if (dir == 1) {
                for (int i = t; i <= b; i++) {
                    B.add(A.get(i).get(r));
                }
                dir = 2;
                r--;
            } else if (dir == 2) {
                for (int i = r; i >= l; i--) {
                    B.add(A.get(b).get(i));
                }
                dir = 3;
                b--;
            } else if (dir == 3) {
                for (int i = b; i >= t; i--) {
                    B.add(A.get(i).get(l));
                }
                dir = 0;
                l++;
            }

        }
        return B;
    }

}
