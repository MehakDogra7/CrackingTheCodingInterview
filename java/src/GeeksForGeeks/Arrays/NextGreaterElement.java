package MustDo.Arrays;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(1, 4, 3, 2, 10, 9));

        nextGreaterElement(A);
    }

    private static void nextGreaterElement(ArrayList<Integer> A) {

        Map<Integer, Integer> right = new LinkedHashMap<>();

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
            right.put(pop, -1);
        }

        right.forEach((k, v) -> System.out.println(k + " : " + v + " :: " + A.get(k) + " : " + (v != -1 ? A.get(v) : -1)));
    }
}
