package InterviewBit.TreeDataStructure;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(new MaxDepthOfBinaryTree().maxDepth(a));
    }

    public int maxDepth(TreeNode A) {
        if (A == null) return 0;
        if (A.left == null && A.right == null) return 1;

        return Integer.max(maxDepth(A.left), maxDepth(A.right)) + 1;
    }
}
