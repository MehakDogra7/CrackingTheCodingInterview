package InterviewBit.TreeDataStructure;

public class ValidBinarySearchTree {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(new ValidBinarySearchTree().isValidBST(a));
    }

    public int isValidBST(TreeNode A) {
        return solve(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean solve(TreeNode curr, int currMin, int currMax) {
        if (curr == null) return true;

        if (curr.val < currMin || curr.val > currMax) return false;

        return solve(curr.left, currMin, curr.val - 1) &&
                solve(curr.right, curr.val + 1, currMax);
    }
}
