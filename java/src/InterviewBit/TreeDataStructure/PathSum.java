package InterviewBit.TreeDataStructure;

public class PathSum {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1000);
        TreeNode b = new TreeNode(2000);
        TreeNode c = new TreeNode(-3001);

        a.left = b;
        b.left = c;

        System.out.println(new PathSum().hasPathSum(a, -1));
    }

    public int hasPathSum(TreeNode A, int B) {
        if (A == null) return 0;
        if (A.left == null && A.right == null) {
            if (A.val == B) return 1;
            else return 0;
        }

        int l = hasPathSum(A.left, B - A.val);
        if (l == 1) return 1;
        return hasPathSum(A.right, B - A.val);
    }
}
