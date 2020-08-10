package InterviewBit.TreeDataStructure;

public class SymmetricBinaryTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);


        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(new SymmetricBinaryTree().isSymmetric(a));
    }

    public int isSymmetric(TreeNode A) {
        if (A == null) return 1;
        return traversal(A.left, A.right);
    }

    private int traversal(TreeNode left, TreeNode right) {
        if (left == null && right == null) return 1;
        if (left == null || right == null) return 0;

        if (left.val == right.val)
            if (traversal(left.left, right.right) == 1) return traversal(left.right, right.left);

        return 0;
    }
}
