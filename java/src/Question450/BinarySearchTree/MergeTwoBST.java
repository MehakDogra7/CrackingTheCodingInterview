package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBST {

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(6);
        Node d = new Node(2);
        Node e = new Node(4);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        Node a1 = new Node(2);
        Node b1 = new Node(1);
        Node c1 = new Node(3);
        Node d1 = new Node(7);
        Node e1 = new Node(6);

        a1.left = b1;
        a1.right = c1;
        c1.right = d1;
        d1.left = e1;

        new MergeTwoBST().merge(a, a1).forEach(i -> System.out.print(i + " "));
    }

    public List<Integer> merge(Node root1, Node root2) {
        // Write your code here
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        generateInOrder(root1, l1);
        generateInOrder(root2, l2);

        int i = 0, j = 0;
        while (i < l1.size() || j < l2.size()) {
            if (j == l2.size() || (i < l1.size() && l1.get(i) < l2.get(j)))
                res.add(l1.get(i++));
            else
                res.add(l2.get(j++));
        }

        return res;
    }

    private void generateInOrder(Node curr, List<Integer> list) {
        if (curr == null) return;

        generateInOrder(curr.left, list);
        list.add(curr.data);
        generateInOrder(curr.right, list);
    }
}
