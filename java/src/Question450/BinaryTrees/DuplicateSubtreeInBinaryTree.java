package Question450.BinaryTrees;

import java.util.HashMap;
import java.util.Map;

public class DuplicateSubtreeInBinaryTree {

    int t;
    Map<Integer, Integer> count;
    Map<String, Integer> trees;
    boolean ans;

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(2);
        Node f = new Node(4);
        Node g = new Node(4);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        e.left = g;


        System.out.println(new DuplicateSubtreeInBinaryTree().dupSub(a));
    }

    int dupSub(Node root) {
        // code here
        ans = false;
        t = 1;
        count = new HashMap<>();
        trees = new HashMap<>();
        lookup(root);
        return ans ? 1 : 0;
    }

    private int lookup(Node curr) {
        if (curr == null || (curr.left == null && curr.right == null)) return 0;
        String serial = curr.data + "," + lookup(curr.left) + "," + lookup(curr.right);

        if (!trees.containsKey(serial)) trees.put(serial, t++);
        int uid = trees.get(serial);

        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) >= 2) ans = true;

        return uid;
    }
}
