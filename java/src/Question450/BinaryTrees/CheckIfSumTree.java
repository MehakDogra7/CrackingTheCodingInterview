package Question450.BinaryTrees;

public class CheckIfSumTree {

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

        System.out.println(new CheckIfSumTree().isSumTree(a));
    }

    boolean isSumTree(Node root) {
        // Your code here
        return check(root) != Integer.MAX_VALUE;
    }

    private int check(Node curr) {
        if (curr == null) return 0;
        if (curr.left == null && curr.right == null) return curr.data;

        int l = check(curr.left);
        int r = check(curr.right);

        if (l == Integer.MAX_VALUE || r == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if ((l + r) != curr.data) return Integer.MAX_VALUE;

        return curr.data + l + r;
    }
}
