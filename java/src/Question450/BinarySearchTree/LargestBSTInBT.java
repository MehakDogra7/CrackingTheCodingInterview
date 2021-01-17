package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

public class LargestBSTInBT {

    static int max;

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(2);
        Node f = new Node(2);
        Node g = new Node(3);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;

        System.out.println(largestBst(a));
    }

    public static int largestBst(Node root) {
        // Write your code here
        max = 1;
        solve(root);
        return max;
    }

    private static Trace solve(Node curr) {
        if (curr == null) return new Trace(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        if (curr.left == null && curr.right == null) {
            return new Trace(curr.data, curr.data, 1);
        }

        Trace left = solve(curr.left);
        Trace right = solve(curr.right);
        if (left == null || right == null) return null;
        if (curr.data <= left.max || curr.data >= right.min) return null;

        max = Math.max(max, left.size + right.size + 1);
        return new Trace(Math.min(curr.data, left.min), Math.max(curr.data, right.max),
                left.size + right.size + 1);
    }

    static class Trace {
        int min, max, size;

        public Trace(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
}
