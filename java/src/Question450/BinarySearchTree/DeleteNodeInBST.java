package Question450.BinarySearchTree;

import InterviewBit.TreeDataStructure.TreeNode;

public class DeleteNodeInBST {

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

        System.out.println(new DeleteNodeInBST().deleteNode(a, 2).val);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = findMinVal(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int findMinVal(TreeNode curr) {
        return curr.left == null ? curr.val : findMinVal(curr.left);
    }
}
