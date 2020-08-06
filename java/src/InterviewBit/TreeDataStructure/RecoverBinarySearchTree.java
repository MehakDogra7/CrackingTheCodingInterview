package InterviewBit.TreeDataStructure;

import java.util.ArrayList;

public class RecoverBinarySearchTree {

    public ArrayList<Integer> result = new ArrayList<>();
    public TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        a.left = b;
        a.right = c;

        new RecoverBinarySearchTree().recoverTree(a).forEach(System.out::println);
    }

    public ArrayList<Integer> recoverTree(TreeNode A) {
        prev = null;
        result.clear();
        result.add(-1);
        result.add(-1);

        inOrder(A);
        return result;
    }

    public void inOrder(TreeNode curr) {
        if (curr == null) return;

        inOrder(curr.left);
        if (prev != null && curr.val < prev.val) {
            if (result.get(1) == -1) result.set(1, prev.val);
            result.set(0, curr.val);
        }
        prev = curr;
        inOrder(curr.right);
    }
}
