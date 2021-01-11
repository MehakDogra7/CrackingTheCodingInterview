package Question450.BinaryTrees;

import java.util.Stack;

public class MaxAndMinHeightOfBinaryTree {

    public int minDepthRecursive(Node root) {
        if (root == null) return 0;

        if (root.left == null || root.right == null) {
            return 1 + minDepthRecursive(root.left) + minDepthRecursive(root.right);
        }
        return 1 + Math.min(minDepthRecursive(root.left), minDepthRecursive(root.right));
    }

    public int maxDepthIterative(Node root) {
        if (root == null) return 0;
        Stack<Node> stack = new Stack<>();
        Node curr = root, lastPoppedNode = null;
        int maxHeight = 0;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.peek().right != null && stack.peek().right != lastPoppedNode) {
                    curr = stack.peek().right;
                } else {
                    lastPoppedNode = stack.pop();
                }
            }
            maxHeight = Math.max(maxHeight, stack.size());
        }

        return maxHeight;
    }

    public int minDepthIterative(Node root) {
        if (root == null) return 0;
        Stack<Node> stack = new Stack<>();
        Node curr = root, lastPoppedNode = null;
        int minHeight = Integer.MAX_VALUE;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.peek().right != null && stack.peek().right != lastPoppedNode) {
                    curr = stack.peek().right;
                } else {
                    if (stack.peek().left == null && stack.peek().right == null) {
                        minHeight = Math.min(minHeight, stack.size());
                    }
                    lastPoppedNode = stack.pop();
                }
            }
        }

        return minHeight;
    }
}
