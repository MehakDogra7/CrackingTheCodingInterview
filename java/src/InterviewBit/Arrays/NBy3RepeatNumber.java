package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NBy3RepeatNumber {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 1, 1, 2, 3, 5, 7));

        System.out.println(getRepeatNumber(A));
        System.out.println(getRepeatNumberOptimal(A));
    }

    private static int getRepeatNumberOptimal(ArrayList<Integer> a) {

        int count = 0, max = 0;
        int count2 = 0, max2 = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(max)) {
                count++;
            } else if (a.get(i).equals(max2)) {
                count2++;
            } else if (count == 0) {
                max = a.get(i);
                count++;
            } else if (count2 == 0) {
                max2 = a.get(i);
                count2++;
            } else {
                count--;
                count2--;
            }
        }

        int currCount = 0;
        int currCount2 = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(max))
                currCount++;
            else if (a.get(i).equals(max2))
                currCount2++;
        }

        return currCount > a.size() / 3 ? max : currCount2 > a.size() / 3 ? max2 : -1;
    }

    private static int getRepeatNumber(ArrayList<Integer> a) {

        int n = a.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : a) {
            if (map.containsKey(integer)) {
                map.put(integer, map.get(integer) + 1);
            } else {
                map.put(integer, 1);
            }
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) > n / 3) {
                return i;
            }
        }

        return -1;
    }
}
