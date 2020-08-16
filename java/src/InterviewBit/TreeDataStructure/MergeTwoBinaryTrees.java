package InterviewBit.TreeDataStructure;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {

        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.left = d;

        TreeNode a1 = new TreeNode(3);
        TreeNode b1 = new TreeNode(6);
        TreeNode c1 = new TreeNode(1);
        TreeNode d1 = new TreeNode(2);
        TreeNode e1 = new TreeNode(7);

        a1.left = b1;
        a1.right = c1;
        b1.right = d1;
        c1.right = e1;

        TreeNode node = new MergeTwoBinaryTrees().solve(a, a1);
        node.preOrderTraversal();

    }

    private TreeNode solve(TreeNode A, TreeNode B) {
        if (A == null) return B;
        if (B == null) return A;

        A.val = A.val + B.val;
        A.left = solve(A.left, B.left);
        A.right = solve(A.right, B.right);
        return A;
    }
}
