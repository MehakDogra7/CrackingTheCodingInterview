package InterviewBit.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Really tough question
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(90, 58, 69, 70, 82, 100, 13, 57, 47, 18));
        System.out.println(new LargestRectangleInHistogram().solveBruteForce(A));
        System.out.println(new LargestRectangleInHistogram().solveOptimal(A));
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(A));
    }

    private int solveBruteForce(ArrayList<Integer> A) {
        int res = 1;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i; j < A.size(); j++) {
                int curr = (j - i + 1) * getMinOfSubArray(A, i, j);
                res = Integer.max(res, curr);
            }
        }
        return res;
    }

    private int getMinOfSubArray(ArrayList<Integer> A, int i, int j) {

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            min = Integer.min(min, A.get(k));
        }
        return min;
    }

    //Use stack and it will contain elements in increasing order
    private int solveOptimal(ArrayList<Integer> A) {
        if (A.size() == 0)
            return 0;
        if (A.size() == 1) {
            return A.get(0);
        }

        int res = 0;
        Stack<Integer> barsStack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            int curr = A.get(i);
            if (!barsStack.isEmpty() && curr >= A.get(barsStack.peek())) {
                barsStack.push(i);
            } else {
                while (!barsStack.isEmpty() && curr < A.get(barsStack.peek())) {
                    int topOfStack = A.get(barsStack.pop());
                    if (barsStack.isEmpty()) {
                        res = Integer.max(res, topOfStack * i);
                    } else {
                        res = Integer.max(res, topOfStack * (i - barsStack.peek() - 1));
                    }
                }
                barsStack.push(i);
            }
        }

        while (!barsStack.isEmpty()) {
            int i = A.size();
            int topOfStack = A.get(barsStack.pop());
            if (barsStack.isEmpty()) {
                res = Integer.max(res, topOfStack * i);
            } else {
                res = Integer.max(res, topOfStack * (i - barsStack.peek() - 1));
            }
        }
        return res;
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        if (A.size() == 0)
            return 0;
        if (A.size() == 1) {
            return A.get(0);
        }


        int[] nsl = computeNSL(A);
        int[] nsr = computeNSR(A);


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max((nsr[i] - nsl[i] + 1) * A.get(i), max);
        }
        return max;
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
