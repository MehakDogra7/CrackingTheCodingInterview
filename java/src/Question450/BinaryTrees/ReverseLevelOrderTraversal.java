package Question450.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        a.left = b;
        a.right = c;

        ArrayList<Integer> res = new ReverseLevelOrderTraversal().reverseLevelOrder(a);

        res.forEach(System.out::println);
    }

    public ArrayList<Integer> reverseLevelOrder(Node node) {
        // code here
        Queue<Node> queue = new ArrayDeque<>();
        ArrayList<Integer> orig = new ArrayList<>();
        queue.add(node);
        queue.add(new Node(Integer.MAX_VALUE));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            orig.add(curr.data);
            if (curr.data == Integer.MAX_VALUE) {
                queue.add(curr);
                if (queue.size() == 1) break;
                continue;
            }
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }

        int start = 0;
        for (int i = 0; i < orig.size(); i++) {
            if (orig.get(i).equals(Integer.MAX_VALUE)) {
                reverse(orig, start, i - 1);
                start = i;
                orig.remove(i--);
            }
        }

        reverse(orig, 0, orig.size() - 1);
        return orig;
    }

    private void reverse(ArrayList<Integer> orig, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = orig.get(i);
            orig.set(i, orig.get(j));
            orig.set(j, temp);
        }
    }
}
