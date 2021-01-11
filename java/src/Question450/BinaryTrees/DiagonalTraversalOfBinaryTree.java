package Question450.BinaryTrees;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraversalOfBinaryTree {
    Map<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        new DiagonalTraversalOfBinaryTree().solve(a).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> solve(Node a) {
        ArrayList<Integer> res = new ArrayList<>();
        if (a == null) return res;
        map = new TreeMap<>();

        preOrder(a, 0);

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            res.addAll(entry.getValue());
        }

        return res;
    }

    private void preOrder(Node curr, int i) {
        if (curr == null) return;

        ArrayList<Integer> temp = map.getOrDefault(i, new ArrayList<>());
        temp.add(curr.data);
        map.put(i, temp);

        preOrder(curr.left, i + 1);
        preOrder(curr.right, i);
    }
}
