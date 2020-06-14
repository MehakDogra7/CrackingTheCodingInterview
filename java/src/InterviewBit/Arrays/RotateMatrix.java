package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateMatrix {

    public static void main(String[] args) {
        final List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

        A.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        A.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });

        System.out.println();
        rotateMatrix(A);

        A.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    private static void rotateMatrix(List<ArrayList<Integer>> a) {

        for (int layer = 0; layer < a.size() / 2; layer++) {
            int first = layer;
            int last = a.size() - layer - 1;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = a.get(first).get(i);

                //left --> top
                a.get(first).set(i, a.get(last - offset).get(first));

                //bottom --> left
                a.get(last - offset).set(first, a.get(last).get(last - offset));

                //right --> bottom
                a.get(last).set(last - offset, a.get(i).get(last));

                //top --> right
                a.get(i).set(last, top);
            }
        }
    }


}
