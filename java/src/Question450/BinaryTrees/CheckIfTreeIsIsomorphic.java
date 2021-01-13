package Question450.BinaryTrees;

public class CheckIfTreeIsIsomorphic {

    public static void main(String[] args) {

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        g.right = h;

        Node a1 = new Node(1);
        Node b1 = new Node(2);
        Node c1 = new Node(3);
        Node d1 = new Node(4);
        Node e1 = new Node(5);
        Node f1 = new Node(6);
        Node g1 = new Node(7);
        Node h1 = new Node(8);

        a1.left = c1;
        a1.right = b1;
        b1.left = d1;
        b1.right = e1;
        c1.left = f1;
        c1.right = g1;
        g1.right = h1;

        System.out.println(new CheckIfTreeIsIsomorphic().isIsomorphic(a, a1));
    }

    public boolean isIsomorphic(Node root1, Node root2) {
        // code here.
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        if (root1.data != root2.data) return false;

        boolean llrr = isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);
        boolean lrlr = isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);

        return llrr || lrlr;
    }
}
