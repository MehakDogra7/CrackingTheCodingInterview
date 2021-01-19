package Question450.StacksAndQueues;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        long[] arr = {1, 3, 2, 4};
        long[] res = nextLargerElement(arr, arr.length);
        for (long re : res) {
            System.out.print(re + " ");
        }
    }

    public static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        long[] res = new long[n];
        Stack<Long> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            long curr = arr[i];
            while (!stack.isEmpty() && stack.peek() < curr) stack.pop();
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(curr);
        }
        return res;
    }
}
