package InterviewBit.GreedyAlgorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] A = {2, 1, 2};
        System.out.println(new MajorityElement().majorityElement(A));
        System.out.println(new MajorityElement().majorityElementConstantSpace(A));
    }

    public int majorityElementConstantSpace(final int[] A) {
        int maxIndex = 0, count = 1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == A[maxIndex]) count++;
            else count--;

            if (count == 0) {
                maxIndex = i;
                count = 1;
            }
        }
        return A[maxIndex];
    }

    public int majorityElement(final int[] A) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int majority = A.length / 2;
        for (int i = 0; i < A.length; i++) {
            int curr = A[i];
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) + 1);
            } else {
                map.put(curr, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majority) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
