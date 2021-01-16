package Question450.BinarySearchTree;

import InterviewBit.TreeDataStructure.InOrderTraversal;
import InterviewBit.TreeDataStructure.PreOrderTraversal;
import InterviewBit.TreeDataStructure.TreeNode;

public class MergeTwoBBST {

    TreeNode head, prev, mergedHead;

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        TreeNode a1 = new TreeNode(7);
        TreeNode b1 = new TreeNode(1);
        TreeNode c1 = new TreeNode(9);
        TreeNode d1 = new TreeNode(5);
        TreeNode e1 = new TreeNode(8);
        TreeNode f1 = new TreeNode(10);

        a1.left = b1;
        a1.right = c1;
        b1.right = d1;
        c1.left = e1;
        c1.right = f1;

        TreeNode mergedRoot = new MergeTwoBBST().merge(a, a1);
        new PreOrderTraversal().solve(mergedRoot).forEach(i -> System.out.print(i + " "));
        System.out.println();
        new InOrderTraversal().solve(mergedRoot).forEach(i -> System.out.print(i + " "));
    }

    private TreeNode merge(TreeNode root1, TreeNode root2) {

        TreeNode head1, head2;

        head = prev = null;
        convertBBSTToDLL(root1);
        head1 = head;

        head = prev = null;
        convertBBSTToDLL(root2);
        head2 = head;

        TreeNode start = new TreeNode(Integer.MAX_VALUE), prev = start, temp1 = head1, temp2 = head2;
        int totalNumberOfNodes = 0;

        while (temp1 != null || temp2 != null) {
            if (temp2 == null || (temp1 != null && temp1.val < temp2.val)) {
                prev.right = temp1;
                temp1.left = prev;
                prev = temp1;
                temp1 = temp1.right;
            } else {
                prev.right = temp2;
                temp2.left = prev;
                prev = temp2;
                temp2 = temp2.right;
            }
            totalNumberOfNodes++;
        }

        start.right.left = null;
        mergedHead = start.right;
        return convertDLLToBBST(totalNumberOfNodes);
    }

    private TreeNode convertDLLToBBST(int n) {
        if (n <= 0) return null;
        TreeNode left = convertDLLToBBST(n / 2);

        TreeNode curr = head;
        curr.left = left;
        head = head.right;

        curr.right = convertDLLToBBST(n - (n / 2) - 1);

        return curr;
    }

    private void convertBBSTToDLL(TreeNode curr) {
        if (curr == null) return;
        convertBBSTToDLL(curr.left);
        if (curr.left == null && head == null) head = curr;
        curr.left = prev;
        if (prev != null) prev.right = curr;
        prev = curr;
        convertBBSTToDLL(curr.right);
    }
}
