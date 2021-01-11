package Question450.BinaryTrees;

import java.util.*;

public class ZigZagTraversal {

    Map<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        g.right = h;

        new ZigZagTraversal().zigZagTraversal(a).forEach(i -> System.out.print(i + " "));
    }

    ArrayList<Integer> zigZagTraversal(Node a) {
        ArrayList<Integer> res = new ArrayList<>();
        if (a == null) return res;
        map = new TreeMap<>();
        Queue<QueueObject> queue = new ArrayDeque<>();
        queue.add(new QueueObject(a, 0));

        while (!queue.isEmpty()) {
            QueueObject curr = queue.poll();

            ArrayList<Integer> temp = map.getOrDefault(curr.level, new ArrayList<>());
            temp.add(curr.node.data);
            map.put(curr.level, temp);

            if (curr.node.left != null) queue.add(new QueueObject(curr.node.left, curr.level + 1));
            if (curr.node.right != null) queue.add(new QueueObject(curr.node.right, curr.level + 1));
        }

        boolean flag = true;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> curr = entry.getValue();
            if (flag) res.addAll(curr);
            else {
                for (int i = curr.size() - 1; i >= 0; i--) {
                    res.add(curr.get(i));
                }
            }
            flag = !flag;
        }

        return res;
    }

    static class QueueObject {
        Node node;
        int level;

        public QueueObject(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
