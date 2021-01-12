package Question450.BinaryTrees;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfNotAdjacentNodes {

    int max = 0;
    Map<Node, Integer> dp;

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(new MaxSumOfNotAdjacentNodes().solve(a));
    }

    private int solve(Node curr) {

        dp = new HashMap<>();
        return calculate(curr);
    }

    private int calculate(Node curr) {
        if (curr == null) return 0;
        if (dp.containsKey(curr)) return dp.get(curr);

        int gcl = curr.left == null ? 0 : (calculate(curr.left.left) + calculate(curr.left.right));
        int gcr = curr.right == null ? 0 : (calculate(curr.right.left) + calculate(curr.right.right));

        int consider = curr.data + gcl + gcr;
        int dontConsider = calculate(curr.left) + calculate(curr.right);

        dp.put(curr, Math.max(consider, dontConsider));
        return dp.get(curr);
    }
}
