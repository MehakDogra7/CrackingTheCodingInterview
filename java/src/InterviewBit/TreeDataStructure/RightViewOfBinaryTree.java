package InterviewBit.TreeDataStructure;

import java.util.*;

public class RightViewOfBinaryTree {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        g.right = h;

        new RightViewOfBinaryTree().solve(a).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
        Queue<QueueObject> queue = new ArrayDeque<>();
        QueueObject curr = new QueueObject(0, A);
        queue.add(curr);
        while (curr != null) {
            int level = curr.level;

            if (map.containsKey(level)) {
                map.get(level).add(curr.node.val);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.node.val);
                map.put(level, temp);
            }

            if (curr.node.left != null) queue.add(new QueueObject(curr.level + 1, curr.node.left));
            if (curr.node.right != null) queue.add(new QueueObject(curr.level + 1, curr.node.right));
            queue.poll();
            curr = queue.peek();

        }

        for (ArrayList<Integer> value : map.values()) {
            result.add(value.get(value.size() - 1));
        }

        return result;
    }

    class QueueObject {
        Integer level;
        TreeNode node;

        public QueueObject(Integer level, TreeNode node) {
            this.level = level;
            this.node = node;
        }


    }
}
