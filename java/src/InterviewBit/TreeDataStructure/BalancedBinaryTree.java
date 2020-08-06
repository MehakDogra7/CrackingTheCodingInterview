package InterviewBit.TreeDataStructure;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode x = new TreeNode(8);
        TreeNode y = new TreeNode(9);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = x;
        x.left = y;

        System.out.println(new BalancedBinaryTree().solve(a));
    }

    public int solve(TreeNode A) {
        if (A == null) return 1;
        return preOrderTraversal(A) == Integer.MIN_VALUE ? 0 : 1;
    }

    private int preOrderTraversal(TreeNode node) {
        if (node == null) return 0;

        int left = node.left == null ? 0 : preOrderTraversal(node.left);
        int right = node.right == null ? 0 : preOrderTraversal(node.right);

        if (left == Integer.MIN_VALUE || right == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (Math.abs(left - right) > 1) return Integer.MIN_VALUE;

        return Integer.max(left, right) + 1;
    }
}
