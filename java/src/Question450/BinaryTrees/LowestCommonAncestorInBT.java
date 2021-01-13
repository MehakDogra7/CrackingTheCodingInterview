package Question450.BinaryTrees;

import java.util.ArrayList;

public class LowestCommonAncestorInBT {

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

        System.out.println(new LowestCommonAncestorInBT().lca(a, 6, 8).data);
    }

    public Node lca(Node root, int n1, int n2) {
        // Your code here
        ArrayList<Node> n1List = new ArrayList<>();
        ArrayList<Node> n2List = new ArrayList<>();

        boolean foundN1 = findPath(root, n1, n1List);
        boolean foundN2 = findPath(root, n2, n2List);

        if (!foundN1 && !foundN2) return null;
        else if (foundN1 && foundN2) {
            Node common = root;
            int i = 0, j = 0;
            while (i < n1List.size() && j < n2List.size() &&
                    n1List.get(i) == n2List.get(j)) {
                common = n1List.get(i);
                i++;
                j++;
            }
            return common;
        } else if (foundN1) {
            if (n1List.size() > 1 && n1List.get(1) == root.left) return root.left;
            return null;
        } else {
            if (n2List.size() > 1 && n2List.get(1) == root.left) return root.left;
            return null;
        }
    }

    private boolean findPath(Node curr, int num, ArrayList<Node> list) {
        if (curr == null) return false;
        if (curr.data == num) {
            list.add(curr);
            return true;
        }

        list.add(curr);
        boolean left = findPath(curr.left, num, list);
        if (left) return true;
        boolean right = findPath(curr.right, num, list);
        if (right) return true;

        list.remove(list.size() - 1);
        return false;
    }
}
