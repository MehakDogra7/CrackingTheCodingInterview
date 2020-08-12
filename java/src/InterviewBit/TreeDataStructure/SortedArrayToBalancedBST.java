package InterviewBit.TreeDataStructure;

import java.util.ArrayList;
import java.util.List;

public class SortedArrayToBalancedBST {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3, 4));
        TreeNode root = new SortedArrayToBalancedBST().sortedArrayToBST(A);
        new PreOrderTraversal().solve(root).forEach(i -> System.out.print(i + " "));
    }

    public TreeNode sortedArrayToBST(final List<Integer> A) {
        if (A.size() == 0) return null;
        if (A.size() == 1) return new TreeNode(A.get(0));
        return insertIntoTree(A, 0, A.size() - 1);
    }

    public TreeNode insertIntoTree(List<Integer> A, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(A.get(mid));
        root.left = insertIntoTree(A, start, mid - 1);
        root.right = insertIntoTree(A, mid + 1, end);
        return root;
    }

}
