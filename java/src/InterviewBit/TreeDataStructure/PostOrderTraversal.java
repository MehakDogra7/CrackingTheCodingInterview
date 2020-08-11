package InterviewBit.TreeDataStructure;

import java.util.ArrayList;
import java.util.Stack;

/**
 * push current
 * move left i.e. curr = curr.left
 * if left is null
 * check if right of tos is visited or not
 * if right is null simply print that value
 * else compare the right of tos with last popped node -- if matched then visited else make curr = right and follow same steps
 */
public class PostOrderTraversal {

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

        new PostOrderTraversal().solve(a).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode lastPoppedNode = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = A;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.peek().right == null) {
                    lastPoppedNode = stack.pop();
                    result.add(lastPoppedNode.val);
                } else {
                    if (lastPoppedNode != stack.peek().right) {
                        curr = stack.peek().right;
                    } else {
                        lastPoppedNode = stack.pop();
                        result.add(lastPoppedNode.val);
                    }
                }
            }
        }
        return result;
    }
}
