package InterviewBit.TreeDataStructure;

public class InvertTheBinaryTree {

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
        new PreOrderTraversal().solve(a).forEach(i -> System.out.print(i + " "));
        System.out.println();
        TreeNode treeNode = new InvertTheBinaryTree().invertTree(a);
        new PreOrderTraversal().solve(treeNode).forEach(i -> System.out.print(i + " "));
    }

    public TreeNode invertTree(TreeNode A) {
        if (A == null) return A;

        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;

        invertTree(A.left);
        invertTree(A.right);
        return A;
    }
}
