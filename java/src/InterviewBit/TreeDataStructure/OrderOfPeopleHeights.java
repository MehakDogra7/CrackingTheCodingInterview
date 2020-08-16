package InterviewBit.TreeDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class OrderOfPeopleHeights {

    public static void main(String[] args) {

        int[] heights = {86, 92, 49, 21, 62, 27, 90, 59};
        int[] inFronts = {2, 0, 0, 2, 0, 2, 1, 3};

        int[] solve = new OrderOfPeopleHeights().solve(heights, inFronts);
        for (int i : solve) {
            System.out.print(i + " ");
        }
    }

    private int[] solve(int[] A, int[] B) {
        int[] res = new int[A.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], B[i]);
        }
        ArrayList<Integer> positionLeft = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            positionLeft.add(i);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer index = positionLeft.get(entry.getValue());
            res[index] = entry.getKey();
            positionLeft.remove((int) entry.getValue());

        }

        return res;
    }
}
