package Question450.BinarySearchTree;

import InterviewBit.TreeDataStructure.TreeNode;

public class SearchInBST {

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

        System.out.println(new SearchInBST().searchBST(a, 2).val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}
