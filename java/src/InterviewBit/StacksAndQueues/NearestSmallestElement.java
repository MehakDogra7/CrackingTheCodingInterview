package InterviewBit.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallestElement {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(6, 2, 5, 4, 5, 1, 6));
        int[] nsl = new NearestSmallestElement().computeNSL(A);
        for (int i : nsl) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] nsr = new NearestSmallestElement().computeNSR(A);
        for (int i : nsr) {
            System.out.print(i + " ");
        }
    }

    public int[] computeNSL(ArrayList<Integer> A) {
        int[] nsl = new int[A.size()];
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsl[i] = 0;
            } else {
                nsl[i] = stack.peek() + 1;

            }
            stack.push(i);
        }
        return nsl;
    }

    public int[] computeNSR(ArrayList<Integer> A) {
        int[] nsr = new int[A.size()];
        int n = A.size();

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i > -1; i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsr[i] = n - 1;
            } else {
                nsr[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        return nsr;
    }
}
