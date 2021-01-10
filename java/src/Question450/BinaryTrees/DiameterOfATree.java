package Question450.BinaryTrees;

public class DiameterOfATree {

    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        a.left = b;
        a.right = c;

        System.out.println(new DiameterOfATree().diameter(a));
    }

    int diameter(Node root) {
        // Your code here
        if (root == null) return 0;
        max = Integer.MIN_VALUE;
        solve(root);
        return max;
    }

    private int solve(Node root) {
        if (root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);
        max = Math.max(max, left + right + 1);
        return 1 + Math.max(left, right);
    }
}
