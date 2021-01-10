package Question450.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class RightViewOfBinaryTree {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        a.left = b;
        a.right = c;

        ArrayList<Integer> res = new RightViewOfBinaryTree().rightView(a);
        res.forEach(i -> System.out.print(i + " "));
    }

    ArrayList<Integer> rightView(Node root) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(new Node(Integer.MAX_VALUE));
        int last = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.data == Integer.MAX_VALUE) {
                res.add(last);
                queue.add(curr);
                if (queue.size() == 1) break;
                continue;
            }
            last = curr.data;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }

        return res;
    }
}
