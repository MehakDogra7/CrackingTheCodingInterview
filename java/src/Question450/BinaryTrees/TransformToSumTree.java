package Question450.BinaryTrees;

public class TransformToSumTree {

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

        new TransformToSumTree().toSumTree(a);

    }

    public void toSumTree(Node root) {
        //add code here.
        if (root == null) return;
        solve(root);
    }

    private int solve(Node curr) {
        if (curr == null) return 0;
        if (curr.left == null && curr.right == null) {
            int temp = curr.data;
            curr.data = 0;
            return temp;
        }

        int left = solve(curr.left);
        int right = solve(curr.right);
        int temp = curr.data;
        curr.data = left + right +
                (curr.left == null ? 0 : curr.left.data) +
                (curr.right == null ? 0 : curr.right.data);

        return temp;
    }
}
