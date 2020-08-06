package InterviewBit.TreeDataStructure;

public class TwoSumBinaryTree {
    public static TreeNode head = null;
    public static TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode a = new TreeNode(-1);
        TreeNode b = new TreeNode(-1);
        TreeNode c = new TreeNode(-1);
        TreeNode d = new TreeNode(5);

        TreeNode e = new TreeNode(14);
        TreeNode f = new TreeNode(15);

        a.right = b;
        b.right = c;
        c.right = d;
        d.right = e;
        e.right = f;

        System.out.println(new TwoSumBinaryTree().t2Sum(a, 14));
    }

    public int t2Sum(TreeNode A, int B) {
        if (A == null) return 0;
        head = null;
        prev = null;

        convertToDoublyLinkedList(A);
        TreeNode p1 = head;
        TreeNode p2 = prev;

        while (p1.val < p2.val) {
            if (p1.val + p2.val < B) p1 = p1.right;
            else if (p1.val + p2.val == B) return 1;
            else p2 = p2.left;
        }

        return 0;
    }

    private void convertToDoublyLinkedList(TreeNode A) {
        if (A == null) return;
        if (A.left == null && head == null) head = A;

        convertToDoublyLinkedList(A.left);
        A.left = prev;
        if (prev != null) prev.right = A;
        prev = A;
        convertToDoublyLinkedList(A.right);
    }
}
