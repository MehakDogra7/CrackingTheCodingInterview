package InterviewBit.TreeDataStructure;

import java.util.ArrayList;

public class ConstructBalancedBinarySearchTree {

    public static void main(String[] args) {
        int[] A = {21, 26, 30, 9, 4, 14, 28, 18, 15, 10, 2, 3, 7};
        TreeNode root = new ConstructBalancedBinarySearchTree().solve(A);
        new PreOrderTraversal().solve(root).forEach(i -> System.out.print(i + " "));
    }

    private TreeNode solve(int[] A) {
        TreeNode root = null;
        for (int i = 0; i < A.length; i++) {
            root = insertIntoTree(root, A[i], new ArrayList<>());
        }

        return root;
    }

    private TreeNode insertIntoTree(TreeNode root, Integer value, ArrayList<Character> list) {
        if (root == null) return new TreeNode(value);
        if (value < root.val) {
            root.left = insertIntoTree(root.left, value, list);
            list.add('L');
        } else if (value > root.val) {
            root.right = insertIntoTree(root.right, value, list);
            list.add('R');
        }
        boolean isImbalance = findBalanceStatus(root);
        if (isImbalance) {
            String imbalance = String.valueOf(list.get(list.size() - 1)) + String.valueOf(list.get(list.size() - 2));
            if (imbalance.equals("RL")) return handleRLImBalancing(root);
            else if (imbalance.equals("RR")) return handleRRImBalancing(root);
            else if (imbalance.equals("LR")) return handleLRImBalancing(root);
            else if (imbalance.equals("LL")) return handleLLImBalancing(root);
        }
        return root;
    }

    private TreeNode handleLLImBalancing(TreeNode root) {
        TreeNode left1 = root.left;
        TreeNode temp = left1.right;
        left1.right = root;
        root.left = temp;
        return left1;
    }

    private TreeNode handleLRImBalancing(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = left.right;
        TreeNode temp = right.left;
        TreeNode temp1 = right.right;
        right.right = root;
        right.left = left;
        root.left = temp1;
        left.right = temp;
        return right;
    }

    private TreeNode handleRRImBalancing(TreeNode root) {
        TreeNode right1 = root.right;
        TreeNode temp = right1.left;
        right1.left = root;
        root.right = temp;
        return right1;
    }

    private TreeNode handleRLImBalancing(TreeNode root) {
        TreeNode right = root.right;
        TreeNode left = right.left;
        TreeNode temp = left.left;
        TreeNode temp2 = left.right;
        left.left = root;
        left.right = right;
        root.right = temp;
        right.left = temp2;
        return left;
    }

    private boolean findBalanceStatus(TreeNode root) {
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return (Math.abs(leftHeight - rightHeight) > 1);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return Integer.max(height(node.left), height(node.right)) + 1;
    }
}
