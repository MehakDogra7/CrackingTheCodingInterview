package Question450.BinaryTrees;

import java.util.ArrayList;

public class PrintAllKSumPathsInBinaryTree {

    ArrayList<ArrayList<Integer>> res;
    ArrayList<Integer> path;

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(-1);
        Node d = new Node(2);
        Node e = new Node(1);
        Node f = new Node(4);
        Node g = new Node(5);

        Node h = new Node(1);
        Node i = new Node(1);
        Node j = new Node(2);
        Node k = new Node(6);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        f.left = i;
        f.right = j;
        g.right = k;

        ArrayList<ArrayList<Integer>> res = new PrintAllKSumPathsInBinaryTree().solve(a, 5);
        res.forEach(l -> {
            l.forEach(x -> System.out.print(x + " "));
            System.out.println();
        });
    }

    private ArrayList<ArrayList<Integer>> solve(Node A, int k) {
        res = new ArrayList<>();
        path = new ArrayList<>();

        preOrder(A, k);

        return res;
    }

    private void preOrder(Node curr, int k) {
        if (curr == null) return;

        path.add(curr.data);
        preOrder(curr.left, k);
        preOrder(curr.right, k);

        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) {
                res.add(new ArrayList<>(path.subList(i, path.size())));
            }
        }
        path.remove(path.size() - 1);
    }
}
