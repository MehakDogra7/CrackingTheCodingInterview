package InterviewBit.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(4, 5, 2, 10));
        new NextGreaterElement().nextGreater(A).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = A.size() - 1; i >= 0; i--) result.add(0, getMax(stack, A.get(i)));
        return result;
    }

    private Integer getMax(Stack<Integer> stack, Integer curr) {
        while (!stack.isEmpty()) {
            if (curr < stack.peek()) {
                int temp = stack.peek();
                stack.push(curr);
                return temp;
            }
            stack.pop();
        }
        stack.push(curr);
        return -1;
    }
}
