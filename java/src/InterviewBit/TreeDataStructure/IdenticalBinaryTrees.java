package InterviewBit.TreeDataStructure;

public class IdenticalBinaryTrees {

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

        TreeNode a1 = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode c1 = new TreeNode(3);
        TreeNode d1 = new TreeNode(4);
        TreeNode e1 = new TreeNode(5);
        TreeNode f1 = new TreeNode(6);
        TreeNode g1 = new TreeNode(7);

        a1.left = b1;
        a1.right = c1;
        b1.left = d1;
        b1.right = e1;
        c1.left = f1;
        c1.right = g1;


        System.out.println(new IdenticalBinaryTrees().isSameTree(a, a1));
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) return 1;
        if (A == null || B == null) return 0;

        if (A.val == B.val) {
            if (isSameTree(A.left, B.left) == 1) return isSameTree(A.right, B.right);
        }
        return 0;
    }
}
