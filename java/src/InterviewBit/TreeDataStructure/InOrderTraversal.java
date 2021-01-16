package InterviewBit.TreeDataStructure;

import java.util.ArrayList;
import java.util.Stack;

/**
 * push current
 * move to left
 * if left is null pop and add its value
 * move to right of pop
 * if right is null pop another and add its value
 */
public class InOrderTraversal {

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

        new InOrderTraversal().solve(a).forEach(i -> System.out.print(i + " "));
        System.out.println();
        new InOrderTraversal().inorderTraversalUsingMorrisTraversal(a).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = A;
        stack.push(root);
        root = root.left;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                root = pop.right;
            }
        }
        return result;
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param A
     * @return
     */
    public ArrayList<Integer> inorderTraversalUsingMorrisTraversal(TreeNode A) {
        if (A == null) return new ArrayList<>();

        ArrayList<Integer> res = new ArrayList<>();
        TreeNode current = A, prev;
        while (current != null) {
            if (current.left == null) {
                res.add(current.val);
                current = current.right;
            } else {
                prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    res.add(current.val);
                    current = current.right;
                }
            }
        }
        return res;
    }


}
