package InterviewBit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum2 {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 1, 8));
        new Sum2().twoSum(A, 9).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int index1 = 0;
        int index2 = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(B - A.get(i))) {
                index1 = map.get(B - A.get(i));
                index2 = i;
                break;
            }
            if (!map.containsKey(A.get(i))) {
                map.put(A.get(i), i);
            }
        }

        if (index2 != Integer.MAX_VALUE) {
            result.add(index1 + 1);
            result.add(index2 + 1);
        }
        return result;
    }
}
