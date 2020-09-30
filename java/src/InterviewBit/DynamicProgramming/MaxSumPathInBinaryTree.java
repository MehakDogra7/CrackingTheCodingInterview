package InterviewBit.DynamicProgramming;

import InterviewBit.TreeDataStructure.TreeNode;

public class MaxSumPathInBinaryTree {

    int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(20);
        TreeNode e = new TreeNode(1);
        TreeNode f = new TreeNode(-25);
        TreeNode g = new TreeNode(3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        f.left = g;
        System.out.println(new MaxSumPathInBinaryTree().maxPathSum(a));
    }

    public int maxPathSum(TreeNode A) {
        traverse(A);
        return result;
    }

    private int traverse(TreeNode curr) {
        if (curr == null) return 0;

        int currVal = curr.val;
        int left = traverse(curr.left);
        int right = traverse(curr.right);

        int maxWithOneChild = max(currVal,
                left + currVal,
                right + currVal);

        result = max(result, maxWithOneChild, currVal + left + right);

        return maxWithOneChild;
    }

    public int max(int... values) {
        int maxValue = Integer.MIN_VALUE;
        for (int i : values) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }
}
