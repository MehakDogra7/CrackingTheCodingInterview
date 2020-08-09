package InterviewBit.TreeDataStructure;

import java.util.*;

public class ZigZagLevelOrderTraversalBT {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        //TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode k = new TreeNode(9);

        a.left = b;
        a.right = c;
        //b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        g.right = h;
        f.right = k;

        new ZigZagLevelOrderTraversalBT().zigzagLevelOrder(a).forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
        QueueObject curr = new QueueObject(0, A);
        Queue<QueueObject> queue = new ArrayDeque<>();
        queue.add(curr);
        while (curr != null) {
            int level = curr.level;
            if (map.containsKey(level)) map.get(level).add(curr.treeNode.val);
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.treeNode.val);
                map.put(level, temp);
            }

            if (curr.treeNode.left != null) queue.add(new QueueObject(level + 1, curr.treeNode.left));
            if (curr.treeNode.right != null) queue.add(new QueueObject(level + 1, curr.treeNode.right));

            queue.poll();
            curr = queue.peek();
        }

        boolean flag = true;
        for (ArrayList<Integer> value : map.values()) {
            if (!flag) Collections.reverse(value);
            result.add(value);
            flag = !flag;
        }

        return result;
    }

    class QueueObject {
        Integer level;
        TreeNode treeNode;

        public QueueObject(Integer level, TreeNode treeNode) {
            this.level = level;
            this.treeNode = treeNode;
        }
    }
}
