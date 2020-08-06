package InterviewBit.TreeDataStructure;

public class RemoveHalfNodes {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        //TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        //TreeNode f = new TreeNode(6);

        a.left = b;
        //a.right = c;
        b.left = d;
        b.right = e;
        //c.right = f;

        new RemoveHalfNodes().printPreOrder(a);
        a = new RemoveHalfNodes().solve(a);
        System.out.println();
        new RemoveHalfNodes().printPreOrder(a);
    }

    public TreeNode solve(TreeNode A) {
        if (A == null) return null;

        while (isHalfNode(A)) {
            if (A.left != null) A = A.left;
            else A = A.right;
        }
        preOrderTraversal(A);

        return A;
    }

    private void preOrderTraversal(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return;

        if (isHalfNode(node.left)) {
            node.left = getGrandChild(node.left);
            preOrderTraversal(node);
        } else if (isHalfNode(node.right)) {
            node.right = getGrandChild(node.right);
            preOrderTraversal(node);
        }
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public boolean isHalfNode(TreeNode node) {
        return (node.left == null ^ node.right == null);
    }

    public TreeNode getGrandChild(TreeNode node) {
        return node.left != null ? node.left : node.right;
    }

    public void printPreOrder(TreeNode node) {
        if (node == null) return;

        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}
