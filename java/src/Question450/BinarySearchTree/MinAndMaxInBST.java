package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

public class MinAndMaxInBST {

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

        System.out.println(new MinAndMaxInBST().minValue(a));
        System.out.println(new MinAndMaxInBST().maxValue(a));
    }

    public int minValue(Node node) {
        if (node == null) return -1;
        return node.left == null ? node.data : minValue(node.left);
    }

    public int maxValue(Node node) {
        if (node == null) return -1;
        return node.right == null ? node.data : minValue(node.right);
    }
}
