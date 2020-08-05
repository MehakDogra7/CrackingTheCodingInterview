package InterviewBit.TreeDataStructure;

import java.util.ArrayList;

public class KthSmallestElementInTree {

    public static ArrayList<Integer> inOrder = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);

        a.left = b;
        a.right = c;

        System.out.println(new KthSmallestElementInTree().kthsmallest(a, 2));
    }

    public int kthsmallest(TreeNode A, int B) {
        inOrder.clear();
        inOrderTraversal(A);
        return inOrder.get(B - 1);
    }

    private void inOrderTraversal(TreeNode a) {

        if (a == null) return;
        inOrderTraversal(a.left);
        inOrder.add(a.val);
        inOrderTraversal(a.right);
    }
}
