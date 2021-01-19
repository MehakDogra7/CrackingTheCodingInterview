package Question450.StacksAndQueues;

import java.util.Stack;

public class SortAStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(11);
        s.push(2);
        s.push(32);
        s.push(3);
        s.push(41);
        Stack<Integer> res = new SortAStack().sort(s);
        while (!res.isEmpty()) System.out.print(res.pop() + " ");
    }

    public Stack<Integer> sortUsingStack(Stack<Integer> s) {
        //add code here.
        Stack<Integer> res = new Stack<>();
        while (!s.isEmpty()) {
            int curr = s.pop();
            while (!res.isEmpty() && res.peek() > curr) s.push(res.pop());
            res.push(curr);
        }

        return res;
    }

    //Using Recursion
    public Stack<Integer> sort(Stack<Integer> s) {
        //add code here.
        if (s.isEmpty() || s.size() == 1) return s;
        int curr = s.pop();
        sort(s);
        insertSorted(s, curr);
        return s;
    }

    private void insertSorted(Stack<Integer> s, int curr) {
        if (s.isEmpty() || s.peek() <= curr) s.push(curr);
        else {
            int pop = s.pop();
            insertSorted(s, curr);
            s.push(pop);
        }
    }
}
