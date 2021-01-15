package Question450.BinarySearchTree;

import InterviewBit.TreeDataStructure.TreeNode;

public class InsertIntoBST {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(new InsertIntoBST().insertIntoBST(a, 2).val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val < val) root.right = insertIntoBST(root.right, val);
        else root.left = insertIntoBST(root.left, val);

        return root;
    }
}
