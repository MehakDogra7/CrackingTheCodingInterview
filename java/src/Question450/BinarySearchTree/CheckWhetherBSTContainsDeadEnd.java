package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

public class CheckWhetherBSTContainsDeadEnd {

    public static void main(String[] args) {
        Node a = new Node(8);
        Node b = new Node(5);
        Node c = new Node(9);
        Node d = new Node(2);
        Node e = new Node(7);
        Node f = new Node(1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.left = f;

        System.out.println(isDeadEnd(a));
    }

    public static boolean isDeadEnd(Node root) {
        //Add your code here.
        return check(root, 0, Integer.MAX_VALUE);
    }

    private static boolean check(Node curr, int min, int max) {
        if (curr == null) return false;

        if (curr.left == null && curr.right == null) {
            if ((min + 1 == curr.data) && (curr.data + 1) == max) return true;
            return false;
        }
        return check(curr.left, min, curr.data) || check(curr.right, curr.data, max);
    }
}
