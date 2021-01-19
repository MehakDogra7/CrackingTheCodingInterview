package Question450.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class OverlappingIntervals {

    public static void main(String[] args) {
        ArrayList<pair> vec = new ArrayList<>();
        vec.add(new pair(1, 3));
        vec.add(new pair(2, 4));
        vec.add(new pair(6, 8));
        vec.add(new pair(9, 10));

        vec = overlappedInterval(vec, vec.size());
        vec.forEach(pair -> System.out.println(pair.first + " " + pair.second));
    }

    public static ArrayList<pair> overlappedInterval(ArrayList<pair> vec, int n) {
        // code here
        vec.sort((pair1, pair2) -> {
                    int comp = Integer.compare(pair1.first, pair2.first);
                    return (comp == 0 ? Integer.compare(pair1.second, pair2.second) : comp);
                }
        );

        Stack<pair> stack = new Stack<>();
        for (pair p : vec) {
            if (stack.isEmpty()) stack.push(p);
            else {
                int start = p.first, end = p.second;
                while (!stack.isEmpty() && stack.peek().second >= p.first) {
                    pair pop = stack.pop();
                    start = Math.min(start, pop.first);
                    end = Math.max(end, pop.second);
                }
                stack.push(new pair(start, end));
            }
        }
        vec = new ArrayList<>();
        while (!stack.isEmpty()) {
            vec.add(stack.pop());
        }

        for (int i = 0, j = vec.size() - 1; i < j; i++, j--) {
            pair temp = vec.get(i);
            vec.set(i, vec.get(j));
            vec.set(j, temp);
        }
        return vec;
    }

    static class pair {
        int first;
        int second;

        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
