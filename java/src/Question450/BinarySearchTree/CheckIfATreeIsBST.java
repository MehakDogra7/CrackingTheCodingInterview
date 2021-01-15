package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

public class CheckIfATreeIsBST {

    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(2);
        Node c = new Node(7);
        Node d = new Node(1);
        Node e = new Node(3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(new CheckIfATreeIsBST().isBST(a));
    }

    boolean isBST(Node root) {
        // code here.
        return check(root.left, Integer.MIN_VALUE, root.data) && check(root.right, root.data, Integer.MAX_VALUE);
    }

    private boolean check(Node curr, int min, int max) {
        if (curr == null) return true;

        else if (curr.data < min || curr.data > max
                || curr.data == min || curr.data == max) return false;
        return check(curr.left, min, curr.data) && check(curr.right, curr.data, max);
    }
}
