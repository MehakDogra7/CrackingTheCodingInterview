package InterviewBit.GraphDSAndAlgo;

import java.util.ArrayList;

public class ConvertSortedListToBST {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;
        TreeNode root = new ConvertSortedListToBST().sortedListToBST(a);
    }

    public TreeNode sortedListToBST(ListNode a) {
        ArrayList<Integer> A = new ArrayList<>();
        ListNode temp = a;
        while (temp != null) {
            A.add(temp.val);
            temp = temp.next;
        }

        return convertToBST(A, 0, A.size() - 1);
    }

    private TreeNode convertToBST(ArrayList<Integer> A, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode curr = new TreeNode(A.get(mid));
        curr.left = convertToBST(A, start, mid - 1);
        curr.right = convertToBST(A, mid + 1, end);

        return curr;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
