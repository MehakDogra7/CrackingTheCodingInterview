package InterviewBit.TreeDataStructure;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        stack.clear();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        BSTIterator i = new BSTIterator(a);
        while (i.hasNext())
            System.out.print(i.next());
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (stack.isEmpty()) return -1;

        TreeNode node = stack.pop();
        int val = node.val;

        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return val;
    }
}
