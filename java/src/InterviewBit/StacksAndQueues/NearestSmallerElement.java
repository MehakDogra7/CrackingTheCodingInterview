package InterviewBit.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerElement {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(4, 5, 2, 10, 8));

        new NearestSmallerElement().prevSmaller(A).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        Stack<Integer> left = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            result.add(getMin(left, A.get(i)));
        }

        return result;
    }

    //Store elements in strictly increasing order in stack
    private Integer getMin(Stack<Integer> stack, Integer curr) {
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (pop < curr) {
                stack.push(pop);
                stack.push(curr);
                return pop;
            }
        }
        stack.push(curr);
        return -1;
    }
}
