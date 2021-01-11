package Question450.BinaryTrees;

public class CheckForHeightBalanceTree {

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

        System.out.println(new CheckForHeightBalanceTree().isBalanced(a));
    }

    boolean isBalanced(Node root) {
        // Your code here
        int height = check(root);
        return height != Integer.MAX_VALUE;
    }

    private int check(Node curr) {
        if (curr == null) return 0;

        int l = check(curr.left);
        int r = check(curr.right);

        if (l == Integer.MAX_VALUE || r == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (Math.abs(l - r) > 1) return Integer.MAX_VALUE;
        return 1 + Math.max(l, r);
    }
}
