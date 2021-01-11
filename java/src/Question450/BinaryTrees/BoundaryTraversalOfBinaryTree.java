package Question450.BinaryTrees;

import java.util.ArrayList;

public class BoundaryTraversalOfBinaryTree {
    ArrayList<Node> traversal;

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

        new BoundaryTraversalOfBinaryTree().printBoundary(a).forEach(i -> System.out.print(i + " "));
    }

    ArrayList<Integer> printBoundary(Node node) {
        traversal = new ArrayList<>();
        if (node == null) return new ArrayList<>();

        leftTraversal(node);
        leafTraversal(node);
        rightTraversal(node);

        ArrayList<Integer> res = new ArrayList<>();
        traversal.forEach(i -> res.add(i.data));

        if (res.size() > 1 && node == traversal.get(res.size() - 1)) res.remove(res.size() - 1);
        return res;
    }

    private void leafTraversal(Node curr) {
        if (curr == null) return;
        if (curr.left == null && curr.right == null) {
            if (curr != traversal.get(traversal.size() - 1)) traversal.add(curr);
            return;
        }
        leafTraversal(curr.left);
        leafTraversal(curr.right);
    }

    private void rightTraversal(Node curr) {
        if (curr == null) return;
        rightTraversal(curr.right);
        if (curr != traversal.get(traversal.size() - 1)) traversal.add(curr);
    }

    private void leftTraversal(Node curr) {
        if (curr == null) return;
        traversal.add(curr);
        leftTraversal(curr.left);
    }
}
