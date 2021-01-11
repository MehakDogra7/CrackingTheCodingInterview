package Question450.BinaryTrees;

import InterviewBit.TreeDataStructure.TreeNode;

import java.util.*;

public class TopViewOfBinaryTree {

    Map<Integer, Integer> map;

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;

        b.right = d;
        d.right = e;

        new TopViewOfBinaryTree().solve(a).forEach(i -> System.out.print(i + " "));
    }

    private ArrayList<Integer> solve(TreeNode a) {
        ArrayList<Integer> res = new ArrayList<>();
        if (a == null) return res;

        map = new TreeMap<>();
        Queue<QueueObject> queue = new ArrayDeque<>();
        queue.add(new QueueObject(a, 0));

        while (!queue.isEmpty()) {
            QueueObject curr = queue.poll();
            if (!map.containsKey(curr.num)) map.put(curr.num, curr.node.val);

            if (curr.node.left != null) queue.add(new QueueObject(curr.node.left, curr.num - 1));
            if (curr.node.right != null) queue.add(new QueueObject(curr.node.right, curr.num + 1));
        }

        res = new ArrayList<>(map.values());
        return res;
    }

    static class QueueObject {
        TreeNode node;
        int num;

        public QueueObject(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
}
