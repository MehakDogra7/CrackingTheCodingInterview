package Question450.BinaryTrees;

import java.util.*;

public class BottomViewOfBinaryTree {
    Map<Integer, Integer> map;

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

        new BottomViewOfBinaryTree().solve(a).forEach(i -> System.out.print(i + " "));
    }

    private ArrayList<Integer> solve(Node a) {
        ArrayList<Integer> res = new ArrayList<>();
        if (a == null) return res;

        map = new TreeMap<>();
        Queue<QueueObject> queue = new ArrayDeque<>();
        queue.add(new QueueObject(a, 0));

        while (!queue.isEmpty()) {
            QueueObject curr = queue.poll();
            map.put(curr.num, curr.node.data);

            if (curr.node.left != null) queue.add(new QueueObject(curr.node.left, curr.num - 1));
            if (curr.node.right != null) queue.add(new QueueObject(curr.node.right, curr.num + 1));
        }

        res = new ArrayList<>(map.values());
        return res;
    }

    static class QueueObject {
        Node node;
        int num;

        public QueueObject(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }
}
