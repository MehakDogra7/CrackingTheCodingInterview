package InterviewBit.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MAXSPPROD {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9));
        System.out.println(new MAXSPPROD().maxSpecialProduct(A));
    }

    public int maxSpecialProduct(ArrayList<Integer> A) {
        long prod = 0;
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            left[i] = getMax(A, leftStack, i);
        }

        for (int i = A.size() - 1; i >= 0; i--) {
            right[i] = getMax(A, rightStack, i);
        }

        for (int i = 0; i < A.size(); i++) {
            prod = Long.max(prod, (long) left[i] * (long) right[i]);
        }

        return (int) (prod % 1000000007);
    }

    //Store elements in strictly decreasing order in stack
    private int getMax(ArrayList<Integer> A, Stack<Integer> stack, Integer currIndex) {

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (A.get(pop) > A.get(currIndex)) {
                stack.push(pop);
                stack.push(currIndex);
                return pop;
            }
        }
        stack.push(currIndex);

        return 0;
    }
}
