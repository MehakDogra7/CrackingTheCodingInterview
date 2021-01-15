package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

public class LCAInBST {
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

        System.out.println(new LCAInBST().LCA(a, 3, 7).data);
    }

    public Node LCA(Node root, int n1, int n2) {
        // code here.
        if (root == null) return null;
        if (root.data < n1 && root.data < n2) {
            return LCA(root.right, n1, n2);
        } else if (root.data > n1 && root.data > n2) {
            return LCA(root.left, n1, n2);
        }
        return root;
    }
}
