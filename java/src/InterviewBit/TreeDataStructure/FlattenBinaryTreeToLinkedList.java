package InterviewBit.TreeDataStructure;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    public static TreeNode head = null;
    public static TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(6);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        TreeNode node = new FlattenBinaryTreeToLinkedList().solve(a);
        new InOrderTraversal().solve(node).forEach(i -> System.out.print(i + " "));
    }

    private TreeNode solve(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            if (currNode.right != null) stack.push(currNode.right);
            if (currNode.left != null) stack.push(currNode.left);

            if (!stack.isEmpty()) currNode.right = stack.peek();
            currNode.left = null;
        }
        return A;
    }
}
