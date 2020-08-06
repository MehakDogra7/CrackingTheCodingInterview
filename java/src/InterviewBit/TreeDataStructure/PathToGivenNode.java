package InterviewBit.TreeDataStructure;

import java.util.ArrayList;

public class PathToGivenNode {

    public ArrayList<Integer> result;

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

        new PathToGivenNode().solve(a, 5).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        result = new ArrayList<>();
        preOrderTraversal(A, B);
        return result;
    }

    public boolean preOrderTraversal(TreeNode A, int B) {
        if (A == null) return false;
        result.add(A.val);

        if (A.val == B || preOrderTraversal(A.left, B) || preOrderTraversal(A.right, B)) return true;
        result.remove(result.size() - 1);
        return false;
    }
}
