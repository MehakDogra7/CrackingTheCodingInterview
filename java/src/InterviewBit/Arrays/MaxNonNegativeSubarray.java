package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxNonNegativeSubarray {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>(List.of(1967513926, 1540383426, -1303455736, -521595368));
        maxset(A).forEach(System.out::println);
        System.out.println("---------------");
        maxsetExtraSpace(A).forEach(System.out::println);
    }

    public static ArrayList<Integer> maxsetExtraSpace(ArrayList<Integer> A) {
        ArrayList<Integer> maxList = new ArrayList<>();
        ArrayList<Integer> newList = new ArrayList<>();
        long newSum = 0, maxSum = 0;
        for (Integer i : A) {
            if (i >= 0) {
                newSum += i;
                newList.add(i);
            } else {
                newSum = 0;
                newList = new ArrayList<>();
            }
            if ((newSum > maxSum) || (newSum == maxSum && newList.size() > maxList.size())) {
                maxList = newList;
                maxSum = newSum;
            }
        }
        return maxList;
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean flag = false;
        int start = 0, end = 0, current = 0;
        long curr_max = 0, max = 0;

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < 0) {
                current = i + 1;
                curr_max = 0;
                continue;
            }
            flag = true;
            curr_max += A.get(i);
            if (curr_max > max || (curr_max == max && i - current > end - start)) {
                max = curr_max;
                start = current;
                end = i;
            }
        }
        if (flag) {
            for (int i = start; i <= end; i++) {
                result.add(A.get(i));
            }
        }
        return result;
    }
}
