package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Stack;

public class MAXSPPROD {

    public static void main(String[] args) {

        MAXSPPROD maxspprod = new MAXSPPROD();

        ArrayList<Integer> A = new ArrayList<>(List.of(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9));

        System.out.println(maxSpecialProduct(A));
        System.out.println(maxspprod.maxSpecialProductOptimal(A));
    }

    public static int maxSpecialProduct(ArrayList<Integer> A) {

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            int maxIndex = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (A.get(j) > A.get(i)) {
                    maxIndex = j;
                    break;
                }
            }
            left.add(maxIndex);
        }

        for (int i = 0; i < A.size(); i++) {
            int minIndex = 0;
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(j) > A.get(i)) {
                    minIndex = j;
                    break;
                }
            }
            right.add(minIndex);
        }

        int max = 0;
        for (int i = 0; i < left.size(); i++) {
            max = Math.max(max, left.get(i) * right.get(i));
        }

        return max;
    }

    private int maxSpecialProductOptimal(ArrayList<Integer> A) {
        LinkedHashMap<Integer, Integer> right = getMapForRightSpecialValue(A);
        LinkedHashMap<Integer, Integer> left = getMapForLeftSpecialValue(A);

        long max = 0;
        for (int i = 0; i < left.size(); i++) {
            max = Math.max(max, (long) left.get(i) * (long) right.get(i));
        }

        return (int) (max % 1000000007);
    }

    private LinkedHashMap<Integer, Integer> getMapForLeftSpecialValue(ArrayList<Integer> A) {

        LinkedHashMap<Integer, Integer> left = new LinkedHashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(A.size() - 1);

        for (int i = A.size() - 2; i >= 0; i--) {
            int prev = i;
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                int compare = Integer.compare(A.get(pop), A.get(prev));
                if (compare == -1) {
                    left.put(pop, prev);
                } else {
                    stack.push(pop);
                    break;
                }
            }
            stack.push(prev);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            left.put(pop, 0);
        }
        return left;
    }

    private LinkedHashMap<Integer, Integer> getMapForRightSpecialValue(ArrayList<Integer> A) {

        LinkedHashMap<Integer, Integer> right = new LinkedHashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < A.size(); i++) {
            int next = i;
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                int compare = Integer.compare(A.get(pop), A.get(next));
                if (compare == -1)
                    right.put(pop, next);
                else {
                    stack.push(pop);
                    break;
                }
            }
            stack.push(next);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            right.put(pop, 0);
        }

        return right;
    }


}
