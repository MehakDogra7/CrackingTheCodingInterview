package Question450.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);

        root.left = left;
        root.right = right;

        ArrayList<Integer> res = levelOrder(root);

        res.forEach(System.out::println);
    }

    static ArrayList<Integer> levelOrder(Node node) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            res.add(curr.data);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return res;
    }
}
