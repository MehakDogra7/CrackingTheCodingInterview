package InterviewBit.GraphDSAndAlgo;

import InterviewBit.TreeDataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrder {

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

        new LevelOrder().levelOrder(a).forEach(list -> {
            list.forEach(node -> System.out.print(node + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<QueueObject> queue = new ArrayDeque<>();
        QueueObject root = new QueueObject(A, 0);
        queue.add(root);
        ArrayList<Integer> temp = new ArrayList<>();
        int last = 0;

        while (!queue.isEmpty()) {
            QueueObject curr = queue.poll();
            if (curr.level != last) {
                ans.add(temp);
                temp = new ArrayList<>();
            }
            temp.add(curr.node.val);

            last = curr.level;
            if (curr.node.left != null) {
                queue.add(new QueueObject(curr.node.left, curr.level + 1));
            }
            if (curr.node.right != null) {
                queue.add(new QueueObject(curr.node.right, curr.level + 1));
            }
        }
        ans.add(temp);
        return ans;
    }

    static class QueueObject {
        TreeNode node;
        int level;

        public QueueObject(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
