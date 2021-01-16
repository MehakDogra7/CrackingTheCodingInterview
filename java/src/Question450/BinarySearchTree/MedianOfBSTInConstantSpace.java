package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

public class MedianOfBSTInConstantSpace {

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(7);
        Node d = new Node(2);
        Node e = new Node(4);
        Node f = new Node(6);
        Node g = new Node(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        //c.right = g;

        System.out.println(new MedianOfBSTInConstantSpace().solve(a));
    }

    private double solve(Node root) {
        int size = 0;
        Node curr = root, prev;
        while (curr != null) {
            if (curr.left == null) {
                size++;
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    size++;
                    curr = curr.right;
                }
            }
        }

        if (size % 2 == 0) {
            int nBy2 = getKthSmallestNode(root, size / 2);
            int nPlus1By2 = getKthSmallestNode(root, size / 2 + 1);
            return (nBy2 + nPlus1By2) / 2.0;
        } else {
            return getKthSmallestNode(root, (size + 1) / 2);
        }
    }

    private int getKthSmallestNode(Node root, int k) {
        Node curr = root, prev;
        int ans = -1;
        while (curr != null) {
            if (curr.left == null) {
                k--;
                if (k == 0) ans = curr.data;
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    k--;
                    if (k == 0) ans = curr.data;
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}
