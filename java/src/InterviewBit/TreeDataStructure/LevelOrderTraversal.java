package InterviewBit.TreeDataStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderTraversal {

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

        new LevelOrderTraversal().solve(a).forEach(i -> System.out.print(i + " "));
    }

    private ArrayList<Integer> solve(TreeNode A) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curr = A;
        queue.add(curr);
        while (curr != null) {
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
            result.add(curr.val);
            queue.poll();
            curr = queue.peek();
        }

        return result;
    }
}
